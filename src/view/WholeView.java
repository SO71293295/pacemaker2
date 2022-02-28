package view;

import controller.HeartBeatController;
import listeners.HeartBeatListener;
import model.HeartModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class WholeView implements MouseListener{
    HeartPRView heartPRView;
    HeartRateView heartRateView;
    HeartView heartview;
    HeartBeatController controller;

    Frame frame =new Frame("cehis");


    public void init(){


        Box bBox = Box.createVerticalBox();
        heartview.setPreferredSize(new Dimension(1000, 200));
        bBox.add(heartview);
        bBox.add(heartPRView);
        bBox.add(heartRateView);

        bBox.addMouseListener(this);
        frame.add(bBox);
        //设置frame为最佳大小，并且可见

        frame.pack();
        frame.setVisible(true);
    }

    public HeartPRView getHeartPRView() {
        return heartPRView;
    }

    public void setHeartPRView(HeartPRView heartPRView) {
        this.heartPRView = heartPRView;
    }

    public HeartRateView getHeartRateView() {
        return heartRateView;
    }

    public void setHeartRateView(HeartRateView heartRateView) {
        this.heartRateView = heartRateView;
    }

    public HeartView getHeartview() {
        return heartview;
    }

    public void setHeartview(HeartView heartview) {
        this.heartview = heartview;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(controller.getRate());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        heartview.setGrain(controller.getRate());
        System.out.println(controller.getRate());
        heartview.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        heartview.setGrain(controller.getRate());
        System.out.println(controller.getRate());
        heartview.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
