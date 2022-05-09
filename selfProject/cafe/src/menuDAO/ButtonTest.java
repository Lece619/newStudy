package menuDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest extends JFrame implements ActionListener {


    public ButtonTest(){
        setTitle("buttonTest");
        setBounds(220,200,200, 200);
        JButton button = new JButton("title");
        //액션에 이름넣기
        button.setActionCommand("액션에 넣은 이름");
        //버튼에 이름넣기
        button.setName("지정한 이름");
        //button.setText("newTitle") : 버튼속 글씨와 ActionCommand이름이 newTitle로 변경
        add(button);
        button.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //일어난 이벤트의 액션커멘드 이름
        System.out.println("버튼 getActionCommand : "+e.getActionCommand());
        //일어난 이벤트의 버튼이벤트의 이름가져오기
        Object obj = e.getSource();
        JButton tempButton = (JButton) obj;
        //오브젝트로 리턴받아서 캐스팅
        System.out.println("버튼 getName : "+tempButton.getName());
    }

    public static void main(String[] args) {
        new ButtonTest();
    }
}
