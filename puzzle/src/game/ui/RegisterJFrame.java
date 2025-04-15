package game.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    public RegisterJFrame(){
        // 在创建对象的时候进行初始化
        this.setSize(488,450);
        this.setTitle("注册");
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        //关掉界面后停止代码运行
        this.setDefaultCloseOperation(3);
        //显示窗口
        this.setVisible(true);
    }
}
