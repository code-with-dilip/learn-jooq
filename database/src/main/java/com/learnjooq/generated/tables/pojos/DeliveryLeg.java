/*
 * This file is generated by jOOQ.
 */
package com.learnjooq.generated.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.annotation.Generated;


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
public class DeliveryLeg implements Serializable {

    private static final long serialVersionUID = 747417877;

    private Integer        id;
    private Integer        deliveryId;
    private String         type;
    private String         name;
    private String         locationId;
    private Integer        sequenceNum;
    private LocalDateTime  eventDateTime;
    private OffsetDateTime updateTs;
    private String         crteUser;
    private OffsetDateTime crteTs;
    private String         updateUser;

    public DeliveryLeg() {}

    public DeliveryLeg(DeliveryLeg value) {
        this.id = value.id;
        this.deliveryId = value.deliveryId;
        this.type = value.type;
        this.name = value.name;
        this.locationId = value.locationId;
        this.sequenceNum = value.sequenceNum;
        this.eventDateTime = value.eventDateTime;
        this.updateTs = value.updateTs;
        this.crteUser = value.crteUser;
        this.crteTs = value.crteTs;
        this.updateUser = value.updateUser;
    }

    public DeliveryLeg(
        Integer        id,
        Integer        deliveryId,
        String         type,
        String         name,
        String         locationId,
        Integer        sequenceNum,
        LocalDateTime  eventDateTime,
        OffsetDateTime updateTs,
        String         crteUser,
        OffsetDateTime crteTs,
        String         updateUser
    ) {
        this.id = id;
        this.deliveryId = deliveryId;
        this.type = type;
        this.name = name;
        this.locationId = locationId;
        this.sequenceNum = sequenceNum;
        this.eventDateTime = eventDateTime;
        this.updateTs = updateTs;
        this.crteUser = crteUser;
        this.crteTs = crteTs;
        this.updateUser = updateUser;
    }

    public Integer getId() {
        return this.id;
    }

    public DeliveryLeg setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDeliveryId() {
        return this.deliveryId;
    }

    public DeliveryLeg setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public DeliveryLeg setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public DeliveryLeg setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocationId() {
        return this.locationId;
    }

    public DeliveryLeg setLocationId(String locationId) {
        this.locationId = locationId;
        return this;
    }

    public Integer getSequenceNum() {
        return this.sequenceNum;
    }

    public DeliveryLeg setSequenceNum(Integer sequenceNum) {
        this.sequenceNum = sequenceNum;
        return this;
    }

    public LocalDateTime getEventDateTime() {
        return this.eventDateTime;
    }

    public DeliveryLeg setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
        return this;
    }

    public OffsetDateTime getUpdateTs() {
        return this.updateTs;
    }

    public DeliveryLeg setUpdateTs(OffsetDateTime updateTs) {
        this.updateTs = updateTs;
        return this;
    }

    public String getCrteUser() {
        return this.crteUser;
    }

    public DeliveryLeg setCrteUser(String crteUser) {
        this.crteUser = crteUser;
        return this;
    }

    public OffsetDateTime getCrteTs() {
        return this.crteTs;
    }

    public DeliveryLeg setCrteTs(OffsetDateTime crteTs) {
        this.crteTs = crteTs;
        return this;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public DeliveryLeg setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DeliveryLeg (");

        sb.append(id);
        sb.append(", ").append(deliveryId);
        sb.append(", ").append(type);
        sb.append(", ").append(name);
        sb.append(", ").append(locationId);
        sb.append(", ").append(sequenceNum);
        sb.append(", ").append(eventDateTime);
        sb.append(", ").append(updateTs);
        sb.append(", ").append(crteUser);
        sb.append(", ").append(crteTs);
        sb.append(", ").append(updateUser);

        sb.append(")");
        return sb.toString();
    }
}