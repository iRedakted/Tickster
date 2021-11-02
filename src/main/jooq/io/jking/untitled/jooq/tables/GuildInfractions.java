/*
 * This file is generated by jOOQ.
 */
package io.jking.untitled.jooq.tables;


import io.jking.untitled.jooq.Public;
import io.jking.untitled.jooq.tables.records.GuildInfractionsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuildInfractions extends TableImpl<GuildInfractionsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.guild_infractions</code>
     */
    public static final GuildInfractions GUILD_INFRACTIONS = new GuildInfractions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuildInfractionsRecord> getRecordType() {
        return GuildInfractionsRecord.class;
    }

    /**
     * The column <code>public.guild_infractions.guild_id</code>.
     */
    public final TableField<GuildInfractionsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.guild_infractions.target_id</code>.
     */
    public final TableField<GuildInfractionsRecord, Long> TARGET_ID = createField(DSL.name("target_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.guild_infractions.case_number</code>.
     */
    public final TableField<GuildInfractionsRecord, Integer> CASE_NUMBER = createField(DSL.name("case_number"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.guild_infractions.reason</code>.
     */
    public final TableField<GuildInfractionsRecord, String> REASON = createField(DSL.name("reason"), SQLDataType.CLOB.nullable(false).defaultValue(DSL.field("'No reason provided.'::text", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>public.guild_infractions.issuer_id</code>.
     */
    public final TableField<GuildInfractionsRecord, Long> ISSUER_ID = createField(DSL.name("issuer_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.guild_infractions.timestamp</code>.
     */
    public final TableField<GuildInfractionsRecord, String> TIMESTAMP = createField(DSL.name("timestamp"), SQLDataType.CLOB.nullable(false), this, "");

    private GuildInfractions(Name alias, Table<GuildInfractionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private GuildInfractions(Name alias, Table<GuildInfractionsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.guild_infractions</code> table reference
     */
    public GuildInfractions(String alias) {
        this(DSL.name(alias), GUILD_INFRACTIONS);
    }

    /**
     * Create an aliased <code>public.guild_infractions</code> table reference
     */
    public GuildInfractions(Name alias) {
        this(alias, GUILD_INFRACTIONS);
    }

    /**
     * Create a <code>public.guild_infractions</code> table reference
     */
    public GuildInfractions() {
        this(DSL.name("guild_infractions"), null);
    }

    public <O extends Record> GuildInfractions(Table<O> child, ForeignKey<O, GuildInfractionsRecord> key) {
        super(child, key, GUILD_INFRACTIONS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public GuildInfractions as(String alias) {
        return new GuildInfractions(DSL.name(alias), this);
    }

    @Override
    public GuildInfractions as(Name alias) {
        return new GuildInfractions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildInfractions rename(String name) {
        return new GuildInfractions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildInfractions rename(Name name) {
        return new GuildInfractions(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, Integer, String, Long, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
