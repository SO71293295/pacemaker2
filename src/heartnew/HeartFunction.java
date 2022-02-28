package heartnew;

import af.swing.LayoutBox;
import af.swing.layout.HLayout;
import af.swing.layout.VLayout;
import demo.SettingDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HeartFunction extends JDialog {
    public JSlider periodSlider = new JSlider(50, 150, 100);
    public JSlider radiusSlider = new JSlider(20, 80, 40);
    JButton okButton = new JButton("确定");

    private boolean accepted = false;
    public HeartFunction(Window owner){
        //调用父类构造方法，进行初始化
        super(owner);

        //JPanel root = new JPanel();
        //this.setContentPane(root);
        //root.setLayout(new BorderLayout());

        LayoutBox root = new LayoutBox().layout(new VLayout(10));
        root.padding(15);
        this.setContentPane(root);
        //this.setContentPane(root);

        if(true) {
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            root.add(box, "30px");
            box.add(new JLabel("周期"), "50px");
            box.add(this.periodSlider, "1w");
        }

        if(true) {
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            root.add(box, "30px");
            box.add(new JLabel("频率"), "50px");
            box.add(this.radiusSlider, "1w");
        }

        if(true){
            LayoutBox box = new LayoutBox().layout(new HLayout(4));
            root.add(box, "50px");
            box.padding(10, 0, 5, 0);

            box.add(new JLabel(), "1w"); // 左边放一个空的JLabel, 占位
            box.add( okButton);
            //JPanel panel =new JPanel();
            //root.add(panel,BorderLayout.SOUTH);

            //panel.add(okButton);
            //panel.add(cancelButton);
        }

        //点"确定"按钮时
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accepted = true;
                setVisible(false);//关闭对话框
            }
        });

    }
    public boolean exec(){
        this.setName("参数设置");
        this.setModal(true);//模态的，即阻塞模式
        this.setSize(350, 250);

        centerInOwner();

        //显示对话框，并阻塞等待
        this.setVisible(true);//显示对话框，并阻塞

        return accepted;
    }

    private void centerInOwner(){
        // 获取原窗口的位置
        Rectangle ownerRect = this.getBounds();

        // 显示在原窗口的中央
        int width = this.getWidth();
        int height = this.getHeight();
        int x = ownerRect.x + (ownerRect.width - width)/2;
        int y = ownerRect.y + (ownerRect.height - height)/2;
        this.setBounds(x,y, width, height);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600,400);
        frame.setVisible(true);

        HeartFunction dia = new HeartFunction(frame);
        dia.exec();
    }

}
