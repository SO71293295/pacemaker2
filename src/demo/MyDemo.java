package demo;

import javax.swing.*;

public class MyDemo {
    public static void main(String[] args) {
        JFrame frame = new MyFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,450);
        frame.setVisible(true);
    }
}
