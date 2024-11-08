package com.yupi.maker.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.yupi.maker.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

/**
 * @Author fang
 * @Date 2024/11/5 16:19
 * @注释
 */
@CommandLine.Command(name = "config",description = "查看参数信息",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{

    @Override
    public void run() {
        System.out.println("查看参数信息");
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称："+field.getName());
            System.out.println("字段类型："+field.getType());
        }
    }
}
