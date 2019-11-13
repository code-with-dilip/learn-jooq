package com.learnjooq.dao

import com.learnjooq.BaseIntegrationTest
import com.learnjooq.helper.TestHelper
import org.springframework.beans.factory.annotation.Autowired
import com.learnjooq.dao.DeliveryDao

class DeliveryDaoSpecIT extends BaseIntegrationTest{

    @Autowired
    DeliveryDao deliveryDao;

    def "addDeliveryLegs"() {

        given:
            def deliveryDTO = TestHelper.buildDelivery()

        when:
            def deliveryId = deliveryDao.addNewDelivery(deliveryDTO)
            def rows_updated = deliveryDao.addDeliveryLegs(deliveryId, deliveryDTO.stops)

        then:
            rows_updated==1

    }
}
