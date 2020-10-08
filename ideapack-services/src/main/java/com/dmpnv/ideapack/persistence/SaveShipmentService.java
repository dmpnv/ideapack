package com.dmpnv.ideapack.persistence;

import com.dmpnv.ideapack.model.Order;
import com.dmpnv.ideapack.model.Shipment;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class SaveShipmentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Order saveShipment(String supplier, @NotNull  Shipment shipment) {
        String orderId = shipment.getOrderId();
        if (StringUtils.isEmpty(supplier) || StringUtils.isEmpty(orderId)) {
            throw new IllegalArgumentException("Both supplier and supplierOrderId shouldn't be empty");
        }
        Query query = new Query(
                    Criteria.where("supplier").is(supplier)
                            .andOperator(Criteria.where("supplierOrderId").is(orderId)));
        Update update = new Update().set("shipment", shipment);
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(false);
        Order result = mongoTemplate.findAndModify(query, update, options, Order.class);
        return result;
    }
}
