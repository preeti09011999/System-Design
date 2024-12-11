package applyCouponsOnShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator{
    Product product;
    int discountPercentage;
    ProductType productType;

    static List<ProductType> eligibleTypes = new ArrayList<>();
    static {
        eligibleTypes.add(ProductType.FURNITURE_GOODS);
        eligibleTypes.add(ProductType.DECORATIVE_GOODS);
    }

    public TypeCouponDecorator(Product product, int percentage, ProductType productType) {
        this.product = product;
        this.discountPercentage = percentage;
        this.productType = productType;
    }

    @Override
    public double getPrice(){
        double price = product.getPrice();
        if(eligibleTypes.contains(type)){
            return price - (price * discountPercentage) / 100;
        }
        return price;
    }

    
}
