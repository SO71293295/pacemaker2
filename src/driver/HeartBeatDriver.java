package driver;

import controller.HeartBeatController;
import listeners.HeartBeatListener;
import model.HeartModel;
import view.HeartPRView;
import view.HeartRateView;
import view.HeartView;
import view.WholeView;

public class HeartBeatDriver {
    public static void main(String[] args) {
        new HeartBeatDriver();
    }

    public HeartBeatDriver() {
        HeartBeatController controller = new HeartBeatController();
        HeartPRView heartPRView = new HeartPRView();
        HeartRateView heartRateView = new HeartRateView();
        HeartView heartview = new HeartView();
        HeartModel model = new HeartModel();
        model.on();

        controller.setHearView(heartview);
        controller.setHeartModel(model);
        heartPRView.setController(controller);
        WholeView wholeView = new WholeView();
        wholeView.setHeartPRView(heartPRView);
        wholeView.setHeartRateView(heartRateView);
        wholeView.setHeartview(heartview);
        model.addHeartBeatListener(heartPRView);

        wholeView.init();
        heartview.setGrain(3);

        model.setRate(444);



    }
}
