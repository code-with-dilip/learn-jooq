package com.learnjooq.controller

//import com.learnjooq.dto.Delivery
import com.learnjooq.dto.DeliveryDTO
import com.learnjooq.service.DeliveryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder


@RestController
@RequestMapping("/v1")
class DeliveryController(val deliveryService: DeliveryService) {


    @PostMapping("/delivery")
    fun createDelivery( @RequestBody delivery : DeliveryDTO): ResponseEntity<Unit> {
        val deliveryId = deliveryService.addNewDelivery(delivery)
        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(deliveryId)
                .toUri()
        return ResponseEntity.created(location).build<Unit>()
    }

    @GetMapping("/delivery/{id}")
    fun retrieveDelivery(@PathVariable("id") loadId: Int?): ResponseEntity<DeliveryDTO> {

        return ResponseEntity.ok().body(deliveryService.getDeliveryById(loadId))

    }
}