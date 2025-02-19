public interface Product {
	String code();
	String description();
	double points();
	void setState(ProductState estado);
	boolean nextState();
	boolean equals(Product p);
}
