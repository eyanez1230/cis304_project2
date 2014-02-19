
import java.util.HashMap;

public class ProductDB {
    // Create an inventory hashmap to store products
    HashMap contents = new HashMap();

    ProductDB() {

        // Create products and add to inventory
        Book HPDH = new Book(
                "HPDH",
                "Harry Potter and the Deathly Hallows",
                "Book",
                "J.K. Rowling",
                "Wizarding",
                784,
                3,
                "images/HPDH.jpg");

        contents.put(HPDH.ID, HPDH);

        Book CSH = new Book(
                "CSH",
                "The Complete Sherlock Holmes",
                "Book",
                "Sir Arthur Conan Doyle",
                "Who Done It",
                944,
                2,
                "images/CSH.jpg");

        contents.put(CSH.ID, CSH);

        Book PL = new Book(
                "PL",
                "Pirate Latitudes",
                "Book",
                "Michael Crichton",
                "Adventure",
                320,
                1,
                "images/PL.jpg");

        contents.put(PL.ID, PL);

        Music HWGA = new Music(
                "HWGA",
                "Here We Go Again",
                "Music",
                "Wynton Marsalis",
                "blues",
                "audio CD",
                3,
                "images/HWGA.jpg",
                "preview/Hedwig_Theme.wav");

        contents.put(HWGA.ID, HWGA);

        Music MC = new Music(
                "MC",
                "McCartney",
                "Music",
                "Paul McCartney",
                "rock",
                "MP3 Download",
                2,
                "images/MC.jpg",
                "preview/Raiders.wav");

        contents.put(MC.ID, MC);

        Video KS = new Video(
                "KS",
                "The King's Speech",
                "Drama",
                "Video",
                "R (Language)",
                "Colin Firth/Helena Bonham Carter/Geoffrey Rush/Guy Pearce",
                "Tom Hooper",
                "119 Minutes",
                "DVD",
                "2010",
                1,
                "images/KS.jpg");

        contents.put(KS.ID, KS);

        Video HW = new Video(
                "HW",
                "The Horse Whisperer",
                "Drama",
                "Video",
                "PG-13",
                "Robert Redford/Kristin Scott Thomas,",
                "Robert Redford/Robert Richardson",
                "169 Minutes",
                "Blu-ray",
                "1998",
                1,
                "images/HW.jpg");

        contents.put(HW.ID, HW);

        // Add avengers and transformers movies
        Video AVG = new Video(
                "AVG",
                "The Avengers",
                "Action",
                "Video",
                "PG-13",
                "Robert Downey Jr, Chris Evans, Scarlett Johansson",
                "Joss Whedon",
                "143 Minutes",
                "Blu-ray",
                "2012",
                1,
                "images/AVG.jpg");

        contents.put(AVG.ID, AVG);

        Video TRNS = new Video("TRNS",
                "Transformers",
                "Action",
                "Video",
                "PG-13",
                "Shia Lebouf, Megan Fox",
                "Michael Bay",
                "144 Minutes",
                "DVD",
                "2007",
                1,
                "images/TRNS.jpg");

        contents.put(TRNS.ID, TRNS);
    }
}
