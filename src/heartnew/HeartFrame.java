package heartnew;

import demo.MyFrame;
import demo.SettingDialog;
import demo.SinCurve;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HeartFrame extends JFrame{
    HeartCurve canvas = new HeartCurve();

    HeartFrame.ContextMenuListener menuListener = new HeartFrame.ContextMenuListener();

    public HeartFrame(String title){
        super(title);

        this.setContentPane(canvas);
        onSettings();

    }

    //内部类的实现,自定义了一个监听器
    private class ContextMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            //从事件中取出命令
            String cmd = e.getActionCommand();
            //不同的菜单项 ，对应不同命令码

            if(cmd.equals("settings")){
                onSettings();
            }

        }
    }


    private void onSettings()
    {
        HeartFunction dlg = new HeartFunction(this);
        dlg.periodSlider.setValue( canvas.period);
        dlg.radiusSlider.setValue( canvas.radius);

        if( dlg.exec() )
        {
            // 读取对话框的值，设到 曲线中
            canvas.radius = (Integer) dlg.radiusSlider.getValue();
            canvas.period = (Integer) dlg.periodSlider.getValue();
            canvas.repaint(); // 更新曲线的绘制
        }

    }
}
