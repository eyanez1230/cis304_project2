
public class Music extends Product {
    // Initate class variables
    String artist, format, musicFile;

    // Class consutrctor
    Music(String ID, String name, String medium, String artist, String genre, String format, int qty, String imageURL, String musicFile) {
        super(ID, name, genre, medium, qty, imageURL);
        this.artist = artist;
        this.format = format;
        this.qty = qty;
        this.musicFile = musicFile;
    }

    // Overwrite Java's to string to output with line breaks
    public String toString() {
        String msg = "";
        msg += super.toString();
        msg += "Arist: " + artist + "\n";
        msg += "Format: " + format + "\n";

        return msg;
    }
}
