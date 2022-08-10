package com.learnjooq.dto

import java.time.LocalDateTime

data class DeliveryDTO(
        var id: Long? = null,
        var stops: MutableList<DeliveryLegDTO> = mutableListOf<DeliveryLegDTO>(),
        var createTs: LocalDateTime? = null,
        var createUser: String? = null,
        var updateTs: LocalDateTime? = null,
        var updateUser: String? = null
        ) {

    constructor(id: Long? = null,
                stops: MutableList<DeliveryLegDTO> = mutableListOf<DeliveryLegDTO>()) : this(id, stops,
            LocalDateTime.now(), "SYSTEM", LocalDateTime.now(), "SYSTEM") {

    }
}
