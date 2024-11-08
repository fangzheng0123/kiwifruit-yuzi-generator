package com.yupi.maker.generator;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @Author fang
 * @Date 2024/11/2 15:46
 * @注释
 */
public class StaticGenerator {

    public static void main(String[] args) {
//        获取整个项目的根目录
        String projectPath = System.getProperty("user.dir");

//        输入路径，ACM代码模板目录
        String inputPath = new File(projectPath, "kiwifruit-yuzi-demo-generator/acm-template").getAbsolutePath();
        String outputPath = new File(projectPath,"kiwifruit-yuzi-generator-basic").getAbsolutePath();
        copyFilesByRecursive(inputPath,outputPath);
//        FileUtil.copy(inputPath,outputPath,false);
    }

    public static void copyFilesByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }

//    使用递归的方式获取文件

    public static void copyFilesByRecursive(String inputPath, String outputPath){
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);

        try {
            copyFilesByRecursive(inputFile,outputFile);
        } catch (Exception e) {
            System.err.println("文件复制失败");
            e.printStackTrace();
        }
    }

    private static void copyFilesByRecursive(File inputFile, File outputFile) throws IOException {
//        区分是文件还是目录
        if (inputFile.isDirectory()){
            File destOutputFile = new File(outputFile,inputFile.getName());
//            如果文件是否存在
            if (!destOutputFile.exists()){
//                创建文件
                destOutputFile.mkdirs();
            }
//            递归获取源文件的所有文件
            File[] files = inputFile.listFiles();
//            没有子文件，直接结束
            if (ArrayUtil.isEmpty(files)){
                return;
            }
            for (File file : files){
                copyFilesByRecursive(file,destOutputFile);
            }
        }else {
//            是文件直接复制到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
//            在此指定不复制的文件
//            if (inputFile.getName().equals("README.md")){
//                System.out.println("不输出");
//            }else {
                Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
//            }
        }
    }

}
