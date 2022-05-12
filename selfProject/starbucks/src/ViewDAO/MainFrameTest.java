package ViewDAO;

import javax.swing.*;
import java.awt.*;

//망한 메인프레임
public class MainFrameTest extends JFrame {
    Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
    int monitorX = monitorSize.width;
    int monitorY = monitorSize.height;
    Image background = Toolkit.getDefaultToolkit().getImage("selfProject\\starbucks\\src\\Img\\backgroundImg.jpg");

    public MainFrameTest() {

        //배경이미지 설정
        //background = Toolkit.getDefaultToolkit().getImage("./Img/backgroundImg.jpg");
        background=background.getScaledInstance(monitorY/3*2,monitorY/4*3,Image.SCALE_SMOOTH);

        //메인뷰 설정
        setTitle("starbucks에 어서오세요");
        setBounds(monitorX/4,50,monitorY/3*2,monitorY/4*3);
        //Container mainPanel=this.getContentPane();
        setLayout(new GridLayout(3,1));
        //remove(getContentPane());
        JLabel backLabel = new JLabel(new ImageIcon(background));
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(backLabel);
        //add(backLabel);
        JButton loginBtn = new JButton("로그인");
        JButton joinBtn = new JButton("회원가입");

        loginBtn.setPreferredSize(new Dimension(getWidth()/5,getWidth()/7));
        joinBtn.setPreferredSize(new Dimension(getWidth()/5,getWidth()/7));
        getContentPane().add(loginBtn);
        getContentPane().add(joinBtn);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        /*mainPanel.setBackground(Color.RED);
        BackPanel backgroundPanel = new BackPanel();
        backgroundPanel.setVisible(true);
        backgroundPanel.setBorder(new LineBorder(Color.BLACK,3));
        mainPanel.add(backgroundPanel);*/
    }
   /* //이너클래스 선언
    class BackPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background,this.getX(),this.getY(),null);
        }

        @Override
        public void paint(Graphics g) {
            g.drawImage(background,this.getX(),this.getY(),null);
        }
    }*/

    /*@Override
    public void paint(Graphics g) {
        //super.paint(g);
        System.out.println("in");
        g.drawImage(background,0,0,null);
        g.fillOval(0,0,30,30);
    }*/

    public static void main(String[] args) {
        new MainFrameTest();
    }
}
