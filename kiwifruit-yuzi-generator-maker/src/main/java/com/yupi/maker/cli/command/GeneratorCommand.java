package com.yupi.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yupi.maker.generator.file.FileGenerator;
import com.yupi.maker.model.DataModel;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * @Author fang
 * @Date 2024/11/5 16:15
 * @注释
 */
@Data
@CommandLine.Command(name = "generator",description = "生成代码",mixinStandardHelpOptions = true)
public class GeneratorCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-a","--author"},arity = "0..1",description = "作者",interactive = true,echo = true)
    private String author = "fang";

    @CommandLine.Option(names = {"-o","--outputText"},arity = "0..1",description = "输出结果",interactive = true,echo = true)
    private String outputText = "输出结果";

    @CommandLine.Option(names = {"-l","--loop"},arity = "0..1",description = "是否循环",interactive = true,echo = true)
    private boolean loop = false;

    @Override
    public Integer call() throws Exception {
        DataModel mainTemplateConfig = new DataModel();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        FileGenerator.doGenerator(mainTemplateConfig);
        return 0;
    }
}
