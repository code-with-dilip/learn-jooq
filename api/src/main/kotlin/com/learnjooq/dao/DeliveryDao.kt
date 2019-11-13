package com.learnjooq.dao

import com.learnjooq.dto.DeliveryLegDTO
import com.learnjooq.generated.Tables.DELIVERY
import com.learnjooq.generated.Tables.DELIVERY_LEG
import com.learnjooq.generated.tables.Delivery
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import java.sql.Timestamp
import java.time.OffsetDateTime

@Repository
class DeliveryDao(val dslContext: DSLContext) {

    fun addNewDelivery(delivery: com.learnjooq.dto.DeliveryDTO): Int? {

        val deliveryRecord = dslContext.insertInto(DELIVERY,
                DELIVERY.CRTE_USER, DELIVERY.CRTE_TS, DELIVERY.UPDATE_USER, DELIVERY.UPDATE_TS)
                .values("SYSTEM", OffsetDateTime.now(), "SYSTEM", OffsetDateTime.now())
                .returning(Delivery.DELIVERY.ID)
                .fetchOne()

        return deliveryRecord.get(Delivery.DELIVERY.ID)
    }

    fun addDeliveryLegs(deliveryId: Int?, stops: MutableList<DeliveryLegDTO>): Int {

           return dslContext.insertInto(DELIVERY_LEG, DELIVERY_LEG.DELIVERY_ID, DELIVERY_LEG.TYPE, DELIVERY_LEG.NAME,
                    DELIVERY_LEG.LOCATION_ID, DELIVERY_LEG.SEQUENCE_NUM,DELIVERY_LEG.EVENT_DATE_TIME,
                    DELIVERY.CRTE_USER, DELIVERY.CRTE_TS, DELIVERY.UPDATE_USER, DELIVERY.UPDATE_TS)
                    .apply { stops.forEach { values(deliveryId, it.type, it.name,
                            it.location_id,it.sequence_num, it.eventTs,
                            "SYSTEM", OffsetDateTime.now(), "SYSTEM", OffsetDateTime.now())} }
                    .execute()



    }
}