/*
 * This file is generated by jOOQ.
 */
package com.learnjooq.generated.tables.daos;


import com.learnjooq.generated.tables.DeliveryLeg;
import com.learnjooq.generated.tables.records.DeliveryLegRecord;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class DeliveryLegDao extends DAOImpl<DeliveryLegRecord, com.learnjooq.generated.tables.pojos.DeliveryLeg, Integer> {

    /**
     * Create a new DeliveryLegDao without any configuration
     */
    public DeliveryLegDao() {
        super(DeliveryLeg.DELIVERY_LEG, com.learnjooq.generated.tables.pojos.DeliveryLeg.class);
    }

    /**
     * Create a new DeliveryLegDao with an attached configuration
     */
    public DeliveryLegDao(Configuration configuration) {
        super(DeliveryLeg.DELIVERY_LEG, com.learnjooq.generated.tables.pojos.DeliveryLeg.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.learnjooq.generated.tables.pojos.DeliveryLeg object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchById(Integer... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.learnjooq.generated.tables.pojos.DeliveryLeg fetchOneById(Integer value) {
        return fetchOne(DeliveryLeg.DELIVERY_LEG.ID, value);
    }

    /**
     * Fetch records that have <code>delivery_id IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchByDeliveryId(Integer... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.DELIVERY_ID, values);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchByType(String... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.TYPE, values);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchByName(String... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.NAME, values);
    }

    /**
     * Fetch records that have <code>location_id IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchByLocationId(String... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.LOCATION_ID, values);
    }

    /**
     * Fetch records that have <code>sequence_num IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchBySequenceNum(Integer... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.SEQUENCE_NUM, values);
    }

    /**
     * Fetch records that have <code>event_date_time IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchByEventDateTime(LocalDateTime... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.EVENT_DATE_TIME, values);
    }

    /**
     * Fetch records that have <code>update_ts IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchByUpdateTs(OffsetDateTime... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.UPDATE_TS, values);
    }

    /**
     * Fetch records that have <code>crte_user IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchByCrteUser(String... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.CRTE_USER, values);
    }

    /**
     * Fetch records that have <code>crte_ts IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchByCrteTs(OffsetDateTime... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.CRTE_TS, values);
    }

    /**
     * Fetch records that have <code>update_user IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.DeliveryLeg> fetchByUpdateUser(String... values) {
        return fetch(DeliveryLeg.DELIVERY_LEG.UPDATE_USER, values);
    }
}