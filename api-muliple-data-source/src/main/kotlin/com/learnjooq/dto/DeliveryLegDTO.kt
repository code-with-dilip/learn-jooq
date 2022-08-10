package com.learnjooq.dto

import java.time.LocalDateTime

data class DeliveryLegDTO(
        var id: Long? = null,
        var deliveryId: String? = null,
        var type: String? = null,
        var name: String? = null,
        var location_id: String? = null,
        var sequence_num: Int? = null,
        var eventTs: LocalDateTime? = null,
        var createTs: LocalDateTime? = null,
        var createUser: String? = null,
        var updateTs: LocalDateTime? = null,
        var updateUser: String? = null
) {

    constructor(id: Long? = null,
                loadId: String? = null,
                type: String? = null,
                name: String? = null,
                location_id: String? = null,
                sequence_num: Int? = null,
                eventTs: LocalDateTime? = null) : this(id, loadId, type, name,
            location_id, sequence_num, eventTs,
            LocalDateTime.now(), "SYSTEM", LocalDateTime.now(), "SYSTEM") {

    }
}