package org.esurovskiy.cl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FileManager {
    private final String PERMISSION = "WRITE";
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        String command = "mkdir";
        String parameter = "/home/";
        final FileManager fileManager = new FileManager();
        magic(fileManager, command, parameter);
    }

    private static void magic(FileManager fm,
                              final String command,
                              final String parameter) throws InvocationTargetException, IllegalAccessException {
        for (Method method : FileManager.class.getMethods()) {
            if (method.isAnnotationPresent(Command.class)) {
                Command commandAnnotation =
                        method.getAnnotation(Command.class);
                String value = commandAnnotation.fileManagerCommand();
                if (value.equals(command)) {
                    method.invoke(fm, parameter);
                }
            }
        }
    }

    @Command(fileManagerCommand = "mkdir")
    @Permission("WRITE")
    public void mkDir(String parameter) {
        System.out.println("mkdir " + parameter);
    }

    @Command(fileManagerCommand = "ls")
    public void ls(String parameter) {
        System.out.println("invoke method ls " + parameter);
    }

    @Command(fileManagerCommand = "fileSize")
    public void fileSize(String parameter) {

    }

    @Command(fileManagerCommand = "rm")
    public void rm(String parameter) {

    }
}
