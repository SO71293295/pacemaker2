package view;

import controller.HeartBeatController;
import listeners.HeartBeatListener;

import javax.swing.*;
import java.awt.*;

public class HeartView extends JPanel implements HeartBeatListener {
    public int grain;//线条的精细度（粒度）
    public int radius=50;//高度（振幅）
    public int period = 100;//x轴，每100像素表示一个周期


    HeartBeatController heartBeatController;



    @Override
    protected void paintComponent(Graphics g) {
        //保留这一行调用
        super.paintComponent(g);

        //得到当前这个控件的宽度和高度
        int width = this.getWidth();
        int height = this.getHeight();


        //蓝色设为白色
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, width, height);

        //中线
        int center = height / 2;
        g.setColor(Color.BLUE);
        g.drawLine(0, center, width, center);

        //AV曲线
        int x1 = 0;
        int y1 = 0;
        for (int i = 0; i < width; i += grain) {
            int x2 = i;
            for (int j = 0; j < Math.PI; j += grain) {
                double angle = 2 * Math.PI * x2 / period;
                int y2 = (int) (radius * Math.sin(angle));
                g.drawLine(x1, center + y1, x2, center + y2);
                x1 = x2;
                y1 = y2;
            }

        }
    }

    @Override
    public void onHeartBeat() {
        try {
            Thread.sleep(2);

        } catch (InterruptedException e) {}
    }


    public int getGrain() {
        return grain;
    }

    public void setGrain(int grain) {
        this.grain = grain;
    }
}
