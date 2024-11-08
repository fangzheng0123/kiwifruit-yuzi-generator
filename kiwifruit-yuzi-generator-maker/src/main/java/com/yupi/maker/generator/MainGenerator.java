package com.yupi.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.yupi.maker.generator.file.DynamicFileGenerator;
import com.yupi.maker.generator.file.FileGenerator;
import com.yupi.maker.meta.Meta;
import com.yupi.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @Author fang
 * @Date 2024/11/8 12:50
 * @注释
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        Meta meta = MetaManager.getMetaObject();

//        动态生成文件
        String property = System.getProperty("user.dir");
        // D:\IDEAProjectSpace\kiwifruit-yuzi-generator\kiwifruit-yuzi-generator-maker
        String projectPath = property + File.separator + "kiwifruit-yuzi-generator-maker";
        String outputPath = projectPath + File.separator+"generator"+ File.separator + meta.getName();
        if (!FileUtil.exist(outputPath)){
            FileUtil.mkdir(outputPath);
        }
//        读取resource文件
        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcePath = classPathResource.getAbsolutePath();


        String inputPath = inputResourcePath  +"template/java/model/DataModel.java.ftl";
        System.out.println(inputPath);
        String replace = meta.getBasePackage().replace(".", "/");
        String outputFilePath =outputPath + File.separator+"src/main/java"+ File.separator + replace + File.separator + "model/DataModel.java" ;

        DynamicFileGenerator.doGenerate(inputPath,outputFilePath,meta);
//        config子命令
        String inputConfigPath = inputResourcePath  +"template/java/cli/command/ConfigCommand.java.ftl";
        String outputConfigFilePath =outputPath + File.separator+"src/main/java"+ File.separator + replace + File.separator + "cli/command/DataModel.java" ;
        DynamicFileGenerator.doGenerate(inputConfigPath,outputConfigFilePath,meta);
//        generator
        String inputGeneratorPath = inputResourcePath  +"template/java/cli/command/GeneratorCommand.java.ftl";
        String outputGeneratorFilePath =outputPath + File.separator+"src/main/java"+ File.separator + replace + File.separator + "cli/command/GeneratorCommand.java" ;
        DynamicFileGenerator.doGenerate(inputGeneratorPath,outputGeneratorFilePath,meta);

//        list
        String inputListPath = inputResourcePath  +"template/java/cli/command/ListCommand.java.ftl";
        String outputListFilePath =outputPath + File.separator+"src/main/java"+ File.separator + replace + File.separator + "cli/command/ListCommand.java" ;
        DynamicFileGenerator.doGenerate(inputListPath,outputListFilePath,meta);
//        主命令
        String inputCommandPath = inputResourcePath  +"template/java/CommandExecutor.java.ftl";
        String outputCommandFilePath =outputPath + File.separator+"src/main/java"+ File.separator + replace + File.separator + "CommandExecutor.java" ;
        DynamicFileGenerator.doGenerate(inputCommandPath,outputCommandFilePath,meta);

//        启动类
        String inputMainPath = inputResourcePath  +"template/java/Main.java.ftl";
        String outputMainFilePath =outputPath + File.separator+"src/main/java"+ File.separator + replace + File.separator + "Main.java" ;
        DynamicFileGenerator.doGenerate(inputMainPath,outputMainFilePath,meta);
    }
}
