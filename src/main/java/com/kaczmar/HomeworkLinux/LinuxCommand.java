package com.kaczmar.HomeworkLinux;

public enum LinuxCommand {
    cd("cd"),
    cdback("cd .."),
    ls("ls"),
    mkdir("mkdir"),
    touch("touch"),
    exit("exit");

    String command;

    LinuxCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
