
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class StoreFrame extends JFrame implements ActionListener {
    // Instantiate menu bar variables
    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;
    private JMenuItem menuItem, textMenuItem, helpMenuItem, aboutMenuItem;
    private JRadioButtonMenuItem rbMenuItem;
    private JCheckBoxMenuItem cbMenuItem;

    public StoreFrame() {
        // Render the menu bar.
        renderMenuBar();

        setTitle("SmartStore.com");
        setSize(1000, 635);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        getContentPane().add(new StorePanel());

        setVisible(true);
    }

    public void renderMenuBar() {
        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        fileMenu = new JMenu("File");
        fileMenu.setFont(new Font("Verdana", Font.PLAIN, 14));
        fileMenu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(fileMenu);

        //a group of JMenuItems
        textMenuItem = new JMenuItem("Exit");
        textMenuItem.setFont(new Font("Verdana", Font.PLAIN, 14));
        textMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        textMenuItem.addActionListener(this);
        fileMenu.add(textMenuItem);

        helpMenu = new JMenu("Help");
        helpMenu.setFont(new Font("Verdana", Font.PLAIN, 14));
        menuBar.add(helpMenu);

        // Build help menu.
        helpMenuItem = new JMenuItem("Help Contents");
        helpMenuItem.setFont(new Font("Verdana", Font.PLAIN, 14));
        helpMenuItem.addActionListener(this);
        helpMenu.add(helpMenuItem);

        // Build about menu item
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setFont(new Font("Verdana", Font.PLAIN, 14));
        aboutMenuItem.addActionListener(this);
        helpMenu.add(aboutMenuItem);

        this.setJMenuBar(menuBar);
    }

    public void actionPerformed(ActionEvent event) {
        // Create object of the action event
        Object source = event.getSource();

        // Set conditionals to perfrom certain actions
        if (source == textMenuItem) {
            // Exit the program
            System.exit(0);
        } else if (source == helpMenuItem) {
            // Build string help information
            String helpInformation = "";
            helpInformation += "To view the inventory click on the View Inventory button.\n";
            helpInformation += "To add to cart, select an item from the inventory and click add to cart.\n";
            helpInformation += "To remove from cart, click view cart, select the item and click remove from cart.\n";
            helpInformation += "To play music, select a music item and click the 'Play' button. To stop music click the 'Stop' button.\n";

            // Show a dialogue box with the built string.
            JOptionPane.showMessageDialog(null, helpInformation);
        } else if (source == aboutMenuItem) {
            // Build string about information
            String aboutMenuItem = "";
            aboutMenuItem += "This application was developed by Enrique Yanez.\n";
            aboutMenuItem += "CIS 304 Project 2.";

            // Show a dialogue box with the built string
            JOptionPane.showMessageDialog(null, aboutMenuItem);
        }
    }
}
