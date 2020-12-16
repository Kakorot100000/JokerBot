package com.tyskyworks.kakorot.commands.music.logging;

import com.tyskyworks.kakorot.commands.CommandContext;
import com.tyskyworks.kakorot.commands.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ShowLogCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        File musiclog = new File("src/main/java/com/tyskyworks/kakorot/musiclog.txt");

        EmbedBuilder list = new EmbedBuilder();
        list.setColor(0xf51707);
        list.setTitle("🥞 **__Music Log__** 🥞");

        try{
            BufferedReader log = new BufferedReader(new FileReader(musiclog));
            String read;
            while ((read = log.readLine()) != null) {
                list.appendDescription(read + "\n");
            }
            ctx.getChannel().sendMessage(list.build()).queue();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "showlog";
    }

    @Override
    public String getHelp() {
        return "Shows songs currently in the log";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("show", "slog");
    }
}
