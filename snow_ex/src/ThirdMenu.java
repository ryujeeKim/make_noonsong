import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ThirdMenu extends JFrame {

    ImageIcon classroom;
    ImageIcon level1;
    ImageIcon level2;
    ImageIcon level3;
    ImageIcon level4;
    ImageIcon home;
    ImageIcon lock;
    ImageIcon unlock;
    JButton level1Button;
    JButton level2Button;
    JButton level3Button;
    JButton level4Button;
    JButton homeButton;
    WrongAnswers wrongAnswers;

    public static Snowflake snowflake = new Snowflake();
    



    public ThirdMenu(){
        classroom=new ImageIcon("images/classroom.png");
        level1=new ImageIcon("images/level1Button.png");
        level2=new ImageIcon("images/level2Button.png");
        level3=new ImageIcon("images/level3Button.png");
        level4=new ImageIcon("images/level4Button.png");
        home=new ImageIcon("images/home.png");

        //배경 Panel
        JPanel panel=new JPanel();
        panel.setSize(800,660);
        panel.setLayout(null);

        //이미지삽입
        ThirdMenu.thirdPanel classroom=new ThirdMenu.thirdPanel();
        classroom.setSize(800,660);
        panel.add(classroom);

        //버튼 이미지 크기 조정
        Image img2=level1.getImage();
        Image updateImg2=img2.getScaledInstance(294,69,Image.SCALE_SMOOTH);
        ImageIcon level1=new ImageIcon(updateImg2);

        Image img3=level2.getImage();
        Image updateImg3=img3.getScaledInstance(294,69,Image.SCALE_SMOOTH);
        ImageIcon level2=new ImageIcon(updateImg3);

        Image img4=level3.getImage();
        Image updateImg4=img4.getScaledInstance(294,69,Image.SCALE_SMOOTH);
        ImageIcon level3=new ImageIcon(updateImg4);

        Image img5=level4.getImage();
        Image updateImg5=img5.getScaledInstance(294,69,Image.SCALE_SMOOTH);
        ImageIcon level4=new ImageIcon(updateImg5);

        //home 버튼 크기조절
        Image homeImage=home.getImage();
        Image updateHomeImage=homeImage.getScaledInstance(90,55,Image.SCALE_SMOOTH);
        ImageIcon home=new ImageIcon(updateHomeImage);

        //level 버튼 삽입
        level1Button=new JButton(level1);
        level1Button.setBorderPainted(false);
        level1Button.setContentAreaFilled(false);
        level1Button.setOpaque(false);
        level1Button.setBounds(253,209,294,69);
        add(level1Button);

        level2Button=new JButton(level2);
        level2Button.setBorderPainted(false);
        level2Button.setContentAreaFilled(false);
        level2Button.setOpaque(false);
        level2Button.setBounds(253,298,294,69);
        add(level2Button);

        level3Button=new JButton(level3);
        level3Button.setBorderPainted(false);
        level3Button.setContentAreaFilled(false);
        level3Button.setOpaque(false);
        level3Button.setBounds(253,388,294,69);
        add(level3Button);

        level4Button=new JButton(level4);
        level4Button.setBorderPainted(false);
        level4Button.setContentAreaFilled(false);
        level4Button.setOpaque(false);
        level4Button.setBounds(253,477,294,69);
        add(level4Button);

        //home 버튼 삽입
        homeButton=new JButton(home);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setOpaque(false);
        homeButton.setBounds(26,23,90,55);
        add(homeButton);


        ButtonActivate();
        
        
        setLayout(null);
        add(panel);
        //add(bt);

        // 버튼 이벤트
        level1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // 1단계 퀴즈 창 열기
                new QuizN1().setVisible(true);
                // 현재 창을 닫습니다.
                dispose();
            }
        });


        level2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // 1단계 퀴즈 창 열기
                new QuizN2().setVisible(true);
                // 현재 창을 닫습니다.
                dispose();
            }
        });



        level3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // 3단계 퀴즈 창 열기
                new QuizN3().setVisible(true);
                // 현재 창을 닫습니다.
                dispose();
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // SecondMenu 창 열기
                new SecondMenu().setVisible(true);
                // 현재 창을 닫습니다.
                dispose();
            }
        });


        level4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // 1단계 퀴즈 창 열기
                new QuizN4().setVisible(true);
                // 현재 창을 닫습니다.
                dispose();
            }
        });


        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // SecondMenu 창 열기
                new SecondMenu().setVisible(true);
                // 현재 창을 닫습니다.
                dispose();
            }
        });

        // JFrame 기본 설정
        setSize(800, 660);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true); // 프레임을 화면에 보이게 설정

    }

    public class thirdPanel extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g.drawImage(classroom.getImage(),0,0,800,660,null);

        }
    }

//레벨업 버튼 활성화 시키는 함수

public void ButtonActivate() {
    if ((snowflake.getStage()) == 0) {
        level1Button.setVisible(true);
        level2Button.setVisible(false);
        level3Button.setVisible(false);
        level4Button.setVisible(false);
    } else if ((snowflake.getStage()) == 1) {
        level1Button.setEnabled(true);
        level2Button.setEnabled(true);
        level3Button.setEnabled(false);
        level4Button.setEnabled(false);
    } else if ((snowflake.getStage()) == 2) {
        level1Button.setEnabled(true);
        level2Button.setEnabled(true);
        level3Button.setEnabled(true);
        level4Button.setEnabled(false);
    } else {
        level1Button.setEnabled(true);
        level2Button.setEnabled(true);
        level3Button.setEnabled(true);
        level4Button.setEnabled(true);
    }
}

    public static void main(String[] args) {
         new ThirdMenu();
     }
}
