package com.learnjooq.service

import com.learnjooq.BaseIntegrationTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import spock.lang.Unroll

import static com.learnjooq.helper.TestHelper.*

@SqlGroup([
        @Sql(scripts = ["/sql/TearDown.sql"], executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
])
@Unroll
class DeliveryServiceSpecIT extends BaseIntegrationTest {

    @Autowired
    DeliveryService deliveryService

    def "addNewDelivery"() {

        given:
            def delivery = buildDelivery()
        when:
            def result = deliveryService.addNewDelivery(delivery)
            println("result : $result")

        then:
            result

    }

    def "getDeliveryLegById"() {


        given:
            def deliveryId = deliveryService.addNewDelivery(buildDelivery())

        when:
            def deliveryDTO = deliveryService.getDeliveryById(deliveryId)

        then:
            deliveryDTO.id
            deliveryDTO.stops.size() == 2
            deliveryDTO.stops.get(0).id
            deliveryDTO.stops.get(0).deliveryId
            deliveryDTO.stops.get(0).location_id
            deliveryDTO.stops.get(0).sequence_num
            deliveryDTO.stops.get(0).type


    }
}
