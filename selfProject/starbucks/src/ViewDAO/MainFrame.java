package ViewDAO;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //Image image = new ImageIcon(MainFrame.class.getResource("Img/backgroundImg.jpg")).getImage();
    public void startFrame(){
        setBounds(100,100,100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image,0,0,null);
    }

    public static void main(String[] args) {
        new MainFrame().startFrame();
    }
}
