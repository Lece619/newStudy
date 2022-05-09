package calMaker;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CalendarMaker extends JFrame implements ActionListener {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    JPanel topPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    GridLayout calLayout = new GridLayout(0, 7);
    String[] month = new String[12];
    Integer[] years = new Integer[24];
    JLabel dayOfWeek[] = new JLabel[7];
    String dayOfWeekName[] = {"일", "월", "화", "수", "목", "금", "토"};

    JButton searchBtn = new JButton("선택");
    JComboBox<Integer> selectYear;
    JComboBox<String> selectMonth;
    JLabel topLabel = new JLabel("년 월을 선택하세요");
    JButton days[];

    //Calendar
    Calendar calendar = Calendar.getInstance();

    public CalendarMaker() {

        int screenX = dimension.width;
        int screenY = dimension.height;

        setTitle("Calendar");
        setBounds(screenX / 10, screenY / 10, screenX / 2, screenY / 3 * 2);
        setLayout(new BorderLayout());

        topPanel.setBackground(Color.BLUE);
        bottomPanel.setBackground(Color.RED);
        middlePanel.setBackground(Color.YELLOW);
        topPanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 7));
        middlePanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 7));
        bottomPanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 7 * 5));

        topPanel.setBorder(new LineBorder(Color.PINK));
        middlePanel.setBorder(new LineBorder(Color.BLACK));
        bottomPanel.setBorder(new LineBorder(Color.PINK));

        middlePanel.setLayout(calLayout);
        bottomPanel.setLayout(calLayout);

        //요일선택
        for (int i = 0; i < years.length; i++) {
            years[i] = i + 2000;
        }
        for (int i = 0; i < month.length; i++) {
            month[i] = (i + 1) + "월";
        }
        selectYear = new JComboBox<>(years);
        selectMonth = new JComboBox<>(month);
        selectYear.setSelectedIndex(22);
        selectMonth.setActionCommand("월");
        selectMonth.addActionListener(this);
        searchBtn.addActionListener(this);
        //topPanel.setLayout();

        topPanel.add(topLabel);
        topPanel.add(selectYear);
        topPanel.add(selectMonth);
        topPanel.add(searchBtn);
        //요일 라벨
        for (int i = 0; i < dayOfWeekName.length; i++) {
            dayOfWeek[i] = new JLabel(dayOfWeekName[i], JLabel.CENTER);
            dayOfWeek[i].setBorder(new LineBorder(Color.BLACK,1));
            middlePanel.add(dayOfWeek[i]);
        }

        //달력 버튼
        /*days = new JButton[31];
        for (int i = 0; i < days.length; i++) {
            days[i] = new JButton("" + (i + 1));
            days[i].setFont(new Font("고딕", Font.BOLD, 20));
            bottomPanel.add(days[i]);
        }*/


        add(topPanel, BorderLayout.NORTH);
        add(middlePanel);
        add(bottomPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void make() {
        System.out.println(calendar.getTime());
        String year = ""+selectYear.getSelectedItem();
        calendar.set(Integer.parseInt(year),selectMonth.getSelectedIndex(),1);
        int startday=calendar.get(Calendar.DAY_OF_WEEK)-1;
        int lastDay=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        bottomPanel.removeAll();
        remove(bottomPanel);
        days=new JButton[startday+lastDay];
        for (int i = 0; i < days.length; i++) {
            if(i<startday){
                days[i] = new JButton("");
                days[i].setEnabled(false);
            }else {
                days[i] = new JButton(""+(i+1-startday));
            }
            days[i].setVisible(true);
            bottomPanel.add(days[i]);
        }
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new CalendarMaker();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //년 월 을 선택
        if(e.getActionCommand().equals("선택")){
            make();
            /*String year = ""+selectYear.getSelectedItem();
            calendar.set(Integer.parseInt(year),selectMonth.getSelectedIndex(),1);
            System.out.println(calendar.getTime());
            int startday=calendar.get(Calendar.DAY_OF_WEEK)-1;
            int lastDay=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            bottomPanel.removeAll();
            days=new JButton[startday+lastDay];
            for (int i = 0; i < days.length; i++) {
                if(i<startday){
                    days[i] = new JButton("");
                    days[i].setEnabled(false);
                }else {
                    days[i] = new JButton(""+(i+1-startday));
                }
                bottomPanel.add(days[i]);
            }*/
        }
    }
}
