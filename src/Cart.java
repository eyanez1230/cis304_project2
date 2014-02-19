
import java.util.HashMap;

public class Cart {
    // Create an cart hashmap to store products    
    HashMap cartItems = new HashMap();
    ProductDB inventory = new ProductDB();

    String ID, name;
    int qty;

    Cart() {

    }

    Cart(String ID, String name, int qty) {
        this.ID = ID;
        this.name = name;
        this.qty = qty;
    }
}
