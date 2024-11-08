package com.yupi.cli.pattern;

/**
 * @Author fang
 * @Date 2024/11/5 15:07
 * @注释
 */
public class TurnOnCommand implements Command{
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
