package game.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // 使用一个二维数组保存打乱后的数据
    int[][] data = new int[4][4];
    // 记录空白方块在数组中的位置
    int x;
    int y;
    // 用于统计步数
    int step;
    String path = "photo/image/animal/animal2/";
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    // 游戏主界面
    public GameJFrame() {
        // 初始化界面
        initJFrame();
        // 初始化菜单
        initJMenuBar();
        //初始化数据
        initData();
        // 初始化图片
        initImage();


        //显示窗口
        this.setVisible(true);
    }

    private void initData() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        // 打乱数据
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (arr[count] == 0) {
                    x = i;
                    y = j;
                }
                data[i][j] = arr[count];
                count++;
            }
        }

    }

    // 初始化图片
    private void initImage() {
        // 清空原本加载的界面
        this.getContentPane().removeAll();
        if (victory()) {
            ImageIcon v = new ImageIcon("photo/image/win.png");
            // 创建JLabel来管理icon对象
            JLabel winJLabel = new JLabel(v);
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }

        // 统计步数
        JLabel stepCount = new JLabel("步数" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = data[i][j];
                // 创建一个ImageIcon对象
                ImageIcon icon = new ImageIcon(path + number + ".jpg");
                // 创建JLabel来管理icon对象
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框，0凸起来，1凹下去
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                // 将图片放到界面当中，默认放到最中央(要先获取到隐藏的容器)
                this.getContentPane().add(jLabel);
            }
        }
        // 添加背景图片，后加载的图片在下面
        ImageIcon bg = new ImageIcon("photo/image/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    private void initJFrame() {
        // 设置宽高
        this.setSize(603, 680);
        this.setTitle("拼图小游戏");
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        //关掉界面后停止代码运行
        this.setDefaultCloseOperation(3);
        // 取消窗口的默认布局管理器
        this.setLayout(null);
        // 为整个窗体添加上键盘监听事件
        this.addKeyListener(this);
    }

    private void initJMenuBar() {
        // 创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        // 创建两个菜单选项对象，功能界面和关于我们
        JMenu functionJMenu = new JMenu("功能界面");
        JMenu aboutusJMenu = new JMenu("关于我们");
        // 创建条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reloginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");
        // 给条目绑定监听事件
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        // 将对应条目添加到菜单对象当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);

        aboutusJMenu.add(accountItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutusJMenu);
        // 给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            ImageIcon icon = new ImageIcon(path + "all.jpg");
            JLabel all = new JLabel(icon);
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            // 添加背景图片，后加载的图片在下面
            ImageIcon bg = new ImageIcon("photo/image/background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 37) {
            System.out.println("左移");
            // 边界判定
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            // 每移动一次，步数+1
            step++;
            initImage();
        } else if (code == 38) {
            System.out.println("上移");
            // 边界判定
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            initImage();
        } else if (code == 39) {
            System.out.println("右移");
            // 边界判定
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            initImage();
        } else if (code == 40) {
            System.out.println("下移");
            // 边界判定
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0},
            };
            initImage();
        }
    }

    //
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
