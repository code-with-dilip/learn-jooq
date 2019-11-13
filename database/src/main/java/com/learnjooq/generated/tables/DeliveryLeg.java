/*
 * This file is generated by jOOQ.
 */
package com.learnjooq.generated.tables;


import com.learnjooq.generated.Indexes;
import com.learnjooq.generated.Keys;
import com.learnjooq.generated.Public;
import com.learnjooq.generated.tables.records.DeliveryLegRecord;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DeliveryLeg extends TableImpl<DeliveryLegRecord> {

    private static final long serialVersionUID = -2130876853;

    /**
     * The reference instance of <code>public.delivery_leg</code>
     */
    public static final DeliveryLeg DELIVERY_LEG = new DeliveryLeg();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DeliveryLegRecord> getRecordType() {
        return DeliveryLegRecord.class;
    }

    /**
     * The column <code>public.delivery_leg.id</code>.
     */
    public final TableField<DeliveryLegRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('public.delivery_leg_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.delivery_leg.delivery_id</code>.
     */
    public final TableField<DeliveryLegRecord, Integer> DELIVERY_ID = createField("delivery_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.delivery_leg.type</code>.
     */
    public final TableField<DeliveryLegRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.delivery_leg.name</code>.
     */
    public final TableField<DeliveryLegRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.delivery_leg.location_id</code>.
     */
    public final TableField<DeliveryLegRecord, String> LOCATION_ID = createField("location_id", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.delivery_leg.sequence_num</code>.
     */
    public final TableField<DeliveryLegRecord, Integer> SEQUENCE_NUM = createField("sequence_num", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.delivery_leg.event_date_time</code>.
     */
    public final TableField<DeliveryLegRecord, LocalDateTime> EVENT_DATE_TIME = createField("event_date_time", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>public.delivery_leg.update_ts</code>.
     */
    public final TableField<DeliveryLegRecord, OffsetDateTime> UPDATE_TS = createField("update_ts", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * The column <code>public.delivery_leg.crte_user</code>.
     */
    public final TableField<DeliveryLegRecord, String> CRTE_USER = createField("crte_user", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.delivery_leg.crte_ts</code>.
     */
    public final TableField<DeliveryLegRecord, OffsetDateTime> CRTE_TS = createField("crte_ts", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE.defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE)), this, "");

    /**
     * The column <code>public.delivery_leg.update_user</code>.
     */
    public final TableField<DeliveryLegRecord, String> UPDATE_USER = createField("update_user", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.delivery_leg</code> table reference
     */
    public DeliveryLeg() {
        this(DSL.name("delivery_leg"), null);
    }

    /**
     * Create an aliased <code>public.delivery_leg</code> table reference
     */
    public DeliveryLeg(String alias) {
        this(DSL.name(alias), DELIVERY_LEG);
    }

    /**
     * Create an aliased <code>public.delivery_leg</code> table reference
     */
    public DeliveryLeg(Name alias) {
        this(alias, DELIVERY_LEG);
    }

    private DeliveryLeg(Name alias, Table<DeliveryLegRecord> aliased) {
        this(alias, aliased, null);
    }

    private DeliveryLeg(Name alias, Table<DeliveryLegRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> DeliveryLeg(Table<O> child, ForeignKey<O, DeliveryLegRecord> key) {
        super(child, key, DELIVERY_LEG);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.DELIVERY_LEG_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<DeliveryLegRecord, Integer> getIdentity() {
        return Keys.IDENTITY_DELIVERY_LEG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DeliveryLegRecord> getPrimaryKey() {
        return Keys.DELIVERY_LEG_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DeliveryLegRecord>> getKeys() {
        return Arrays.<UniqueKey<DeliveryLegRecord>>asList(Keys.DELIVERY_LEG_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<DeliveryLegRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DeliveryLegRecord, ?>>asList(Keys.DELIVERY_LEG__DELIVERY_LEG_DELIVERY_ID_FKEY);
    }

    public Delivery delivery() {
        return new Delivery(this, Keys.DELIVERY_LEG__DELIVERY_LEG_DELIVERY_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeliveryLeg as(String alias) {
        return new DeliveryLeg(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeliveryLeg as(Name alias) {
        return new DeliveryLeg(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DeliveryLeg rename(String name) {
        return new DeliveryLeg(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DeliveryLeg rename(Name name) {
        return new DeliveryLeg(name, null);
    }
}
