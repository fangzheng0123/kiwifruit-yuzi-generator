package com.yupi.maker.generator.file;

import cn.hutool.core.io.FileUtil;
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
public class DynamicFileGenerator {

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

//        如果文件不存在则创建目录 FileUtil.exist(outputPath)如果outputPath为空就运行if语句
//        !FileUtil.exist(outputPath)如果outputPath不为空就运行if语句
        if (!FileUtil.exist(outputPath)){
            FileUtil.touch(outputPath);
        }
        Writer out = new FileWriter(outputPath);
        template.process(model,out);
        out.close();
    }

}
