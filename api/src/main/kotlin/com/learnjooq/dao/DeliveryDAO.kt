package com.learnjooq.dao

import com.learnjooq.dto.DeliveryLegDTO
import com.learnjooq.generated.Tables.DELIVERY
import com.learnjooq.generated.Tables.DELIVERY_LEG
import com.learnjooq.generated.tables.Delivery
import com.learnjooq.generated.tables.pojos.DeliveryLeg
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class DeliveryDAO(val dslContext: DSLContext) {


    var sql = "SELECT * FROM information_schema.sequences\n" +
            "where sequence_schema ='jooqtest';"


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
                DELIVERY_LEG.LOCATION_ID, DELIVERY_LEG.SEQUENCE_NUM, DELIVERY_LEG.EVENT_DATE_TIME,
                DELIVERY.CRTE_USER, DELIVERY.CRTE_TS, DELIVERY.UPDATE_USER, DELIVERY.UPDATE_TS)
                .apply {
                    stops.forEach {
                        values(deliveryId, it.type, it.name,
                                it.location_id, it.sequence_num, it.eventTs,
                                "SYSTEM", OffsetDateTime.now(), "SYSTEM", OffsetDateTime.now())
                    }
                }
                .execute()
    }

    fun getAllSchemaNames() : List<String>?{
        val result: Result<Record>? = dslContext.fetch(sql)
        println(result?.size)
        println(result)
        return result?.map {
            it[2]
        } as List<String>
    }


    fun getAllDeliveryLegsByDeliveryId(deliveryId: Int?): List<DeliveryLeg>? {
        val deliveryLegList = dslContext.select()
                .from(DELIVERY_LEG)
                .where(DELIVERY_LEG.DELIVERY_ID.eq(deliveryId))
                .fetchInto(DeliveryLeg::class.java)
        return deliveryLegList

    }
}