package com.yupi.maker;

/**
 * @Author fang
 * @Date 2024/11/5 16:41
 * @注释
 */
public class Main {

    public static void main(String[] args) {

//        args = new String[]{"generator","-l","-a","-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
//        args = new String[]{"--help"};

        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
