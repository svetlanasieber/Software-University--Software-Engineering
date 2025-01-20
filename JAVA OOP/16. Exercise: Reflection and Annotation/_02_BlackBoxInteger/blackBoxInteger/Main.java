package _02_Exercise._02_BlackBoxInteger.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true); 
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] inputArr = input.split("_");
            String command = inputArr[0];
            int parameter = Integer.parseInt(inputArr[1]);

            Method method = Arrays.stream(methods).filter(m->m.getName().equals(command)).findFirst().get();
            method.setAccessible(true);
            method.invoke(blackBoxInt,parameter);

            System.out.println(innerValue.getInt(blackBoxInt));

            input = scanner.nextLine();
        }

    }
}
