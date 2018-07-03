package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Animal cat = new Cat("Lockemo");
                Animal dog = new Dog("LockemoKiller");

                registry = LocateRegistry.createRegistry(2099);

                Remote catStub = UnicastRemoteObject.exportObject(cat, 2099);
                Remote dogStub = UnicastRemoteObject.exportObject(dog, 2099);

                registry.bind("cat", catStub);
                registry.bind("dog", dogStub);

            } catch (RemoteException | AlreadyBoundException e) {
               System.err.println(e);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(2000);
        //start client
        CLIENT_THREAD.start();
    }
}
