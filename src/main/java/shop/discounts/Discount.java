package shop.discounts;

import shop.product.Product;

public class Discount {
    private Product product;
    private Integer quantity;
    private Product discountedProduct;
    private Float discount;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setQuantity(Integer qty) {
        this.quantity = qty;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Product setDiscountedProduct(Product product) {
        return this.discountedProduct = product;
    }

    public Product getDiscountedProduct() {
        return this.discountedProduct;
    }

    public Float setDiscount(Float discount) {
        return this.discount = discount;
    }

    public Float getDiscount() {
        return this.discount;
    }
}
