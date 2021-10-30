/*
 * This file is generated by jOOQ.
 */
package io.jking.untitled.jooq.tables.records;


import io.jking.untitled.jooq.tables.GuildData;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuildDataRecord extends UpdatableRecordImpl<GuildDataRecord> implements Record2<Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.guild_data.guild_id</code>.
     */
    public GuildDataRecord setGuildId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.guild_data.guild_id</code>.
     */
    public Long getGuildId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.guild_data.owner_id</code>.
     */
    public GuildDataRecord setOwnerId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.guild_data.owner_id</code>.
     */
    public Long getOwnerId() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return GuildData.GUILD_DATA.GUILD_ID;
    }

    @Override
    public Field<Long> field2() {
        return GuildData.GUILD_DATA.OWNER_ID;
    }

    @Override
    public Long component1() {
        return getGuildId();
    }

    @Override
    public Long component2() {
        return getOwnerId();
    }

    @Override
    public Long value1() {
        return getGuildId();
    }

    @Override
    public Long value2() {
        return getOwnerId();
    }

    @Override
    public GuildDataRecord value1(Long value) {
        setGuildId(value);
        return this;
    }

    @Override
    public GuildDataRecord value2(Long value) {
        setOwnerId(value);
        return this;
    }

    @Override
    public GuildDataRecord values(Long value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GuildDataRecord
     */
    public GuildDataRecord() {
        super(GuildData.GUILD_DATA);
    }

    /**
     * Create a detached, initialised GuildDataRecord
     */
    public GuildDataRecord(Long guildId, Long ownerId) {
        super(GuildData.GUILD_DATA);

        setGuildId(guildId);
        setOwnerId(ownerId);
    }
}
