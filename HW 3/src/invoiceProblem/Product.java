package invoiceProblem;

/**
A product with a price and description.
*/
public class Product implements LineItem
{
/**
   Constructs a product.
   @param description the description
   @param price the price
*/
public Product(String description, double price)
{
   this.description = description;
   this.price = price;
}

public int hashCode() {
	return description.hashCode();
}

public boolean equals(Object obj) {
	LineItem item = (LineItem) obj;
	if(item.toString().equals(description) && item.getPrice() == price) {
		return true;
	} else {
		return false;
	}
}



public double getPrice() { return price; }
public String toString() { return description; }
private String description;
private double price;

}
