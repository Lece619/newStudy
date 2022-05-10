package menuDAO;

import javax.swing.*;
import java.awt.*;

public class MainVeiw extends JFrame {

    Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
    int monitorX = monitor.width;
    int monitorY = monitor.height;

    public MainVeiw(){
        setTitle("Jino Cafe");

        setBounds(100,100, monitorX/2, monitorY/5*4);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        Button b1 = new Button("b1");
        //b1.setBounds(new Rectangle(0,0,getWidth()/4,getHeight()/4));
        b1.setPreferredSize(new Dimension(getWidth()/4,getHeight()/4));
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        b2.setPreferredSize(new Dimension(getWidth()/4,getHeight()/4));

        Button[] buttons = new Button[100];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i]= new Button(i+"");
            buttons[i].setPreferredSize(new Dimension(getWidth()/4,getHeight()/4));
        }
        GridLayout gridPanel = new GridLayout(2,2);
        GridLayout grid = new GridLayout( 4,2);
        GridBagLayout gbLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        //setLayout(gridPanel);
        setLayout(gbLayout);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx=1.0;
        gbc.weighty=3.0;

        jp1.setBackground(Color.BLUE);
        //jp1.setLayout(grid);
        //jp1.add(b1);
//        for (int i = 0; i < 4; i++) {
//            jp1.add(buttons[i]);
//        }
        jp2.setBackground(Color.RED);
        jp3.setBackground(Color.GREEN);
        //jp3.add(b3);
        //jp2.add(b2);

        //add(jp);
        gbc.gridx=0;
        gbc.gridy=0;
        //gbc.gridwidth=1;
        //gbc.gridheight=1;
        add(jp1,gbc);


        gbc.weighty=1.0;
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        add(jp2,gbc);
        add(jp3);


        for (int i = 0; i < 10; i++) {
            jp4.add(buttons[i+10]);
        }
        jp4.setLayout(grid);
        JScrollPane jp =new JScrollPane(jp4);
        jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       // jp.setVerticalScrollBarPolicy(JScrollPane.WHEN_FOCUSED);
        add(jp4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MainVeiw();
    }
}
