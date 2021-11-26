package io.jking.tickster.interaction.impl.slash.info;

import io.jking.tickster.interaction.context.SlashContext;
import io.jking.tickster.interaction.impl.slash.core.Category;
import io.jking.tickster.interaction.impl.slash.core.Command;
import io.jking.tickster.utility.EmbedFactory;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.components.Button;

public class AboutCommand extends Command {

    public AboutCommand() {
        super("about", "Shows information about Tickster.", Category.INFO);
    }

    @Override
    public void onCommand(SlashContext ctx) {
        final User self = ctx.getSelf();
        final EmbedBuilder embed = EmbedFactory.getDefault()
                .setAuthor("About me...", null, self.getEffectiveAvatarUrl())
                .setDescription(String.format(
                        """
                        I am a bot specifically designed to aid with server moderation tailored around tickets and member reports. While I do not provide general moderation commands, I am equipped with unique features for convenience.
                                                
                        **Systems Information:**
                        Version: `%s`
                        Language: `Java`
                        """,
                        "0.0.1-alpha"));

        ctx.reply(embed).setEphemeral(true)
                .addActionRow(
                        Button.link("https://github.com/DV8FromTheWorld/JDA", "Library"),
                        Button.link("https://no.com", "Support Server"),
                        Button.link("https://github.com/JacobDevelopment/SchoolBot", "GitHub Repo")
                )
                .queue();
    }
}
