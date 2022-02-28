package view;

import controller.HeartBeatController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class HeartRateView extends JPanel {
    JSlider slider;
    HeartBeatController heartBeatController;
    public HeartRateView(){
        slider = new JSlider();
        slider.setMaximum(200);
        slider.setMinimum(1);
        slider.setValue(70);
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(new JLabel("frequency："));
        sliderPanel.add(slider);
        add(sliderPanel, BorderLayout.SOUTH);

        setVisible(true);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int freq = ((JSlider)e.getSource()).getValue();

            }
        });
    }

}
