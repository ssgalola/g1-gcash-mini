package ph.apper.purchase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.apper.product.exception.ProductNotFoundException;
import ph.apper.product.payload.AddProduct;
import ph.apper.product.payload.AddProductResponse;
import ph.apper.product.payload.GetProductResponse;
import ph.apper.product.payload.ProductData;
import ph.apper.product.service.ProductService;

import javax.validation.Valid;
import java.util.List;

//Purchase
@RestController
@RequestMapping("purchase")
public class PurchaseController {

//        @PostMapping
//        public ResponseEntity create(@RequestBody Request request) {
//            System.out.println(request);
//
//            return ResponseEntity.ok().build();
//        }
    }
