package com.learnjooq.helper

import com.fasterxml.jackson.databind.ObjectMapper
import com.learnjooq.dto.DeliveryDTO
import com.learnjooq.dto.DeliveryLegDTO
import com.learnjooq.generated.tables.pojos.Delivery
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDateTime
import java.time.OffsetDateTime

class TestHelper {

    @Autowired
    ObjectMapper objectMapper

    static String ADD_DELIVERY_FILE = "src/test/resources/data/delivery/delivery.json"
    static def buildDelivery() {
        DeliveryLegDTO deliveryLeg = new DeliveryLegDTO(null, null, "STORE", "1088", "1088", 1, LocalDateTime.now())
        DeliveryLegDTO deliveryLeg1 = new DeliveryLegDTO(null, null, "SCF", "60Z", "60Z", 2, LocalDateTime.now())
        DeliveryDTO delivery = new DeliveryDTO(null, Arrays.asList(deliveryLeg,deliveryLeg1))
        return delivery
    }

    static def deliveryJOOQDomain() {

        def deliveryJOOQDomain = new Delivery(null, OffsetDateTime.now(), "SYSTEM", OffsetDateTime.now(), "SYSTEM")
        return deliveryJOOQDomain

    }

    static String readJson(String fileName) {
        return new File(fileName).getText()
    }

    public static void main(String[] args) {
        //ObjectMapper objectMapper = new  ObjectMapper()



    }

}
