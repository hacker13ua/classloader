package org.esurovskiy.cl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CatLoader extends ClassLoader {
    private static final String PATH = "/home/esurovskiy/dev/Cat.class";

    @Override
    public Class<?> loadClass(final String name) throws ClassNotFoundException {
        Class c = findLoadedClass(name);
        if (c == null) {
            try {
                c = getParent().loadClass(name);
            } catch (ClassNotFoundException e) {
            }
        }
        if (c == null) {
            c = findClass(name);
        }
        return c;
    }

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        Class c = null;
        try {
            final byte[] fileAsBytes = getFileAsBytes(PATH);
            c = defineClass(name, fileAsBytes, 0, fileAsBytes.length);
        } catch (Exception e) {
            System.out.println(name);
            throw new RuntimeException(e);
        }
        return c;
    }

    byte[] getFileAsBytes(String path) throws IOException {
        final File file = new File(path);
        byte[] result = new byte[(int) file.length()];
        try (FileInputStream is = new FileInputStream(file)) {
            is.read(result, 0, result.length);
        }
        return result;
    }

}
