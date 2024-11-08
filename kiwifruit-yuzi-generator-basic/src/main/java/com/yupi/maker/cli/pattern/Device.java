package com.yupi.maker.cli.pattern;

import lombok.RequiredArgsConstructor;

/**
 * @Author fang
 * @Date 2024/11/5 14:58
 * @注释
 */
public class Device {

    private String name;

    public Device(String name){
        this.name = name;
    }

    public void turnOn(){
        System.out.println(name + "被打开");
    }

    public void turnOff(){
        System.out.println(name + "被关闭");
    }



}
