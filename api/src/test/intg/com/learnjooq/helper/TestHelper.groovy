package com.learnjooq.helper

import com.learnjooq.dto.DeliveryDTO
import com.learnjooq.dto.DeliveryLegDTO

import java.time.LocalDateTime

class TestHelper {

    static def buildDelivery() {
        DeliveryLegDTO deliveryLeg = new DeliveryLegDTO(null, null, "STORE", "1088", "1088", 1, LocalDateTime.now())
        DeliveryDTO delivery = new DeliveryDTO(null, Arrays.asList(deliveryLeg))
        return delivery
    }
}
