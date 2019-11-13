package com.learnjooq.controller

//import com.learnjooq.dto.Delivery
import com.learnjooq.dto.DeliveryDTO
import com.learnjooq.service.DeliveryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1")
class DeliveryController(val deliveryService: DeliveryService) {


    @GetMapping("/delivery")
    fun createDelivery( @RequestBody delivery : DeliveryDTO){

    }
}