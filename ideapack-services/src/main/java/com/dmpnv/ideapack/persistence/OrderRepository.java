package com.dmpnv.ideapack.persistence;

import com.dmpnv.ideapack.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
