package controller;

import model.HeartModel;
import view.HeartView;

public class HeartBeatController {
    HeartView heartview;
    HeartModel heartModel;

    int rate;

    public HeartBeatController() {

    }

    public void setRate(int rate) {
        this.rate= rate;
        heartModel.setRate(this.rate);
    }

    public int getRate(){
        return this.rate;
    }


    public void setHearView(HeartView heartview) {
        this.heartview = heartview;
    }

    public void setHeartModel(HeartModel heartModel) {
        this.heartModel = heartModel;
    }
}
