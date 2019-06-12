package org.esurovskiy.cl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FieldVisitor {
    public static void main(String[] args) {
        printAllFields(HashSet.class);
    }

    @Override
    @AnnotationExample(param1 = "strin", param2 = 22)
    public String toString() {
        return super.toString();
    }

    @SuppressWarnings("deprecation")
    public static void printAllFields(Class clazz) {
        System.out.println("Fields in " + clazz.getSimpleName());
        for (Field declaredField : clazz.getDeclaredFields()) {
            System.out.println(declaredField.getType()
                    .getSimpleName() + " "
                    + declaredField.getName());
        }
        final Class superclass = clazz.getSuperclass();
        if (superclass != null) {
            printAllFields(superclass);
        }
        final Date date = new Date(119, 1, 1);
    }
}
