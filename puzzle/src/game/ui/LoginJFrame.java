package game.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    // 登陆界面
    public LoginJFrame(){
        // 初始化界面
        InitJFrame();

        // 初始化视图
        Initview();
    }
    public void InitJFrame(){
        // 在创建对象的时候进行初始化
        this.setSize(488,430);
        this.setTitle("登录");
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        //关掉界面后停止代码运行
        this.setDefaultCloseOperation(3);
        // 取消窗口的默认布局管理器
        this.setLayout(null);
        //显示窗口
        this.setVisible(true);
    }
    public void Initview(){
        // 加载入用户名的图片
        ImageIcon usernameimage = new ImageIcon("photo/image/login/用户名.png");
        JLabel usernameText = new JLabel(usernameimage);
        usernameText.setBounds(116, 135,47,17);
        this.getContentPane().add(usernameText);

        // 加载入密码的图片
        ImageIcon passwordimage = new ImageIcon("photo/image/login/密码.png");
        JLabel passwordText = new JLabel(passwordimage);
        passwordText.setBounds(130,195,32,16);
        this.getContentPane().add(passwordText);

        // 加载用户名的输入框
        JTextField username = new JTextField();
        username.setBounds(195,134,200,30);
        this.getContentPane().add(username);

        // 加载密码的输入框
        JTextField password = new JTextField();
        password.setBounds(195,195,200,30);
        this.getContentPane().add(password);

        // 加载背景图片
        ImageIcon bg = new ImageIcon("photo/image/login/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }
}
