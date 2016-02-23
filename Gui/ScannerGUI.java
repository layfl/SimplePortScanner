package Gui;

import Misc.Tools;
import ScanTools.ScannerTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by layfl on 23.02.2016.
 */
public class ScannerGUI extends JFrame {

    private JPanel panel;
    private JLabel[] labels;
    private JTextField textfields[];
    private JButton button;


    public ScannerGUI(int width, int height) {

        /* initializations */
        panel = new JPanel();
        labels = new JLabel[3];

        labels[0] = new JLabel("Ip address: ");
        labels[1] = new JLabel("Port from: ");
        labels[2] = new JLabel("to");

        textfields = new JTextField[3];

        textfields[0] = new JTextField(25);
        textfields[1] = new JTextField(5);
        textfields[2] = new JTextField(5);

        button = new JButton("Scan");

        /* building gui */

        panel.add(labels[0]);
        panel.add(textfields[0]);
        panel.add(labels[1]);
        panel.add(textfields[1]);
        panel.add(labels[2]);
        panel.add(textfields[2]);
        panel.add(button);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String ip = textfields[0].getText();
                String from = textfields[1].getText();
                String to = textfields[2].getText();

                if(ip.isEmpty() || from.isEmpty() || to.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Empty fields!");
                }
                else if(!Tools.isNumber(from) || !Tools.isNumber(to)) {
                    JOptionPane.showMessageDialog(null, "Port must be a number!");
                }
                else if(!Tools.checkAddressIp(ip)) {
                    JOptionPane.showMessageDialog(null, "Wrong IP ADDRESS!");
                }
                else if(!Tools.checkPortRange(Integer.valueOf(from), Integer.valueOf(to))) {
                    JOptionPane.showMessageDialog(null, "Wrong PORT RANGE [1-65535] or FROM > TO!");
                }
                else {
                    ScannerTool sc = new ScannerTool(ip, Integer.valueOf(from), Integer.valueOf(to));
                    sc.scan();

                    ResultGUI resGUI = new ResultGUI(sc.getResultStatus());
                    resGUI.setVisible(true);
                }
            }
        });

        this.add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("layf port scanner");
        this.setSize(width, height);
        this.setResizable(false);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

}
