package com.yupi.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@CommandLine.Command(name = "list",description = "查看文件列表",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {
        String inputPath = D:/IDEAProjectSpace/kiwifruit-yuzi-generator/kiwifruit-yuzi-demo-generator/acm-template-pro
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files){
            System.out.println(file);
        }
    }
}
