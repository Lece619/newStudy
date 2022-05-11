package ViewDAO;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //Image image = new ImageIcon(MainFrame.class.getResource("D:\\git\\newStudy\\selfProject\\starbucks\\src\\Img\\backgroundImg.jpg")).getImage();
    Image background = Toolkit.getDefaultToolkit().getImage("D:\\git\\newStudy\\selfProject\\starbucks\\src\\Img\\backgroundImg.jpg");

    public void startFrame() {
        setBounds(300, 100, 700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        JLabel backLabel = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(background, 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        JButton loginBtn = new JButton("로그인");
        JButton joinBtn = new JButton("회원가입");
        loginBtn.setPreferredSize(new Dimension(100,60));
        joinBtn.setPreferredSize(new Dimension(100,60));
        setLayout(new FlowLayout());
        loginBtn.setSize(100,60);
        joinBtn.setSize(100,60);
        loginBtn.setVisible(true);
        joinBtn.setVisible(true);
        add(loginBtn);
        add(joinBtn);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }

    public static void main(String[] args) {
        new MainFrame().startFrame();
    }
}
