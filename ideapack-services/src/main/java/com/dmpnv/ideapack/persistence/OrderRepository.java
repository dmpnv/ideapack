package com.dmpnv.ideapack.persistence;

import com.dmpnv.ideapack.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findAllByOrderByDeliveryDateDesc();
}
