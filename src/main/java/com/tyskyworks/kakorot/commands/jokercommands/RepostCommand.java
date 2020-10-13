package com.tyskyworks.kakorot.commands.jokercommands;

import com.tyskyworks.kakorot.Config;
import com.tyskyworks.kakorot.commands.CommandContext;
import com.tyskyworks.kakorot.commands.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.io.File;

public class RepostCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        TextChannel channel = ctx.getChannel();
        channel.sendFile(new File("src/main/java/com/tyskyworks/kakorot/commands/jokercommands/assets/repost.png")).queue();
    }

    @Override
    public String getName() {
        return "repost";
    }

    @Override
    public String getHelp() {
        return  "Usage:" + Config.get("PREFIX") + "repost (Use when we've seen this shit already)";
    }
}