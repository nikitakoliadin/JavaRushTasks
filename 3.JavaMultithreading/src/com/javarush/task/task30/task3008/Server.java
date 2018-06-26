package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.javarush.task.task30.task3008.ConsoleHelper.readInt;
import static com.javarush.task.task30.task3008.ConsoleHelper.writeMessage;
import static com.javarush.task.task30.task3008.MessageType.*;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    private static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            writeMessage(String.format("Connected, socket address: %s", socket.getRemoteSocketAddress()));

            String userName = null;

            try(Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);

            } catch (IOException | ClassNotFoundException e) {
                writeMessage("Error communicating with the sever!");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(USER_REMOVED, userName));
                    writeMessage("Connection closed!");
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message;
            String name;

            do {
                do {
                    connection.send(new Message(NAME_REQUEST));
                    message = connection.receive();
                } while (message.getType() != USER_NAME);

                name = message.getData();

            } while (name.equals("") || connectionMap.containsKey(name));

            connectionMap.put(name, connection);
            connection.send(new Message(NAME_ACCEPTED));

            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            connectionMap.forEach((name, v) -> {
                if (!name.equals(userName)) {
                    try {
                        connection.send(new Message(USER_ADDED, name));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == TEXT) {
                    Message newMessage = new Message(TEXT, String.format("%s: %s", userName, message.getData()));

                    sendBroadcastMessage(newMessage);
                } else {
                    writeMessage("Input error!");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        connectionMap.forEach((k, v) -> {
            try {
                v.send(message);
            } catch (IOException e) {
                writeMessage("Can't send message!");
            }
        });
    }

    public static void main(String[] args) {
        final int port = readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            writeMessage("Server was run successful!");

            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            writeMessage(e.getMessage());
        }

    }
}
