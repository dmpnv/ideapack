package com.dmpnv.ideapack.services;

import com.dmpnv.ideapack.PersistenceTestApplication;
import com.dmpnv.ideapack.model.Order;
import com.dmpnv.ideapack.persistence.SaveOrUpdateOrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = PersistenceTestApplication.class)
@ActiveProfiles("persistenceTest")
public class SaveOrUpdateOrderServiceIntegrationTest {

    @Autowired
    private SaveOrUpdateOrderService saveOrUpdateOrderService;

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void saveOrUpdateOrder() {
    }

    @Test
    public void testSaveOrUpdateOrder() {
        Order order = new Order();
        order.setSupplierOrderId("1");
        Order savedOrder = saveOrUpdateOrderService.saveOrUpdateOrder(order);
        System.out.println("--> savedOrder = " + savedOrder);
    }
}