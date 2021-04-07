package ph.apper.product.payload;

import lombok.Data;

@Data
public class Product {
    private String name;
    private Double price;
    private String productId;
}
