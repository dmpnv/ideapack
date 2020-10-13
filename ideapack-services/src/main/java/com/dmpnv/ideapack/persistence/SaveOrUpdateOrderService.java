package com.dmpnv.ideapack.persistence;

import com.dmpnv.ideapack.model.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

@Service
public class SaveOrUpdateOrderService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Order saveOrUpdateOrder(Order order) {
        if (StringUtils.isEmpty(order.getSupplier()) || StringUtils.isEmpty(order.getSupplierOrderId())) {
            throw new IllegalArgumentException("Both supplier and supplierOrderId shouldn't be empty");
        }
        String id = order.getId();
        Query query = null;
        if (StringUtils.isEmpty(id)) {
            query = new Query(
                    Criteria.where("supplier").is(order.getSupplier())
                            .andOperator(Criteria.where("supplierOrderId").is(order.getSupplierOrderId())));
        }else {
            query = new Query(Criteria.where("_id").is(id));
        }
        Update update = new Update()
                .set("sender", order.getSender())
                .set("recipient", order.getRecipient())
                .set("quantity", order.getQuantity())
                .set("shipDate", order.getShipDate())
                .set("deliveryDate", order.getDeliveryDate())
                .set("_class", Order.class.getName());
        if (StringUtils.isEmpty(id)) {
            update = update.set("supplierOrderId", order.getSupplierOrderId())
                            .set("supplier", order.getSupplier());
        }
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);
        Order result = mongoTemplate.findAndModify(query, update, options, Order.class);
        /*order.setId(result.getId());
        result = mongoTemplate.save(order);*/
        return result;
    }
}
