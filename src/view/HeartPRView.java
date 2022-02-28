package view;

import controller.HeartBeatController;
import listeners.HeartBeatListener;
import model.HeartModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class HeartPRView extends JPanel  implements ChangeListener, HeartBeatListener {
    JSlider slider;
    HeartBeatController heartBeatController;

    public HeartPRView(){
        slider = new JSlider();
        slider.setMaximum(200);
        slider.setMinimum(1);
        slider.setValue(70);
        slider.addChangeListener(this);
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(new JLabel("frequency："));
        sliderPanel.add(slider);
        add(sliderPanel, BorderLayout.SOUTH);

        setVisible(true);


        }

    @Override
    public void stateChanged(ChangeEvent e) {
        int freq =  ((JSlider)e.getSource()).getValue();
        heartBeatController.setRate(freq);
    }

    public void setController(HeartBeatController heartBeatController) {
        this.heartBeatController = heartBeatController;
    }

    @Override
    public void onHeartBeat() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {}
    }
}
