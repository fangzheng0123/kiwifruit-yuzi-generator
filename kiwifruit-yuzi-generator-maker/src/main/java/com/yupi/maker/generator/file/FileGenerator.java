package com.yupi.maker.generator.file;

import com.yupi.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @Author fang
 * @Date 2024/11/4 15:59
 * @注释
 */
public class FileGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        DataModel mainTemplateConfig = new DataModel();
        mainTemplateConfig.setAuthor("fang");
        mainTemplateConfig.setOutputText("结果：");
        mainTemplateConfig.setLoop(false);
        doGenerator(mainTemplateConfig);
    }

    public static void doGenerator(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");

//        输入路径，ACM代码模板目录
        String inputPath = new File(projectPath, "kiwifruit-yuzi-demo-generator/acm-template").getAbsolutePath();
        String outputPath = new File(projectPath,"kiwifruit-yuzi-generator-maker").getAbsolutePath();
        StaticFileGenerator.copyFilesByHutool(inputPath,outputPath);

        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        String projectDynamicPath = projectPath +File.separator+"kiwifruit-yuzi-generator-maker";
//        复制文件的源目录
        String inputDynamicPath = projectDynamicPath + File.separator+"src/main/resources/template/MainTemplate.java.ftl";
//        备份文件所在位置
        String outputDynamicPath = projectDynamicPath+File.separator+"acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputDynamicPath,outputDynamicPath,model);
    }
}
