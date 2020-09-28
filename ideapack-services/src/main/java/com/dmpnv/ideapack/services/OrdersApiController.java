package com.dmpnv.ideapack.services;

import com.dmpnv.ideapack.api.ApiUtil;
import com.dmpnv.ideapack.api.OrdersApi;
import com.dmpnv.ideapack.model.OrderList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.ideapack.base-path:/}")
public class OrdersApiController implements OrdersApi {

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
        OrderList orderList = new OrderList();
        return ResponseEntity.ok(orderList);
    }


}
