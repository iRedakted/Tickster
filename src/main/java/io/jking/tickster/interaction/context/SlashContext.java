package io.jking.tickster.interaction.context;

import io.jking.tickster.cache.Cache;
import io.jking.tickster.database.Database;
import io.jking.tickster.interaction.AbstractContext;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class SlashContext extends AbstractContext<SlashCommandEvent> {
    public SlashContext(SlashCommandEvent event, CommandRegistry registry, Database database, Cache cache) {
        super(event, registry, database, cache);
    }


}
