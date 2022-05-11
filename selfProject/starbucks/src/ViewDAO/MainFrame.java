package ViewDAO;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //Image image = new ImageIcon(MainFrame.class.getResource("D:\\git\\newStudy\\selfProject\\starbucks\\src\\Img\\backgroundImg.jpg")).getImage();
    Image background = Toolkit.getDefaultToolkit().getImage("D:\\git\\newStudy\\selfProject\\starbucks\\src\\Img\\backgroundImg.jpg");

    public void startFrame(){
        setBounds(100,100,100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        JButton loginBtn = new JButton("로그인");
        JButton joinBtn = new JButton("회원가입");
        loginBtn.setVisible(true);

        add(loginBtn);
        add(joinBtn);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background,0,0,null);
    }

    public static void main(String[] args) {
        new MainFrame().startFrame();
    }
}
