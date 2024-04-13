package edu.eksamensoevelse.Controller;

import edu.eksamensoevelse.Service.ProductOrderService;
import edu.eksamensoevelse.entity.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @PostMapping("/create-ProductOrder")
    public ResponseEntity<ProductOrder> createProductOrder(@RequestBody ProductOrder productOrder) {
        ProductOrder createdProductOrder = productOrderService.createProductOrder(productOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductOrder);
    }

}
