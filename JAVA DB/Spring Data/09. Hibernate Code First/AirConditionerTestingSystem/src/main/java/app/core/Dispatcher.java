package app.core;

import app.core.commands.Command;

import java.lang.reflect.InvocationTargetException;

public interface Dispatcher {

    Command dispatch(String commandType, String[] commandTokens)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
