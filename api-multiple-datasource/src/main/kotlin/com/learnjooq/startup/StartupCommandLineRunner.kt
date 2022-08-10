package com.learnjooq.startup

import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class StartupCommandLineRunner(@Qualifier("jooqFirst")
                                val dslContextFirst: DSLContext,
                               @Qualifier("jooqSecond")
                                val dslContextSecond: DSLContext
) : CommandLineRunner{

    var sql = "SELECT * FROM information_schema.sequences\n" +
            "where sequence_schema ='jooqtest';"

    override fun run(vararg args: String?) {
        val sequencesList = dslContextFirst.fetch(sql)?.map {
            it[2]
        } as List<String>

        println("sequence lsit runner : ${sequencesList?.size}")


//        sequencesList.map{
//                    val currentSequenceValueSql = "SELECT last_value FROM $it"
//            dslContextFirst.fetch(currentSequenceValueSql).
//
//            val alterSequenceSql = ("ALTER sequence IF EXISTS $it MINVALUE "
//                    + currentSequenceValue
//                    ) + " MAXVALUE " + trackingNumberSequence.getEndTN() + " START " + currentSequenceValue + " RESTART"
//
//        }

//        val alterSequenceSql = ("ALTER sequence IF EXISTS shipmentlabelfedexosm.tracking_number_sequence MINVALUE "
//                + trackingNumberSequence.getBeginTN()
//                ) + " MAXVALUE " + trackingNumberSequence.getEndTN() + " START " + trackingNumberSequence.getBeginTN() + " RESTART"
    }}