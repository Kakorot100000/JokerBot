package com.tyskyworks.kakorot.command.jokecommands;

import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import com.tyskyworks.kakorot.Config;
import com.tyskyworks.kakorot.command.CommandContext;
import com.tyskyworks.kakorot.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class FKCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        final TextChannel channel = ctx.getChannel();
        final Message message = ctx.getMessage();

        String[] place = new String[]{"Fuck {name} all my homies hate {name}"};

        String[] args = ctx.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Config.get("prefix") + "fk")) {
            if (args.length < 2) {
                // Usage
                EmbedBuilder fk = new EmbedBuilder();
                fk.setColor(0xf51707);
                fk.setTitle("Specify who to hate");
                fk.setDescription("Usage: `" + Config.get("prefix") + "fk <who your homie hate>`");
                channel.sendMessage(fk.build()).queue();
            } else {
                try {
                    EmbedBuilder fk = new EmbedBuilder();
                    fk.setColor(0xf51707);
                    fk.setTitle(place[0].replace("{name}", args[1]));
                    channel.sendMessage(fk.build()).queue();
                } catch (IllegalArgumentException e) {
                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("⛔ The hell did you put to get this?");
                        error.setDescription("Really what did you do??????");
                        ctx.getChannel().sendMessage(error.build()).queue();
                    }
                }
            }
        }
    }

    @Override
    public String getName() {
        return "fk";
    }

    @Override
    public String getHelp() {
        return "Who do all you and your homies hate? `" + Config.get("prefix")  + "fk <who your homie hate>`";
    }

    @Override
    public List<String> getAliases() {
        return null;
    }
}
