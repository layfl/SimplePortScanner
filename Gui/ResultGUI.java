package Gui;

import Misc.Tools;

import javax.swing.*;
import java.awt.*;
import java.util.TreeMap;

/**
 * Created by layfl on 23.02.2016.
 */
public class ResultGUI extends JFrame {


    private JTable table;
    private JPanel panel;
    private JScrollPane scrollPane;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public ResultGUI(TreeMap<String, String> data) {


        /* initializations */

        String[] columnNames = {"Port","Status"};
        table = new JTable(Tools.treeMapToStringArray(data), columnNames);
        panel = new JPanel();


        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("layf port scanner - results");
        this.setSize(WIDTH, HEIGHT);
        //this.setResizable(false);
        scrollPane = new JScrollPane(table);

        panel.add(scrollPane);
        this.add(panel, BorderLayout.CENTER);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }
}
