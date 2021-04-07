package ph.apper.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.apper.product.payload.Product;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    //TODO
    //Get Product {productId}
    //200 name, 1000

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Product request) {
        Product product = new Product();
        product.setName("UnliData to the Max"); // request.getName()
        product.setPrice(1000.00); // request.getPrice()
        product.setProductId("123443re"); // generate productId, response
        System.out.println(product);
        products.add(product);
        return ResponseEntity.ok().build();
    }
}
