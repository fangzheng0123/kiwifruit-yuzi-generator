package com.yupi.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * @Author fang
 * @Date 2024/11/2 15:46
 * @注释
 */
public class StaticFileGenerator {

    public static void copyFilesByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }

}
