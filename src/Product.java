
public abstract class Product {
    // Initate class variables
    String ID, name, genre, medium, imageURL;
    int qty;

    // Constructors
    Product(String ID, String name, String genre, String medium, int qty, String imageURL) {
        this.ID = ID.toUpperCase();
        this.name = name;
        this.genre = genre;
        this.medium = medium;
        this.qty = qty;
        this.imageURL = imageURL;
    }

    public String getQty() {
        String msg = "";
        if (qty == 0) {
            msg = "Out of stock";
        } else {
            msg = Integer.toString(qty);
        }
        return msg;
    }

    public String toString() {
        String msg = "";
        msg += "ID: " + ID + "\n";
        msg += "Name: " + name + "\n";
        msg += "Genre: " + genre + "\n";
        msg += "Medium: " + medium + "\n";
        msg += "Quantity In Inventory: " + this.getQty() + "\n";
        return msg;
    }
}
