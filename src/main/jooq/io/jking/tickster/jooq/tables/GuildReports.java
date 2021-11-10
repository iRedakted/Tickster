/*
 * This file is generated by jOOQ.
 */
package io.jking.tickster.jooq.tables;


import io.jking.tickster.jooq.Public;
import io.jking.tickster.jooq.tables.records.GuildReportsRecord;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuildReports extends TableImpl<GuildReportsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.guild_reports</code>
     */
    public static final GuildReports GUILD_REPORTS = new GuildReports();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuildReportsRecord> getRecordType() {
        return GuildReportsRecord.class;
    }

    /**
     * The column <code>public.guild_reports.guild_id</code>.
     */
    public final TableField<GuildReportsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.guild_reports.reported_users</code>.
     */
    public final TableField<GuildReportsRecord, Long[]> REPORTED_USERS = createField(DSL.name("reported_users"), SQLDataType.BIGINT.getArrayDataType(), this, "");

    /**
     * The column <code>public.guild_reports.issuer_id</code>.
     */
    public final TableField<GuildReportsRecord, Long> ISSUER_ID = createField(DSL.name("issuer_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.guild_reports.report_reason</code>.
     */
    public final TableField<GuildReportsRecord, String> REPORT_REASON = createField(DSL.name("report_reason"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.guild_reports.report_timestamp</code>.
     */
    public final TableField<GuildReportsRecord, String> REPORT_TIMESTAMP = createField(DSL.name("report_timestamp"), SQLDataType.CLOB.nullable(false), this, "");

    private GuildReports(Name alias, Table<GuildReportsRecord> aliased) {
        this(alias, aliased, null);
    }

    private GuildReports(Name alias, Table<GuildReportsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.guild_reports</code> table reference
     */
    public GuildReports(String alias) {
        this(DSL.name(alias), GUILD_REPORTS);
    }

    /**
     * Create an aliased <code>public.guild_reports</code> table reference
     */
    public GuildReports(Name alias) {
        this(alias, GUILD_REPORTS);
    }

    /**
     * Create a <code>public.guild_reports</code> table reference
     */
    public GuildReports() {
        this(DSL.name("guild_reports"), null);
    }

    public <O extends Record> GuildReports(Table<O> child, ForeignKey<O, GuildReportsRecord> key) {
        super(child, key, GUILD_REPORTS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public GuildReports as(String alias) {
        return new GuildReports(DSL.name(alias), this);
    }

    @Override
    public GuildReports as(Name alias) {
        return new GuildReports(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildReports rename(String name) {
        return new GuildReports(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GuildReports rename(Name name) {
        return new GuildReports(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long[], Long, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
