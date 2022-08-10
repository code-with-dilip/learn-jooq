package com.learnjooq.dao

import com.learnjooq.dto.DeliveryLegDTO
import com.learnjooq.generated.Tables.DELIVERY
import com.learnjooq.generated.Tables.DELIVERY_LEG
import com.learnjooq.generated.tables.Delivery
import com.learnjooq.generated.tables.pojos.DeliveryLeg
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.jooq.Schema
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class DeliveryDAO(
    @Qualifier("jooqFirst")
    val dslContextFirst: DSLContext,
    @Qualifier("jooqSecond")
    val dslContextSecond: DSLContext
) {


    var sql = "SELECT * FROM information_schema.sequences\n" +
            "where sequence_schema ='jooqtest';"


    fun addNewDelivery(delivery: com.learnjooq.dto.DeliveryDTO): Int? {

        val deliveryRecord = dslContextFirst.insertInto(
            DELIVERY,
            DELIVERY.CRTE_USER, DELIVERY.CRTE_TS, DELIVERY.UPDATE_USER, DELIVERY.UPDATE_TS
        )
            .values("SYSTEM", OffsetDateTime.now(), "SYSTEM", OffsetDateTime.now())
            .returning(Delivery.DELIVERY.ID)
            .fetchOne()

        dslContextSecond.insertInto(
            DELIVERY,
            DELIVERY.CRTE_USER, DELIVERY.CRTE_TS, DELIVERY.UPDATE_USER, DELIVERY.UPDATE_TS
        )
            .values("SYSTEM", OffsetDateTime.now(), "SYSTEM", OffsetDateTime.now())
            .returning(Delivery.DELIVERY.ID)
            .fetchOne()

        return deliveryRecord.get(Delivery.DELIVERY.ID)
    }

    fun addDeliveryLegs(deliveryId: Int?, stops: MutableList<DeliveryLegDTO>): Int {

        dslContextSecond.insertInto(
            DELIVERY_LEG, DELIVERY_LEG.DELIVERY_ID, DELIVERY_LEG.TYPE, DELIVERY_LEG.NAME,
            DELIVERY_LEG.LOCATION_ID, DELIVERY_LEG.SEQUENCE_NUM, DELIVERY_LEG.EVENT_DATE_TIME,
            DELIVERY.CRTE_USER, DELIVERY.CRTE_TS, DELIVERY.UPDATE_USER, DELIVERY.UPDATE_TS
        )
            .apply {
                stops.forEach {
                    values(
                        deliveryId, it.type, it.name,
                        it.location_id, it.sequence_num, it.eventTs,
                        "SYSTEM", OffsetDateTime.now(), "SYSTEM", OffsetDateTime.now()
                    )
                }
            }
            .execute()

        return dslContextFirst.insertInto(
            DELIVERY_LEG, DELIVERY_LEG.DELIVERY_ID, DELIVERY_LEG.TYPE, DELIVERY_LEG.NAME,
            DELIVERY_LEG.LOCATION_ID, DELIVERY_LEG.SEQUENCE_NUM, DELIVERY_LEG.EVENT_DATE_TIME,
            DELIVERY.CRTE_USER, DELIVERY.CRTE_TS, DELIVERY.UPDATE_USER, DELIVERY.UPDATE_TS
        )
            .apply {
                stops.forEach {
                    values(
                        deliveryId, it.type, it.name,
                        it.location_id, it.sequence_num, it.eventTs,
                        "SYSTEM", OffsetDateTime.now(), "SYSTEM", OffsetDateTime.now()
                    )
                }
            }
            .execute()


    }

    fun getAllSchemaNames(): List<String>? {
        val result: Result<Record>? = dslContextFirst.fetch(sql)
        println(result?.size)
        println(result)
        val sequenceList =  result?.map {
            it[2]
        } as List<String>

        println("sequenceList : $sequenceList" )
        sequenceList.map { seqName ->
            val currentSequenceValueSql = "SELECT last_value FROM  $seqName"
            dslContextFirst.fetch(currentSequenceValueSql)
                .map{
                    val currSequenceValue = it[0]
                    println("currSequenceValue : $currSequenceValue")
                    val alterSequenceSql = """
                        ALTER sequence IF EXISTS jooqtest.$seqName 
                        MINVALUE $currSequenceValue
                        START $currSequenceValue
                        RESTART $currSequenceValue;
                    """.trimIndent()

                    val returnedValue = dslContextSecond.query(alterSequenceSql).execute()
                    println("returnedValue : $returnedValue")

                }

        }

        return  sequenceList
    }


    fun getAllSchemaNames_1(): List<String>? {
        val result: Result<Record>? = dslContextSecond.fetch(sql)
        println(result?.size)
        println(result)
        val sequenceList =  result?.map {
            it[2]
        } as List<String>

        println("sequenceList : $sequenceList" )
        sequenceList.map { seqName ->
            val currentSequenceValueSql = "SELECT last_value FROM  $seqName"
            dslContextSecond.fetch(currentSequenceValueSql)
                .map{
                    val currSequenceValue = it[0]
                    println("currSequenceValue : $currSequenceValue")
                    val alterSequenceSql = """
                        ALTER sequence IF EXISTS jooqtest.$seqName 
                        MINVALUE $currSequenceValue
                        START $currSequenceValue
                        RESTART $currSequenceValue;
                    """.trimIndent()

                    val returnedValue = dslContextSecond.query(alterSequenceSql).execute()
                    println("returnedValue : $returnedValue")

                }

        }

        return  sequenceList
    }


    fun getAllDeliveryLegsByDeliveryId(deliveryId: Int?): List<DeliveryLeg>? {
        val deliveryLegList = dslContextFirst.select()
            .from(DELIVERY_LEG)
            .where(DELIVERY_LEG.DELIVERY_ID.eq(deliveryId))
            .fetchInto(DeliveryLeg::class.java)
        return deliveryLegList

    }
}