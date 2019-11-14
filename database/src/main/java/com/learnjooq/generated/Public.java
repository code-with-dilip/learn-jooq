/*
 * This file is generated by jOOQ.
 */
package com.learnjooq.generated;


import com.learnjooq.generated.tables.Delivery;
import com.learnjooq.generated.tables.DeliveryLeg;
import com.learnjooq.generated.tables.FlywaySchemaHistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1000961086;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.delivery</code>.
     */
    public final Delivery DELIVERY = com.learnjooq.generated.tables.Delivery.DELIVERY;

    /**
     * The table <code>public.delivery_leg</code>.
     */
    public final DeliveryLeg DELIVERY_LEG = com.learnjooq.generated.tables.DeliveryLeg.DELIVERY_LEG;

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = com.learnjooq.generated.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.DELIVERY_ID_SEQ,
            Sequences.DELIVERY_LEG_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Delivery.DELIVERY,
            DeliveryLeg.DELIVERY_LEG,
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);
    }
}