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
        String id = order.getId();
        Order result;
        if (StringUtils.isEmpty(id)) {
            result = mongoTemplate.save(order);
        }else {
            Query query = new Query(Criteria.where("id").is(id));
            Update update = new Update()
                    .set("supplierOrderId", order.getSupplierOrderId())
                    .set("supplier", order.getSupplier())
                    .set("sender", order.getSender())
                    .set("recipient", order.getRecipient());
            FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(false);
            result = mongoTemplate.findAndModify(query, update, options, Order.class);
        }
        return result;
    }
}
