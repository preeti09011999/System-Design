
import java.util.List;

public class Product {
    int productId;
    String productName;
    String productDesc;
    double price;
    int availableItemCount;
    ProductCategory productCategory;
    List<Review> productReviews;

    public boolean updatePrice(double price){
        this.price = price;
        return true;
    }

    public int updateAvailableItemCount(int count){
        availableItemCount += count;
        return availableItemCount;
    }
}
