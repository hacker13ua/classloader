package org.esurovskiy.cl;

public class Student extends Person {
    private String group;

    @AnnotationExample(param1 = "Hello", param2 = 100)
    public String getGroup() {
        return group;
    }
}
