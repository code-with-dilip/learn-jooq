package com.learnjooq.dao

import com.learnjooq.BaseIntegrationTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup

import static com.learnjooq.helper.TestHelper.*
import com.learnjooq.service.DeliveryService
import org.springframework.beans.factory.annotation.Autowired

@SqlGroup([
        @Sql(scripts = ["/sql/TearDown.sql"], executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
])
class DeliveryDaoSpecIT extends BaseIntegrationTest {

    @Autowired
    DeliveryDAO deliveryDao;

    @Autowired
    DeliveryService deliveryService

    def "addDeliveryLegs"() {

        given:
            def deliveryDTO = buildDelivery()

        when:
            def deliveryId = deliveryDao.addNewDelivery(deliveryDTO)
            def rows_updated = deliveryDao.addDeliveryLegs(deliveryId, deliveryDTO.stops)

        then:
            rows_updated == 2

    }

    def "getAllSchemaNames"() {

        when:
        def schemaNamesList = deliveryDao.getAllSchemaNames()
        println("schemaNamesList : $schemaNamesList")

        then:
        schemaNamesList!=null
        schemaNamesList.size() == 3
    }



    def "getAllDeliveryLegById"() {

        given:
            def deliveryId = deliveryService.addNewDelivery(buildDelivery())

        expect:
            def deliverylegList = deliveryDao.getAllDeliveryLegsByDeliveryId(deliveryId)
            println("deliverylegList : $deliverylegList")
            deliverylegList.size() == 2

    }
}
