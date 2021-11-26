package io.jking.tickster.interaction;

import io.jking.tickster.cache.Cache;
import io.jking.tickster.cache.impl.GuildCache;
import io.jking.tickster.cache.impl.ReportCache;
import io.jking.tickster.cache.impl.TicketCache;
import io.jking.tickster.interaction.impl.slash.core.type.ErrorType;
import io.jking.tickster.database.Database;
import io.jking.tickster.utility.EmbedFactory;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;

public abstract class AbstractContext<T extends GenericInteractionCreateEvent> {

    private final T event;
    private final CommandRegistry registry;
    private final Database database;
    private final Cache cache;

    public AbstractContext(T event, CommandRegistry registry, Database database, Cache cache) {
        this.event = event;
        this.registry = registry;
        this.database = database;
        this.cache = cache;
    }

    public T getEvent() {
        return event;
    }

    public CommandRegistry getRegistry() {
        return registry;
    }

    public Database getDatabase() {
        return database;
    }

    public Cache getCache() {
        return cache;
    }

    public Interaction getInteraction() {
        return event.getInteraction();
    }

    public InteractionHook getHook() {
        return event.getHook();
    }

    public String getComponentId() {
        return event.getId();
    }

    public Guild getGuild() {
        return getEvent().getGuild();
    }

    public GuildCache getGuildCache() {
        return getCache().getGuildCache();
    }

    public ReportCache getReportCache() {
        return getCache().getReportCache();
    }

    public TicketCache getTicketCache() {
        return getCache().getTicketCache();
    }


    public JDA getJDA() {
        return getEvent().getJDA();
    }

    public Member getMember() {
        return event.getMember();
    }

    public User getUser() {
        return event.getUser();
    }

    public TextChannel getChannel() {
        return event.getTextChannel();
    }

    public ReplyAction reply(String content) {
        return getEvent().reply(content);
    }

    public ReplyAction reply(EmbedBuilder embed) {
        return getEvent().replyEmbeds(embed.build());
    }

    public ReplyAction deferReply() {
        return getEvent().deferReply();
    }

    public void replyError(ErrorType errorType, Object... objects) {
        getHook().sendMessageEmbeds(EmbedFactory.getError(errorType, objects).build())
                .setEphemeral(true)
                .queue();
    }

}
