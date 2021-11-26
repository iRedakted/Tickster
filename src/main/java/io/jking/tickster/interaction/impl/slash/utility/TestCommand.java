package io.jking.tickster.interaction.impl.slash.utility;

import io.jking.tickster.interaction.context.SlashContext;
import io.jking.tickster.interaction.impl.slash.core.Category;
import io.jking.tickster.interaction.impl.slash.core.Command;

public class TestCommand extends Command {

    public TestCommand() {
        super("test", "A command to see if I'm working.", Category.UTILITY);
    }

    @Override
    public void onCommand(SlashContext ctx) {
        ctx.reply("I am working, leave me alone.").setEphemeral(true).queue();
    }
}
