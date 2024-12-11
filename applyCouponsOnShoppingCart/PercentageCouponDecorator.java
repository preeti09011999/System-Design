package applyCouponsOnShoppingCart;

class PercentageCouponDecorator extends CouponDecorator{
    Product product;
    int discountPercentage;

    PercentageCouponDecorator(Product product, int discountPercentage){
        this.product = product;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        return product.getPrice() - (product.getPrice() * discountPercentage)/100;
    }
    
}