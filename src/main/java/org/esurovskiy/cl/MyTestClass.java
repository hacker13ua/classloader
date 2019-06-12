package org.esurovskiy.cl;


public class MyTestClass {
    public String strField = " string";
    protected int b = 1;
    private int a = 10;

    public MyTestClass(){
    }

    public MyTestClass(int a){
        this.a = a;
    }

    public MyTestClass(final int b, final int a) {
        this.b = b;
        this.a = a;
    }

    private String getStrField() {
        return strField;
    }

    public void setStrField(final String strField) {
        this.strField = strField;
    }

    public int getB() {
        return b;
    }

    public void setB(final int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(final int a) {
        this.a = a;
    }
}
