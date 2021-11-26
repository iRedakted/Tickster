package io.jking.tickster.interaction.impl.slash.tickets;

import io.jking.tickster.interaction.context.SlashContext;
import io.jking.tickster.interaction.impl.slash.core.Category;
import io.jking.tickster.interaction.impl.slash.core.Command;
import io.jking.tickster.interaction.impl.slash.core.type.ErrorType;
import io.jking.tickster.jooq.tables.records.GuildTicketsRecord;
import io.jking.tickster.utility.EmbedFactory;
import io.jking.tickster.utility.MiscUtil;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;
import org.jooq.Result;

import static io.jking.tickster.jooq.tables.GuildTickets.GUILD_TICKETS;

public class TicketCommand extends Command {

    public TicketCommand() {
        super("ticket", "Ticket related commands.", Category.TICKETS);

        addSubcommands(
                new SubcommandData("view", "View your open tickets."),
                new SubcommandData("create", "Create a new ticket.")
        );
    }

    @Override
    public void onCommand(SlashContext ctx) {
        final String subCommand = ctx.getSubCommand();

        switch (subCommand.toLowerCase()) {
            case "view" -> onTicketView(ctx, err);
            case "create" -> onTicketCreate(ctx, err);
        }
    }

    private void onTicketView(CommandContext ctx, CommandError err) {
        final long guildId = ctx.getGuild().getIdLong();
        final long authorId = ctx.getAuthor().getIdLong();

        ctx.getDatabase().getDSL().selectFrom(GUILD_TICKETS)
                .where(GUILD_TICKETS.GUILD_ID.eq(guildId))
                .and(GUILD_TICKETS.CREATOR_ID.eq(authorId))
                .fetchAsync()
                .thenAcceptAsync(results -> {

                    if (results.isEmpty()) {
                        err.reply(ErrorType.CUSTOM, "You have no tickets to view.");
                        return;
                    }

                    final SelectionMenu.Builder menu = getTicketsMenu(results);
                    ctx.reply(EmbedFactory.getSelectionEmbed(ctx.getMember(), "Click any ticket to view it!"))
                            .addActionRow(menu.build())
                            .setEphemeral(true)
                            .queue();

                })
                .exceptionallyAsync(throwable -> {
                    err.reply(ErrorType.CUSTOM, "Could not retrieve open tickets.");
                    return null;
                });
    }

    private void onTicketCreate(CommandContext ctx, CommandError err) {

    }

    private SelectionMenu.Builder getTicketsMenu(Result<GuildTicketsRecord> results) {
        final SelectionMenu.Builder menu = SelectionMenu.create("view_tickets");

        for (int i = 0; i < results.size(); i++) {
            menu.addOption(
                    String.format("Ticket #%s", i + 1),
                    String.format("%s", results.get(i).getChannelId()),
                    String.format("Status: [%s]", MiscUtil.getStatus(results.get(i).getOpen()))
            );
        }

        return menu;
    }

}
