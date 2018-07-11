package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

import static com.javarush.task.task26.task2613.Operation.*;

public class CommandExecutor {

    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<Operation, Command>(){{
        put(LOGIN, new LoginCommand());
        put(INFO, new InfoCommand());
        put(DEPOSIT, new DepositCommand());
        put(WITHDRAW, new WithdrawCommand());
        put(EXIT, new ExitCommand());
    }};

    private CommandExecutor() {
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        allKnownCommandsMap.get(operation).execute();
    }

}
