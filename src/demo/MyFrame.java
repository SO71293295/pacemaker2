package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {
    SinCurve canvas = new SinCurve();

    ContextMenuListener  menuListener = new  ContextMenuListener();

    public MyFrame(String title){
        super(title);

        this.setContentPane(canvas);

        //当点击自定义控件的时候，执行showmenu方法
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3){
                    showMenu(e);
                }
            }
        });

        //满屏占满
        //super(title);
        //SinCurve c = new SinCurve();
        //this.setContentPane(root);
        //c.setPreferredSize(new Dimension(200,300));
    }

    //内部类的实现,自定义了一个监听器
    private class ContextMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //从事件中取出命令
            String cmd = e.getActionCommand();
            //不同的菜单项 ，对应不同命令码

            if(cmd.equals("settings")){
                System.out.println("menu:setting");
                onSettings();
            }

        }
    }

    private void showMenu(MouseEvent e){
        JPopupMenu menu = new JPopupMenu();

        JMenuItem item1 = new JMenuItem("参数设置");
        item1.addActionListener(menuListener);
        item1.setActionCommand("settings");
        menu.add(item1);

        menu.show(e.getComponent(),e.getX(),e.getY());
    }

    private void onSettings()
    {
        SettingDialog dlg = new SettingDialog(this);
        dlg.grainField.setValue( canvas.grain);
        dlg.radiusField.setValue( canvas.radius);
        dlg.periodField.setValue( canvas.period);

        if( dlg.exec() )
        {
            // 读取对话框的值，设到 曲线中
            canvas.grain = (Integer) dlg.grainField.getValue();
            canvas.radius = (Integer) dlg.radiusField.getValue();
            canvas.period = (Integer) dlg.periodField.getValue();
            canvas.repaint(); // 更新曲线的绘制
        }
    }
}
