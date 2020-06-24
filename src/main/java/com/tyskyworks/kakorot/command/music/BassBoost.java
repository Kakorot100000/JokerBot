package com.tyskyworks.kakorot.command.music;

import com.tyskyworks.kakorot.command.CommandContext;
import com.tyskyworks.kakorot.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.managers.AudioManager;

import java.util.Arrays;
import java.util.List;

public class BassBoost implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        final TextChannel channel = ctx.getChannel();
        AudioManager audioManager = ctx.getGuild().getAudioManager();
        PlayerManager manager = PlayerManager.getInstance();
        GuildMusicManager music = manager.getGuildMusicManager(ctx.getGuild());

        if (ctx.getAuthor().isBot()) return;

        try {
            music.player.setVolume(9000000);
            // Success
            EmbedBuilder success = new EmbedBuilder();
            success.setColor(0x22ff2a);
            success.setTitle("🔊 FEEL THE BASS! 🔊");
            ctx.getChannel().sendMessage(success.build()).queue();
        } catch (IllegalArgumentException e) {
            if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                // Too many messages
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(0xff3923);
                error.setTitle("⛔ The Fuck did you put to get this");
                error.setDescription("Really what the hell");
                ctx.getChannel().sendMessage(error.build()).queue();
            }

        }
    }




    @Override
    public String getName() {
        return "BassBoot";
    }

    @Override
    public String getHelp() {
        return "Feel the bass";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("bb", "bass", "loud");
    }
}