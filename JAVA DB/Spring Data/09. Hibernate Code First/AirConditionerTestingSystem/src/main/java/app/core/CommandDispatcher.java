package app.core;

import app.annotations.Inject;
import app.core.commands.Command;
import app.services.AirConditionerService;
import app.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CommandDispatcher implements Dispatcher {

    private Map<String, Object> mapper;

    private final AirConditionerService airConditionerService;

    private final ReportService reportService;

    private static final String COMMANDS_PACKAGE = Command.class.getPackage().getName() + ".";
    private static final String COMMAND_SUFFIX = "Command";

    @Autowired
    public CommandDispatcher(AirConditionerService airConditionerService, ReportService reportService) {
        this.airConditionerService = airConditionerService;
        this.reportService = reportService;

        this.initMapper();
    }

    @Override
    public Command dispatch(String commandType, String[] commandTokens) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> currentCommandClass = Class.forName(COMMANDS_PACKAGE + commandType + COMMAND_SUFFIX);
        Constructor<?> constructor = currentCommandClass.getConstructor(String[].class);
        constructor.setAccessible(true);
        Command command = (Command) constructor.newInstance((Object) commandTokens);

        this.inject(command, currentCommandClass);

        return command;
    }

    private void inject(Command command, Class<?> commandClass) throws IllegalAccessException {
        Field[] declaredFields = commandClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.isAnnotationPresent(Inject.class)) {
                String str = declaredField.getType().getSimpleName();
                Object object = this.mapper.get(str);
                declaredField.set(command, object);
            }
        }
    }

    private void initMapper() {
        this.mapper = new HashMap<>();
        this.mapper.put(AirConditionerService.class.getSimpleName(), this.airConditionerService);
        this.mapper.put(ReportService.class.getSimpleName(), this.reportService);
    }
}
