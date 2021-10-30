/*
 * This file is generated by jOOQ.
 */
package io.jking.untitled.jooq.tables;


import io.jking.untitled.jooq.Keys;
import io.jking.untitled.jooq.Public;
import io.jking.untitled.jooq.tables.records.GuildDataRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
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
public class GuildData extends TableImpl<GuildDataRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.guild_data</code>
     */
    public static final GuildData GUILD_DATA = new GuildData();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuildDataRecord> getRecordType() {
        return GuildDataRecord.class;
    }

    /**
     * The column <code>public.guild_data.guild_id</code>.
     */
    public final TableField<GuildDataRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.guild_data.owner_id</code>.
     */
    public final TableField<GuildDataRecord, Long> OWNER_ID = createField(DSL.name("owner_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private GuildData(Name alias, Table<GuildDataRecord> aliased) {
        this(alias, aliased, null);
    }

    private GuildData(Name alias, Table<GuildDataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.guild_data</code> table reference
     */
    public GuildData(String alias) {
        this(DSL.name(alias), GUILD_DATA);
    }

    /**
     * Create an aliased <code>public.guild_data</code> table reference
     */
    public GuildData(Name alias) {
        this(alias, GUILD_DATA);
    }

    /**
     * Create a <code>public.guild_data</code> table reference
     */
    public GuildData() {
        this(DSL.name("guild_data"), null);
    }

    public <O extends Record> GuildData(Table<O> child, ForeignKey<O, GuildDataRecord> key) {
        super(child, key, GUILD_DATA);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<GuildDataRecord> getPrimaryKey() {
        return Keys.GUILD_DATA_PKEY;
    }

    @Override
    public GuildData as(String alias) {
        return new GuildData(DSL.name(alias), this);
    }

    @Override
    public GuildData as(Name alias) {
        return new GuildData(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildData rename(String name) {
        return new GuildData(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildData rename(Name name) {
        return new GuildData(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
