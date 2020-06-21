package com.kaczmar.HomeworkLinux;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LinuxCommandApps {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome in Linux BASH simulator");
        String currentPath = currentPath();
        boolean isProgramWorking = true;
        while (isProgramWorking) {
            System.out.println("Your current path: " + currentPath);
            String command = scanner.nextLine();
            String[] commandArray = command.split(" ");
            if(command.equals(LinuxCommand.cdback.getCommand())){
                commandArray[0] = command;
            }
            LinuxCommand linuxCommand = findCorrectLinuxCommend(commandArray[0]);
            switch (linuxCommand) {
                case cd:
                    if (isCommandProvidedCorrectly(commandArray) && !commandArray[1].equals("..")) {
                        currentPath = goToPath(currentPath, commandArray[1]);
                    }
                    break;
                case ls:
                    printAllFilesInDirectory(currentPath);
                    break;
                case mkdir:
                    if (isCommandProvidedCorrectly(commandArray)) {
                        createFolder(commandArray[1]);
                    }else{
                        System.out.println("You have to provide folder name. Example: touch catalogName");
                    }
                    break;
                case touch:
                    if (isCommandProvidedCorrectly(commandArray)) {
                        createFile(currentPath, commandArray[1]);
                    }else{
                        System.out.println("You have to provide folder name. Example: touch fileName");
                    }
                    break;
                case cdback:
                    currentPath = getParentPath(currentPath);
                    break;
                case exit:
                    isProgramWorking = false;
                    break;
                default:
                    System.out.println("This command is incorrect, try again");
                    break;
            }
        }
    }

    private static String currentPath() {
        return System.getProperty("user.dir");
    }

    private static LinuxCommand findCorrectLinuxCommend(String providedCommend) {
        LinuxCommand[] linuxCommends = LinuxCommand.values();
        for (LinuxCommand commend : linuxCommends) {
            if (commend.getCommand().equals(providedCommend)) {
                return commend;
            }
        }
        return null;
    }

    private static void createFolder(String providedName) {
        File file = new File(providedName);
        boolean isCreated = file.mkdir();
        if (isCreated) {
            System.out.println("File created succcessfully");
        } else {
            System.out.println("Error during creation folder");
        }
    }

    private static void createFile(String currentPath, String providedName) {
        File file = new File(currentPath + "\\" + providedName);
        try {
            boolean isCreated = file.createNewFile();
            if (isCreated) {
                System.out.println("File created succcessfully");
            }
        } catch (IOException e) {
            System.out.println("We have an error: " + e.getMessage());
        }
    }

    private static boolean isCommandProvidedCorrectly(String[] commandArray) {
        boolean result = commandArray.length >= 2;
        return result;
    }

    private static void printAllFilesInDirectory(String providedName) {
        {
            File file = new File(providedName);
            File[] files = file.listFiles();
            if (files == null) {
                System.out.println(" ");
                return;
            }
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    System.out.println("\\" + file1.getName() + "\\");
                } else {
                    System.out.println("\\" + file1.getName());
                }
            }
        }
    }

    private static String getParentPath(String currentPath) throws IOException {
        File file = new File(currentPath);
        String parent = file.getParent();
        return parent;
    }

    private static String goToPath(String currentPath, String folder) throws IOException {
        File file = new File(currentPath + "\\" + folder);
        return file.getCanonicalPath();
    }

}

