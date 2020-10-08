package com.dmpnv.ideapack.services;

import com.dmpnv.ideapack.api.OrderApi;
import com.dmpnv.ideapack.model.Order;
import com.dmpnv.ideapack.model.Shipment;
import com.dmpnv.ideapack.persistence.SaveOrUpdateOrderService;
import com.dmpnv.ideapack.persistence.SaveShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.ideapack.base-path:/}")
public class OrderApiController implements OrderApi {

    /*private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }*/
    private final SaveOrUpdateOrderService saveOrUpdateOrderService;

    private final SaveShipmentService saveShipmentService;

    public OrderApiController(SaveOrUpdateOrderService saveOrUpdateOrderService, SaveShipmentService saveShipmentService) {
        this.saveOrUpdateOrderService = saveOrUpdateOrderService;
        this.saveShipmentService = saveShipmentService;
    }

    @Override
    public ResponseEntity<Order> saveOrUpdateOrder(@Valid Order order) {
        Order result = saveOrUpdateOrderService.saveOrUpdateOrder(order);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Order> saveShipment(String supplier, @Valid Shipment body) {
        Order result = saveShipmentService.saveShipment(supplier, body);
        return ResponseEntity.ok(result);
    }
}
