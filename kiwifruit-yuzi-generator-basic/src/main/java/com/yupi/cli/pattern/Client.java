package com.yupi.cli.pattern;


/**
 * @Author fang
 * @Date 2024/11/5 15:10
 * @注释
 */
public class Client {
    public static void main(String[] args) {
        Device tv = new Device("tv");
        Device mv = new Device("mv");

        TurnOnCommand turnOnCommand = new TurnOnCommand(tv);
        TurnOffCommand turnOffCommand = new TurnOffCommand(mv);
        System.out.println(turnOffCommand);
        System.out.println(turnOnCommand);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();
    }
}
