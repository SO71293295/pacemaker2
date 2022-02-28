package heartnew;

import demo.MyFrame;

import javax.swing.*;

public class HeartDrive {
    public static void main(String[] args) {
        JFrame frame = new HeartFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,450);
        frame.setVisible(true);
    }
}
