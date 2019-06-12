package org.esurovskiy.cl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Ripper {
    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final Field[] fields = MyTestClass.class.getFields();
        for (final Field field : fields) {
            final Class<?> type = field.getType();
            final String name = field.getName();
            System.out.println(type + ": " + name);
        }
        System.out.println("+++++++++++++++++++++++");
        final Field[] declaredFields =
                MyTestClass.class.getDeclaredFields();
        for (final Field field : declaredFields) {
            final Class<?> type = field.getType();
            final String name = field.getName();
            System.out.println(type + ": " + name);
        }
        final Field fieldA =
                MyTestClass.class.getDeclaredField("a");
        fieldA.setAccessible(true);
        final MyTestClass instance = new MyTestClass();
        final int a = fieldA.getInt(instance);
        System.out.println(a);

        fieldA.setInt(instance, 100);
        System.out.println(instance.getA());
        System.out.println("METHODS!!!!!!!!");
        Method[] methods = MyTestClass.class.getDeclaredMethods();
        for (final Method method : methods) {
            System.out.println("name: " + method.getName());
            System.out.println("Return type:"
                    + method.getReturnType());
            System.out.println(Arrays.toString(
                    method.getParameters()));
        }

        System.out.println(Object.class.getSuperclass());

        Method setStrField = MyTestClass.class
                .getDeclaredMethod("setStrField",
                        String.class);
        setStrField.setAccessible(true);
        final Object res = setStrField
                .invoke(instance,
                        "Измененное значение");
        System.out.println(res);

        Method getStrField
                = MyTestClass.class
                .getDeclaredMethod("getStrField");
        getStrField.setAccessible(true);
        Object result = getStrField.invoke(instance);
        System.out.println("RESULT:" + result);
    }
}
