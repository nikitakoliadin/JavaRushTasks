package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.Message;

import java.io.IOException;
import java.net.Socket;

import static com.javarush.task.task30.task3008.ConsoleHelper.readInt;
import static com.javarush.task.task30.task3008.ConsoleHelper.readString;
import static com.javarush.task.task30.task3008.ConsoleHelper.writeMessage;
import static com.javarush.task.task30.task3008.MessageType.*;

public class Client {

    protected Connection connection;

    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

        @Override
        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();

            try(Socket socket = new Socket(serverAddress, serverPort);) {
                connection = new Connection(socket);

                clientHandshake();
                clientMainLoop();

            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message) {
            writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            writeMessage(String.format("User %s was connected to the chat!", userName));
        }

        protected void informAboutDeletingNewUser(String userName) {
            writeMessage(String.format("User %s was unconnected from the chat!", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == NAME_REQUEST) {
                    String name = getUserName();
                    Message newMessage = new Message(USER_NAME, name);
                    connection.send(newMessage);
                } else if (message.getType() == NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                writeMessage("Error while waiting! Exit of the program!");
                return;
            }
        }

        if (clientConnected) {
            writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            writeMessage("Произошла ошибка во время работы клиента.");
        }

        while (clientConnected) {
            String test = readString();

            if (test.equals("exit")) {
                break;
            }

            if (shouldSendTextFromConsole()) {
                sendTextMessage(test);
            }
        }
    }

    protected String getServerAddress() {
        return readString();
    }

    protected int getServerPort() {
        return readInt();
    }

    protected String getUserName() {
        return readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(TEXT, text));
        } catch (IOException e) {
            clientConnected = false;
            writeMessage("Error while send text message!");
        }
    }

    public static void main(String[] args) {
        new Client().run();
    }
}
