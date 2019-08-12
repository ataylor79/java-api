package shop.discounts;

import shop.product.Product;

public class DiscountBuilder {
    private Product product;
    private Integer quantity = 1;
    private Product discountedProduct;
    private Float discount;

    public DiscountBuilder setProduct(Product product) {
        this.product = product;
        this.discountedProduct = product;
        return this;
    }

    public DiscountBuilder setQuantity(Integer qty) {
        this.quantity = qty;
        return this;
    }

    public DiscountBuilder setDiscountedProduct(Product product) {
        this.discountedProduct = product;
        return this;
    }

    public DiscountBuilder setDiscount(Float amount) {
        this.discount = amount;
        return this;
    }

    public Discount build() {
        Discount newDiscount = new Discount();

        newDiscount.setProduct(this.product);
        newDiscount.setDiscountedProduct(this.discountedProduct);
        newDiscount.setQuantity(this.quantity);
        newDiscount.setDiscount(this.discount);

        return newDiscount;
    }


}
