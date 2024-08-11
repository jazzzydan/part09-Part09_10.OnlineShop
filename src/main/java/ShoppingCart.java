import java.util.*;

public class ShoppingCart {
    private Map<String, Item> cartItems;

    public ShoppingCart() {
        this.cartItems = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.cartItems.containsKey(product)) {
            this.cartItems.get(product).increaseQuantity();
        } else {
            this.cartItems.put(product, new Item(product, 1, price));
        }
    }

    public int price() {
        int totalPrice = 0;
        for (Item item : this.cartItems.values()) {
            totalPrice += item.price();
        }
        return totalPrice;
    }


//    public void print() {
//        for (Item item : this.cartItems.values()) {
//            System.out.println(item.toString());
//        }
//    }

    public void print() {
        // Extract product names
        List<String> productNames = new ArrayList<>(this.cartItems.keySet());

        // Sort the product names alphabetically
        Collections.sort(productNames);

        // Print items in alphabetical order
        for (String productName : productNames) {
            System.out.println(this.cartItems.get(productName).toString());
        }
    }
}
