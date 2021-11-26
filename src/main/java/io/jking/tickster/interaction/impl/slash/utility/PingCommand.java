package io.jking.tickster.interaction.impl.slash.utility;

import io.jking.tickster.interaction.context.SlashContext;
import io.jking.tickster.interaction.impl.slash.core.Category;
import io.jking.tickster.interaction.impl.slash.core.Command;

public class PingCommand extends Command {
    public PingCommand() {
        super("ping", "Shows my network reachability.", Category.UTILITY);
    }

    @Override
    public void onCommand(SlashContext ctx) {
        final long init = System.currentTimeMillis();
        ctx.getJda().getRestPing().map(String::valueOf)
                .flatMap(value -> ctx.replyFormatted("**Rest Ping:** %s\n**Gateway Ping:** %s\n**General Ping:** %s",
                        value,
                        ctx.getJda().getGatewayPing(),
                        System.currentTimeMillis() - init)
                        .setEphemeral(true)
                )
                .queue();
    }
}
