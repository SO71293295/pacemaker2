package model;

import listeners.HeartBeatListener;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class HeartModel extends JPanel {
    int rate;

    public HeartModel(){

    }

    ArrayList<ChangeListener> changeListeners = new ArrayList<>();
    public void changeListeners (ChangeListener changeListener) {
        changeListeners.add(changeListener);
    }

    ArrayList<HeartBeatListener> listeners = new ArrayList<>();
    public void addHeartBeatListener(HeartBeatListener listener) {
        listeners.add(listener);
    }

    public void setRate (int freq) {
        this.rate = rate;
    }

    public int getRate(){
        return rate;
    }

    public void on(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(ChangeListener changeListener : changeListeners)

                try {
                    Thread.sleep(60000/60000);
                    System.out.println(rate);
                } catch (InterruptedException e) {}
            }
        }).start();
    }
    }

