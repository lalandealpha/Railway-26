package view;

import controller.MyColorController;
import model.MyColorModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyColorView extends JFrame {
    private MyColorModel myColorModel;
    JLabel jLabel;

    public MyColorView() {
        myColorModel = new MyColorModel();
        init();
    }

    private void init() {
        setTitle("My Color");
        setSize(900, 500);
        setLocationRelativeTo(null);
        ActionListener myColorController = new MyColorController(this);

        jLabel = new JLabel("TEXT...", JLabel.CENTER);
        jLabel.setFont(new Font("Arial", Font.BOLD, 100));
        Font font = new Font("Arial", Font.BOLD, 25);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 3));

        JButton jButtonTextRed= new JButton("Red Text");
        jButtonTextRed.setFont(font);
        jButtonTextRed.setForeground(Color.RED);
        jButtonTextRed.addActionListener(myColorController);

        JButton jButtonTextYellow = new JButton("Yellow Text");
        jButtonTextYellow.setFont(font);
        jButtonTextYellow.setForeground(Color.YELLOW);
        jButtonTextYellow.addActionListener(myColorController);

        JButton jButtonTextGreen = new JButton("Green Text");
        jButtonTextGreen.setFont(font);
        jButtonTextGreen.setForeground(Color.GREEN);
        jButtonTextGreen.addActionListener(myColorController);

        JButton jButtonBackgroundRed = new JButton("Red Background");
        jButtonBackgroundRed.setFont(font);
        jButtonBackgroundRed.setBackground(Color.RED);
        jButtonBackgroundRed.setOpaque(true);
        jButtonBackgroundRed.setBorderPainted(false);
        jButtonBackgroundRed.addActionListener(myColorController);

        JButton jButtonBackgroundYellow = new JButton("Yellow Background");
        jButtonBackgroundYellow.setFont(font);
        jButtonBackgroundYellow.setBackground(Color.YELLOW);
        jButtonBackgroundYellow.setOpaque(true);
        jButtonBackgroundYellow.setBorderPainted(false);
        jButtonBackgroundYellow.addActionListener(myColorController);

        JButton jButtonBackgroundRGreen = new JButton("Green Background");
        jButtonBackgroundRGreen.setFont(font);
        jButtonBackgroundRGreen.setBackground(Color.GREEN);
        jButtonBackgroundRGreen.setOpaque(true);
        jButtonBackgroundRGreen.setBorderPainted(false);
        jButtonBackgroundRGreen.addActionListener(myColorController);

        jPanel.add(jButtonTextRed);
        jPanel.add(jButtonTextYellow);
        jPanel.add(jButtonTextGreen);
        jPanel.add(jButtonBackgroundRed);
        jPanel.add(jButtonBackgroundYellow);
        jPanel.add(jButtonBackgroundRGreen);

        this.setLayout(new BorderLayout());
        this.add(jLabel, BorderLayout.NORTH);
        this.add(jPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setTextColor(Color color) {
        jLabel.setForeground(color);
    }

    public void setBackgroundColor(Color color) {
        jLabel.setBackground(color);
        jLabel.setOpaque(true);
    }
}
