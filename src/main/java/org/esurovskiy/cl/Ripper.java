package org.esurovskiy.cl;

import java.lang.reflect.Field;

public class Ripper {
    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException {
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
    }
}
