package com.learnjooq.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.learnjooq.BaseIntegrationTest
import com.learnjooq.dto.DeliveryDTO
import com.learnjooq.service.DeliveryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Unroll
import static com.learnjooq.helper.TestHelper.*

@AutoConfigureWebTestClient
/*
@SqlGroup([
        @Sql(scripts = ["/sql/TearDown.sql"], executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
])
*/
@Unroll
class DeliveryControllerSpecIT extends BaseIntegrationTest {

    @Autowired
    WebTestClient webTestClient

    @Autowired
    DeliveryService deliveryService

    @Autowired
    ObjectMapper objectMapper

    def "Add New  Delivery"() {

        given:
            def inputJsonFile = readJson(ADD_DELIVERY_FILE)

        expect:
            webTestClient.post()
                    .contentType(MediaType.APPLICATION_JSON)
                    .uri("/v1/delivery")
                    .syncBody(inputJsonFile)
                    .exchange()
                    .expectStatus().isCreated()


    }

    def "retrieveDelivery"() {

        given:
            def deliveryId = deliveryService.addNewDelivery(buildDelivery())

        expect:
            webTestClient.get()
                    .uri("/v1/delivery/{id}", deliveryId)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(DeliveryDTO.class)
                    .consumeWith({
                        def deliveryDTO = (DeliveryDTO) it.getResponseBody()
                        deliveryDTO.id != null
                        deliveryDTO.stops.size() == 2 })
    }
}
