package com.yupi;

import com.yupi.cli.command.ConfigCommand;
import com.yupi.cli.command.GeneratorCommand;
import com.yupi.cli.command.ListCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "fz",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{
    private final CommandLine commandLine;
    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GeneratorCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }
    @Override
    public void run() {
        System.out.println("请输入具体指令，或者输入 --help 查看命令提示");
    }

//    执行命令
    public Integer doExecute(String[] args){
        return commandLine.execute(args);
    }
}
