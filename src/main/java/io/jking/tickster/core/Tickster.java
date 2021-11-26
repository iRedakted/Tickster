package io.jking.tickster.core;

import io.jking.tickster.cache.Cache;
import io.jking.tickster.interaction.Registry;
import io.jking.tickster.interaction.impl.slash.utility.TestCommand;
import io.jking.tickster.database.Database;
import io.jking.tickster.database.Hikari;
import io.jking.tickster.handler.GuildHandler;
import io.jking.tickster.handler.InteractionHandler;
import io.jking.tickster.handler.StartHandler;
import io.jking.tickster.interaction.registry.ButtonRegistry;
import io.jking.tickster.interaction.registry.CommandRegistry;
import io.jking.tickster.interaction.registry.SelectionRegistry;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.utils.Checks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Tickster {

    private final Logger logger = LoggerFactory.getLogger(Tickster.class);

    private final CommandRegistry commandRegistry = new Registry()
            .put("test", new TestCommand());


    private final SelectionRegistry selectionRegistry = new SelectionRegistry();
    private final ButtonRegistry buttonRegistry = new ButtonRegistry();

    private final DataObject data;
    private final Database database;
    private final Cache cache;

    private ShardManager shardManager;

    private Tickster(String configPath) throws IOException {
        this.data = loadConfig(configPath);
        this.database = new Database(new Hikari(data)).createTables(
                "sql/guild_data.sql", "sql/guild_tickets.sql", "sql/guild_reports.sql"
        );
        this.cache = new Cache(database);
    }

    public static void build(String configPath) throws LoginException, InterruptedException, IOException {
        new Tickster(configPath).startTickster();
    }

    private DataObject loadConfig(String configPath) throws IOException {
        Checks.notNull(configPath, "Configuration Path.");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(configPath))) {
            return DataObject.fromJson(bufferedReader);
        }
    }

    private void startTickster() throws LoginException, InterruptedException {
        logger.info("Building Tickster...");
        final String token = data.getObject("bot").getString("token", null);
        Checks.notNull(token, "Config Token");

        this.shardManager = DefaultShardManagerBuilder.createDefault(token)
                .setMemberCachePolicy(MemberCachePolicy.NONE)
                .setChunkingFilter(ChunkingFilter.NONE)
                .setEnabledIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES)
                .disableCache(Arrays.asList(CacheFlag.values()))
                .addEventListeners(
                        new InteractionHandler(commandRegistry, database, cache),
                        new StartHandler(this, cache),
                        new GuildHandler(commandRegistry, database, cache)
                )
                .build();
    }

    // TODO: Implement task that deletes expired tickets/reports.

    public DataObject getData() {
        return data;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public Database getDatabase() {
        return database;
    }


}
