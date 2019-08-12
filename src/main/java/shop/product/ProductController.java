package shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product setProduct (@RequestBody Product product) {
        String lowercaseName = product.getName().toLowerCase();
        Product newProduct = new Product(lowercaseName, product.getPrice());
        productService.save(newProduct);
        return newProduct;
    }

    @GetMapping
    public Product getProduct(@RequestParam(value="name") String name) {

        Optional<Product> product = productService.getByName(name);

        if(!product.isPresent()) {
            throw new ProductNotFoundException(name + " not found");
        }

        return product.get();
    }

    @GetMapping(value="/all")
    public List<Product> getProducts() {
        List<Product> products = productService.getAll();

        if(products.isEmpty() ) {
            throw new ProductNotFoundException("no products found");
        }

        return products;
    }


}
