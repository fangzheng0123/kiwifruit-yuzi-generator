package com.yupi.maker.cli.pattern;

/**
 * @Author fang
 * @Date 2024/11/5 15:08
 * @注释
 */
public class RemoteControl {

    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton(){
        command.execute();
    }

}
