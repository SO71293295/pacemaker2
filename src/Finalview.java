import listeners.HeartBeatListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finalview implements ActionListener, ChangeListener {
    Frame frame =new Frame("cehis");

    TextArea ta = new TextArea(5,10);

    //左上的按钮
    TextField modelName = new TextField("Model");
    Button off = new Button("OFF");
    Button AAI = new Button("AAI");
    Button VDD = new Button("VDD");
    Button DDO = new Button("DDO");

    //右上模块
    TextField heart = new TextField("Heart");
    TextField rate = new TextField("Heart Rate：70 bpm");
    TextField PR = new TextField("PR Interval：150 bpm");
    Button reset = new Button("ReSet");

    //底部的按钮
    TextField batteryLevel = new TextField("Battery Level");
    Checkbox batteryFailure = new Checkbox("BatteryFailure");
    Checkbox leedsFailureOnSA = new Checkbox("Leeds Failure On SA Node");
    Checkbox leedsFailureOnAV = new Checkbox("Leeds Failure On AV Node");

    List colorList = new List(6,true);

    HeartControl c = new HeartControl();
    HeartControl c1 = new HeartControl();
    Huadong h = new Huadong();

    public void init() {
        //组装界面

        //组装底部
        Box bBox = Box.createVerticalBox();
        bBox.add(batteryLevel);
        bBox.add(batteryFailure);
        bBox.add(leedsFailureOnSA);
        bBox.add(leedsFailureOnAV);

        frame.add(bBox, BorderLayout.SOUTH);


        //组装左边选择部分
        Box cBox = Box.createVerticalBox();
        cBox.add(off);
        cBox.add(modelName);
        cBox.add(AAI);
        cBox.add(VDD);
        cBox.add(DDO);

        //组装右边选择部分
        Box dBox = Box.createVerticalBox();
        dBox.add(rate);
        dBox.add(h.Huadong());
        dBox.add(PR);
        dBox.add(h.Huadong());
        dBox.add(reset);


        Box top = Box.createHorizontalBox();
        top.add(cBox);
        top.add(dBox);

        Box top3 = Box.createVerticalBox();
        c.setPreferredSize(new Dimension(1000, 200));
        c1.setPreferredSize(new Dimension(1000, 200));
        top3.add(c);
        top3.add(c1);
        top3.add(top);


        frame.add(top3);


        //设置frame为最佳大小，并且可见
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Finalview().init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("1");
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int freq = ((JSlider)e.getSource()).getValue();
    }
}
