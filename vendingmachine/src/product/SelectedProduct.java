package oopexcersise.vendingmachine.src.product;

public class SelectedProduct {
	private Product product;

	public void setProduct(Product product) {
		this.product = product;
	}

	public int value() {
		return product.value();
	}

	public Product product() {
		return product;
	}

}
