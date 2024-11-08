package com.yupi.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

/**
 * @Author fang
 * @Date 2024/11/5 16:19
 * @注释
 */
@CommandLine.Command(name = "list",description = "查看文件列表",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {
        String property = System.getProperty("user.dir");
        String inputPath = new File(property, "kiwifruit-yuzi-demo-generator/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files){
            System.out.println(file);
        }


    }
}
