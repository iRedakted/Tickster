/*
 * This file is generated by jOOQ.
 */
package io.jking.untitled.jooq.tables;


import io.jking.untitled.jooq.Keys;
import io.jking.untitled.jooq.Public;
import io.jking.untitled.jooq.tables.records.GuildSettingsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuildSettings extends TableImpl<GuildSettingsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.guild_settings</code>
     */
    public static final GuildSettings GUILD_SETTINGS = new GuildSettings();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuildSettingsRecord> getRecordType() {
        return GuildSettingsRecord.class;
    }

    /**
     * The column <code>public.guild_settings.guild_id</code>.
     */
    public final TableField<GuildSettingsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.guild_settings.message_logging</code>.
     */
    public final TableField<GuildSettingsRecord, Boolean> MESSAGE_LOGGING = createField(DSL.name("message_logging"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.guild_settings.alt_logging</code>.
     */
    public final TableField<GuildSettingsRecord, Boolean> ALT_LOGGING = createField(DSL.name("alt_logging"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.guild_settings.pfp_logging</code>.
     */
    public final TableField<GuildSettingsRecord, Boolean> PFP_LOGGING = createField(DSL.name("pfp_logging"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.guild_settings.auto_mod</code>.
     */
    public final TableField<GuildSettingsRecord, Boolean> AUTO_MOD = createField(DSL.name("auto_mod"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.guild_settings.auto_alt</code>.
     */
    public final TableField<GuildSettingsRecord, Boolean> AUTO_ALT = createField(DSL.name("auto_alt"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.guild_settings.auto_pfp</code>.
     */
    public final TableField<GuildSettingsRecord, Boolean> AUTO_PFP = createField(DSL.name("auto_pfp"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.guild_settings.auto_message</code>.
     */
    public final TableField<GuildSettingsRecord, Boolean> AUTO_MESSAGE = createField(DSL.name("auto_message"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    private GuildSettings(Name alias, Table<GuildSettingsRecord> aliased) {
        this(alias, aliased, null);
    }

    private GuildSettings(Name alias, Table<GuildSettingsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.guild_settings</code> table reference
     */
    public GuildSettings(String alias) {
        this(DSL.name(alias), GUILD_SETTINGS);
    }

    /**
     * Create an aliased <code>public.guild_settings</code> table reference
     */
    public GuildSettings(Name alias) {
        this(alias, GUILD_SETTINGS);
    }

    /**
     * Create a <code>public.guild_settings</code> table reference
     */
    public GuildSettings() {
        this(DSL.name("guild_settings"), null);
    }

    public <O extends Record> GuildSettings(Table<O> child, ForeignKey<O, GuildSettingsRecord> key) {
        super(child, key, GUILD_SETTINGS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<GuildSettingsRecord> getPrimaryKey() {
        return Keys.GUILD_SETTINGS_PKEY;
    }

    @Override
    public GuildSettings as(String alias) {
        return new GuildSettings(DSL.name(alias), this);
    }

    @Override
    public GuildSettings as(Name alias) {
        return new GuildSettings(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildSettings rename(String name) {
        return new GuildSettings(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildSettings rename(Name name) {
        return new GuildSettings(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean, Boolean> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
