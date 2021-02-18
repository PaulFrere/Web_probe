import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class Memory implements Repository {

    private List<Product> products;

    @Override
    public void create(String title, float cost) {
        products.add(
                Product.builder()
                        .id(products.size())
                        .title(title)
                        .cost(cost)
                        .build()
        );
    }

    @Override
    public Product get(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public void update(int id, String title, float cost) {
        Product product = get(id);
        if (product != null) {
            product.setTitle(title);
            product.setCost(cost);
        }
    }

    @Override
    public void delete(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                break;
            }
        }
    }

    @PostConstruct
    public void init() {
        Random random = new Random();
        products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            products.add(Product.builder()
                    .id(i)
                    .title("Product " + i)
                    .cost((float) Math.abs(random.nextInt(100) * 1.4))
                    .build());
        }
    }

}