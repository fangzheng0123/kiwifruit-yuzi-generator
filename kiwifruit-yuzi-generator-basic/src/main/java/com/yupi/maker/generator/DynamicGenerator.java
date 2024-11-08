package com.yupi.maker.generator;

import com.yupi.maker.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Author fang
 * @Date 2024/11/4 11:44
 * @注释
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {

        String projectPath = System.getProperty("user.dir")+File.separator+"kiwifruit-yuzi-generator-basic";
//        复制文件的源目录
        String inputPath = projectPath + File.separator+"src/main/resources/template/MainTemplate.java.ftl";
//        备份文件所在位置
        String outputPath = System.getProperty("user.dir")+File.separator+ "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("fang");
        mainTemplateConfig.setOutputText("结果：");
        mainTemplateConfig.setLoop(true);
        doGenerate(inputPath,outputPath,mainTemplateConfig);
    }

    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        File templateDir = new File(inputPath).getParentFile();
// 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(templateDir);
// http://freemarker.foofun.cn/app_faq.html#faq_number_grouping可以直接查看官方文档来解决
// 删除2,023中的逗号
        configuration.setNumberFormat("0.######");
// 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
// 创建模板对象，加载指定模板
        Template template = configuration.getTemplate(new File(inputPath).getName());
        Writer out = new FileWriter(outputPath);
        template.process(model,out);
        out.close();
    }

}
