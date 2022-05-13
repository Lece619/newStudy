import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class JFrameGridTest extends JFrame {

    public Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public int screenX = dimension.width;
    public int screenY = dimension.height;

    public void startFrame(){
        setTitle("GridTest");
        setBounds(screenX-400,screenY-600,300,500);
        setLayout(new GridLayout(3,5));
        setBackground(Color.BLUE);
        getContentPane().setBackground(Color.BLUE);

        //테스트 패널 생성
        JPanel testPanel1 = new JPanel();
        testPanel1.setBackground(Color.RED);
        //
        JPanel testPanel2 = new JPanel();
        testPanel2.setBackground(Color.GREEN);
        testPanel2.setBorder(new LineBorder(Color.BLACK,2));

        //
        JPanel testPanel3 = new JPanel();
        testPanel3.setBackground(Color.YELLOW);
        testPanel3.setBorder(new LineBorder(Color.BLACK,2));

        JPanel testPanel4 = new JPanel();
        testPanel4.setBackground(Color.GRAY);
        testPanel4.setBorder(new LineBorder(Color.MAGENTA,2));


        JPanel testPanel5 = new JPanel();
        testPanel5.setBackground(Color.ORANGE);
        testPanel5.setBorder(new LineBorder(Color.BLACK,2));


        JPanel testPanel6 = new JPanel();
        testPanel6.setBackground(Color.RED);


        JPanel testPanel7 = new JPanel();
        testPanel7.setBackground(Color.magenta);
        //실험완료  JFrame 에  add 하게 되면 내장 JPanel에 add 된다
        add(testPanel1);
        add(testPanel2);
        add(testPanel3);
        add(testPanel4);
        add(testPanel5);
        add(testPanel6);
        add(testPanel7);
        /*
        * ====================실행시 덮어진다 .
        *
        * */

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JFrameGridTest().startFrame();
    }
}
