package org.esurovskiy.cl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class StudentMain {
    public static void main(String[] args) throws NoSuchMethodException {
        Student student = new Student();
        Method getGroupMethod =
                Student.class.getMethod("getGroup");
        Annotation[] annotations = getGroupMethod.getAnnotations();
        for (final Annotation annotation : annotations) {
            annotation.annotationType();
        }
        if (getGroupMethod
                .isAnnotationPresent(AnnotationExample.class)) {
            AnnotationExample annotation
                    = getGroupMethod
                    .getAnnotation(AnnotationExample.class);
            System.out.println(annotation.param1());
            System.out.println(annotation.param2());
        }
    }
}
