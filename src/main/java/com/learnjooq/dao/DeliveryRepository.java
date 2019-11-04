package com.learnjooq.dao;

        import com.learnjooq.Tables;
        import com.learnjooq.tables.Delivery;
        import org.jooq.DSLContext;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;

        import static com.learnjooq.tables.Delivery.DELIVERY;

@Repository
public class DeliveryRepository {

    @Autowired
    private DSLContext dslContext;

    public Integer createDelivery() {

        return dslContext.insertInto(DELIVERY,
                DELIVERY.CRTE_USER,
                DELIVERY.UPDATE_USER)
                .values("SYSTEM", "SYSTEM")
                .returning(Tables.DELIVERY.ID).fetchOne().get(Tables.DELIVERY.ID);
    }

}
