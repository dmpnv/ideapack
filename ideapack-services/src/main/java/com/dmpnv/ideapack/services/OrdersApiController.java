package com.dmpnv.ideapack.services;

import com.dmpnv.ideapack.api.ApiUtil;
import com.dmpnv.ideapack.api.OrdersApi;
import com.dmpnv.ideapack.model.Order;
import com.dmpnv.ideapack.model.OrderList;
import com.dmpnv.ideapack.persistence.OrderCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.ideapack.base-path:/}")
public class OrdersApiController implements OrdersApi {

    @Autowired
    private OrderCollectionService orderCollectionService;
    /*private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrdersApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }*/

    @Override
    public ResponseEntity<OrderList> getOrders() {
        List<Order> orders = orderCollectionService.findOrders();
        orders.forEach(order -> {
            order.setShipDate(OffsetDateTime.now());
            order.setDeliveryDate(OffsetDateTime.now());
        });
        OrderList orderList = new OrderList();
        orderList.setOrders(orders);
        return ResponseEntity.ok(orderList);
    }


}
