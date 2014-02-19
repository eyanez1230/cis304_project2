
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Controller {
    // Initiate classes. If we initate them inside the functions, values get cleared since we overwrite them.
    ProductDB inventory = new ProductDB();
    Cart cart = new Cart();

    String addToCart(String key) {
        String msg = "";

        // Get information from product hashmap by key
        Product product = (Product) inventory.contents.get(key);

        // Check if key exists in the inventory hashmap
        if (inventory.contents.containsKey(key)) {
            // Check if product reads "Out of stock" or if product is a string of 0.  String of zero should never happen but we use this just in case
            if (product.qty == 0) {
                msg = "\n" + product.name + " is currently out of stock. You cannot add this to your cart. \n";
            } else if (product.qty >= 0) { // Added this to not parse string if it reads out of stock. Crashes if we do.
                // Parse string to integer 
                int inventoryCount = product.qty;

                // Set the quantity that you have in the cart and add to hashmap.
                if (!cart.cartItems.containsKey(key)) {
                    String name = product.name;
                    int qty = 1;

                    // Add cart information to the cart hashmap.
                    Cart cartDB = new Cart(key, name, qty);
                    cart.cartItems.put(cartDB.ID, cartDB);
                } else {
                    Cart cartDB = (Cart) cart.cartItems.get(key);
                    cartDB.qty++;
                }

                // Subtract from inventory everytime we add to our cart.
                int updatedQty = inventoryCount - 1;

                product.qty = updatedQty;

                msg = "\n" + product.name + " added to cart successfully. \n";
            }
        } else {
            msg = "\n" + "Product code not found. \n";
        }
        return msg;
    }

    String getCartItems() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String dateNow = dateFormat.format(date);

        //Get product keys and return listing and build an array list
        ArrayList<String> keys = new ArrayList(cart.cartItems.keySet());
        // Sort keys alphabetically
        Collections.sort(keys);

        String listing = "\n" + "Cart Contents: " + dateNow + "\n";

        int index;
        // Loop through all the keys in array list
        for (index = 0; index < keys.size(); index++) {
            // Find information in product hashmap from product class
            Cart cartDB = (Cart) cart.cartItems.get(keys.get(index));
            // Output product information
            listing += "Product Code: " + cartDB.ID.toUpperCase() + ", Product Name: " + cartDB.name + ", Quantity in cart: " + cartDB.qty + "\n"; // TODO: Display more information
        }

        if (index == 0) {
            listing = "\n" + "There are no items in the cart.\n";
        }

        return listing;
    }

    String removeFromCart(String key) {
        String msg = "";
        Product product = (Product) inventory.contents.get(key);

        if (cart.cartItems.containsKey(key) && inventory.contents.containsKey(key)) {
            Cart cartDB = (Cart) cart.cartItems.get(key);

            // Remove from cart completely if the quantity goes from 1 to 0.
            if (cartDB.qty <= 1) {
                cart.cartItems.remove(key);
            } else {
                cartDB.qty--;
            }

            msg = "\n" + product.name + " removed from cart successfully. \n";

            // Add back to inventory
            if (product.qty >= 0) {
                product.qty++;
            }
        } else {
            msg = "\n" + "The entered item is not in the cart. \n";
        }

        return msg;
    }

    String getProductDetails(String key) {
        String msg;

        // Check if key is found in hashmap
        if (inventory.contents.containsKey(key)) {
            // Find inventory information by key in hashmap and convert to string
            msg = inventory.contents.get(key).toString();
        } else {
            msg = "\n" + "Product code not found \n";
        }
        return msg;
    }

    String listContents() {
        String productQty = "";

        //Get product keys and return listing and build an array list
        ArrayList<String> keys = new ArrayList(inventory.contents.keySet());
        // Sort keys alphabetically
        Collections.sort(keys);

        // Build listing and return result
        String listing = "\n";
        // Loop through all the keys in array list
        for (int index = 0; index < keys.size(); index++) {
            Product product = (Product) inventory.contents.get(keys.get(index));

            if (product.qty == 0) {
                productQty = "Out of stock";
            } else {
                productQty = Integer.toString(product.qty);
            }

            listing += "Product Code: " + product.ID.toUpperCase() + ", Product Name: " + product.name + ", Quantity Available: " + productQty + "\n";
        }

        return listing;
    }
}
