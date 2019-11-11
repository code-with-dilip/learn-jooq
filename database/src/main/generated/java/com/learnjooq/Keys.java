/*
 * This file is generated by jOOQ.
 */
package com.learnjooq;


import com.learnjooq.tables.Delivery;
import com.learnjooq.tables.DeliveryLeg;
import com.learnjooq.tables.FlywaySchemaHistory;
import com.learnjooq.tables.records.DeliveryLegRecord;
import com.learnjooq.tables.records.DeliveryRecord;
import com.learnjooq.tables.records.FlywaySchemaHistoryRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<DeliveryRecord, Integer> IDENTITY_DELIVERY = Identities0.IDENTITY_DELIVERY;
    public static final Identity<DeliveryLegRecord, Integer> IDENTITY_DELIVERY_LEG = Identities0.IDENTITY_DELIVERY_LEG;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DeliveryRecord> DELIVERY_PKEY = UniqueKeys0.DELIVERY_PKEY;
    public static final UniqueKey<DeliveryLegRecord> DELIVERY_LEG_PKEY = UniqueKeys0.DELIVERY_LEG_PKEY;
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<DeliveryLegRecord, DeliveryRecord> DELIVERY_LEG__DELIVERY_LEG_LOAD_ID_FKEY = ForeignKeys0.DELIVERY_LEG__DELIVERY_LEG_LOAD_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<DeliveryRecord, Integer> IDENTITY_DELIVERY = Internal.createIdentity(Delivery.DELIVERY, Delivery.DELIVERY.ID);
        public static Identity<DeliveryLegRecord, Integer> IDENTITY_DELIVERY_LEG = Internal.createIdentity(DeliveryLeg.DELIVERY_LEG, DeliveryLeg.DELIVERY_LEG.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<DeliveryRecord> DELIVERY_PKEY = Internal.createUniqueKey(Delivery.DELIVERY, "delivery_pkey", Delivery.DELIVERY.ID);
        public static final UniqueKey<DeliveryLegRecord> DELIVERY_LEG_PKEY = Internal.createUniqueKey(DeliveryLeg.DELIVERY_LEG, "delivery_leg_pkey", DeliveryLeg.DELIVERY_LEG.ID);
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<DeliveryLegRecord, DeliveryRecord> DELIVERY_LEG__DELIVERY_LEG_LOAD_ID_FKEY = Internal.createForeignKey(com.learnjooq.Keys.DELIVERY_PKEY, DeliveryLeg.DELIVERY_LEG, "delivery_leg__delivery_leg_load_id_fkey", DeliveryLeg.DELIVERY_LEG.LOAD_ID);
    }
}
