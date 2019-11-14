package com.learnjooq.service

import com.learnjooq.dao.DeliveryDAO
import com.learnjooq.dto.DeliveryDTO
import com.learnjooq.dto.DeliveryLegDTO
import com.learnjooq.generated.tables.pojos.DeliveryLeg
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeliveryService(@Autowired val deliveryDao: DeliveryDAO) {

    fun addNewDelivery( delivery : DeliveryDTO) : Int?{

        val deliveryId = deliveryDao.addNewDelivery(delivery)
        val rowsUpdated =deliveryDao.addDeliveryLegs(deliveryId, delivery.stops)
        logger.info("No of rows updated : $rowsUpdated")
        return deliveryId
    }

    fun getDeliveryById(deliveryId : Int?): DeliveryDTO {

        val deliveryLegList = deliveryDao.getAllDeliveryLegById(deliveryId)
        return mapToDeliveryDTO(deliveryLegList)
    }

    private fun mapToDeliveryDTO(deliveryLegList: List<DeliveryLeg>?) : DeliveryDTO{

        var deliveryDTO = DeliveryDTO()
        deliveryDTO.id = deliveryLegList?.get(0)?.deliveryId?.toLong()

        deliveryLegList?.forEach {
            deliveryDTO.stops.add(DeliveryLegDTO(it.id.toLong(),it.deliveryId?.toString()
                    , it.type,it.name, it.locationId, it.sequenceNum, it.eventDateTime
                    ,it.crteTs.toLocalDateTime(),it.crteUser,it.updateTs.toLocalDateTime(), it.updateUser))
        }
       return  deliveryDTO
    }

    companion object : KLogging()
}