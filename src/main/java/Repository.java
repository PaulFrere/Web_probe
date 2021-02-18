import java.util.List;

public interface Repository {
    void create(String title, float cost);

    Product get(int id);

    List<Product> getAll();

    void update(int id, String title, float cost);

    void delete(int id);
}