package com.learnjooq.service

import com.learnjooq.dao.DeliveryDao
import com.learnjooq.dto.DeliveryDTO
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeliveryService(@Autowired val deliveryDao: DeliveryDao) {

    fun addNewDelivery( delivery : DeliveryDTO) : Int?{

        val deliveryId = deliveryDao.addNewDelivery(delivery)
        //deliveryDao.addDeliveryLegs(deliveryId, delivery.stops)
        return deliveryId
    }
}