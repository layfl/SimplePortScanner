import Gui.ScannerGUI;

/**
 * Created by layfl on 23.02.2016.
 */
public class PortScanner {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 100;

    public static void main(String[] args) {
        ScannerGUI gui = new ScannerGUI(WIDTH, HEIGHT);
        gui.setVisible(true);
    }

}
