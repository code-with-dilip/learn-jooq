/*
 * This file is generated by jOOQ.
 */
package com.learnjooq.generated.tables.daos;


import com.learnjooq.generated.tables.Delivery;
import com.learnjooq.generated.tables.records.DeliveryRecord;

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
public class DeliveryDao extends DAOImpl<DeliveryRecord, com.learnjooq.generated.tables.pojos.Delivery, Integer> {

    /**
     * Create a new DeliveryDao without any configuration
     */
    public DeliveryDao() {
        super(Delivery.DELIVERY, com.learnjooq.generated.tables.pojos.Delivery.class);
    }

    /**
     * Create a new DeliveryDao with an attached configuration
     */
    public DeliveryDao(Configuration configuration) {
        super(Delivery.DELIVERY, com.learnjooq.generated.tables.pojos.Delivery.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.learnjooq.generated.tables.pojos.Delivery object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.Delivery> fetchById(Integer... values) {
        return fetch(Delivery.DELIVERY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.learnjooq.generated.tables.pojos.Delivery fetchOneById(Integer value) {
        return fetchOne(Delivery.DELIVERY.ID, value);
    }

    /**
     * Fetch records that have <code>update_ts IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.Delivery> fetchByUpdateTs(OffsetDateTime... values) {
        return fetch(Delivery.DELIVERY.UPDATE_TS, values);
    }

    /**
     * Fetch records that have <code>crte_user IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.Delivery> fetchByCrteUser(String... values) {
        return fetch(Delivery.DELIVERY.CRTE_USER, values);
    }

    /**
     * Fetch records that have <code>crte_ts IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.Delivery> fetchByCrteTs(OffsetDateTime... values) {
        return fetch(Delivery.DELIVERY.CRTE_TS, values);
    }

    /**
     * Fetch records that have <code>update_user IN (values)</code>
     */
    public List<com.learnjooq.generated.tables.pojos.Delivery> fetchByUpdateUser(String... values) {
        return fetch(Delivery.DELIVERY.UPDATE_USER, values);
    }
}
