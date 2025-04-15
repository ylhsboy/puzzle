package game.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    // 登陆界面
    public LoginJFrame(){
        // 在创建对象的时候进行初始化
        this.setSize(488,430);
        this.setTitle("登录");
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        //关掉界面后停止代码运行
        this.setDefaultCloseOperation(3);
        //显示窗口
        this.setVisible(true);
    }
}
