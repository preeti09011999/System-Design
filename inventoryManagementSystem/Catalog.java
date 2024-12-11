
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalog implements Search{
    private HashMap<String, List<Product>> products;

    @Override
    public List<Product> searchProductsByName(String name){
        return new ArrayList<>();
    }

    @Override
    public List<Product> searchProductsByCategory(String category){
        return new ArrayList<>();
    }
}
