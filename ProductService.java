package com.example.springproject.services;

        import com.example.springproject.entities.Product;
        import com.example.springproject.services.interfaces.IProductService;
        import lombok.Builder;
        import org.springframework.stereotype.Service;
        import java.util.ArrayList;
        import java.util.List;

@Service
public class ProductService implements IProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "PlayStation 5", "Simple description", 67000, "Krasnoyarsk", "tomas"));
        products.add(new Product(++ID, "Iphone 8", "Simple description", 24000, "Moscow", "artmcoder"));
    }
    @Override
    public List<Product> list() { return products; }

    @Override
    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    @Override
    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId() == id);
    }
    @Override
    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId() == id) return product;
        }
        return null;
    }
}
