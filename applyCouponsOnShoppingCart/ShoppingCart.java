package applyCouponsOnShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart(){
        this.productList = new ArrayList<>();
    }

    public void addToCart(Product product){
        
        this.productList.add(product);
    }

    public void removeFromCart(){

    }

    public int getTotalPrice(){
        int totalPrice = 0;
            for(Product prod : productList){
                totalPrice += prod.getPrice();
            }
            return totalPrice;
    }
}
