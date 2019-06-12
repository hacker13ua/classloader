package org.esurovskiy.cl;

public class CatMainCreator {
    public static void main(String[] args) throws Exception {
        while (true) {
            Thread.sleep(1000);
            final CatLoader catLoader = new CatLoader();
            final Class<?> catClass = Class.forName(
                    "org.esurovskiy.cl.Cat",
                    true, catLoader);
            catClass.newInstance();

        }
    }
}
