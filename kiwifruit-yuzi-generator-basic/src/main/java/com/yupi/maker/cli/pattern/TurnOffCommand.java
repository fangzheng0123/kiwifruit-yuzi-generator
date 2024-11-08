package com.yupi.maker.cli.pattern;

/**
 * @Author fang
 * @Date 2024/11/5 15:02
 * @注释
 */
public class TurnOffCommand implements Command{
    private Device device;
    public TurnOffCommand(Device device){
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnOff();
    }
}
