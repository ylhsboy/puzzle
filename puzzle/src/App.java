import game.ui.GameJFrame;
import game.ui.LoginJFrame;

public class App {
    public static void main(String[] args) {
        // 程序的启动入口
        // 想打开谁的界面，只需要创建对象就可以了
        new LoginJFrame();
        new GameJFrame();
//        new RegisterJFrame();

    }
}