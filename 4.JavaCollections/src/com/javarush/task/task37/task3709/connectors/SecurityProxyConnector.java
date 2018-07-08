package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {

    private SimpleConnector simpleConnector;
    private SecurityChecker securityChecker;

    private String resourceString;

    public SecurityProxyConnector(String resourceString) {
        this.resourceString = resourceString;

        simpleConnector = new SimpleConnector(resourceString);
        securityChecker = new SecurityCheckerImpl();
    }

    @Override
    public void connect() {
        boolean isChecked = securityChecker.performSecurityCheck();

        if (isChecked) {
            simpleConnector.connect();
        }
    }
}
