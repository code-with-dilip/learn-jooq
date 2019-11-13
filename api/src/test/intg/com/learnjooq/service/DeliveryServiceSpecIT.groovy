package com.learnjooq.service

import com.learnjooq.BaseIntegrationTest
import com.learnjooq.dto.DeliveryDTO
import com.learnjooq.dto.DeliveryLegDTO
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDateTime

class DeliveryServiceSpecIT extends BaseIntegrationTest{

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

    def buildDelivery() {
        DeliveryLegDTO deliveryLeg = new DeliveryLegDTO(null, null, "STORE", "1088", "1088", 1, LocalDateTime.now())
        DeliveryDTO delivery = new DeliveryDTO(null, Arrays.asList(deliveryLeg))
        return delivery
    }


}
