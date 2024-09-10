import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SecondMenu extends JFrame{

    ImageIcon room;
    ImageIcon buttonFrame;
    ImageIcon mypage;
    ImageIcon box;
    ImageIcon study;
    ImageIcon wrongQ;
    ImageIcon quit;
    ImageIcon mainLevel1;
    ImageIcon mainLevel2;
    ImageIcon mainLevel3;
    ImageIcon mainLevel4;
    JButton myPageButton;
    JButton studyButton;
    JButton wrongButton;
    JButton quitButton;
    //    Snowflake snowflake;
    JLabel snowflakeLabel;
    static JLabel imgLabel=new JLabel();
    static Snowflake snowflake=new Snowflake();

    public SecondMenu(){
        room = new ImageIcon("images/room.png");
        buttonFrame=new ImageIcon("images/button.png");
        mypage=new ImageIcon("images/mypage.png");
        study=new ImageIcon("images/study.png");
        wrongQ=new ImageIcon("images/wrongQ.png");
        box=new ImageIcon("images/box.png");
        quit=new ImageIcon("images/quit.png");
        mainLevel1=new ImageIcon("images/main_level1.png");
        mainLevel2=new ImageIcon("images/main_level2.png");
        mainLevel3=new ImageIcon("images/main_level3.png");
        mainLevel4=new ImageIcon("images/main_level4.png");
        myPageButton=new JButton();
        studyButton=new JButton();
        wrongButton=new JButton();
        quitButton=new JButton();


        //버튼 이미지 크기 조정
//        Image img=mypage.getImage();
//        Image updateImg=img.getScaledInstance(218,46,Image.SCALE_SMOOTH);
//        ImageIcon mypage=new ImageIcon(updateImg);

        Image img2=study.getImage();
        Image updateImg2=img2.getScaledInstance(218,46,Image.SCALE_SMOOTH);
        ImageIcon study=new ImageIcon(updateImg2);

        Image img3=wrongQ.getImage();
        Image updateImg3=img3.getScaledInstance(218,46,Image.SCALE_SMOOTH);
        ImageIcon wrongQ=new ImageIcon(updateImg3);

        Image quitImg=quit.getImage();
        Image updateQuitImg=quitImg.getScaledInstance(90,55,Image.SCALE_SMOOTH);
        ImageIcon quit=new ImageIcon(updateQuitImg);

        Image mainLv1=mainLevel1.getImage();
        Image updateMainLevel1=mainLv1.getScaledInstance(275,93,Image.SCALE_SMOOTH);
        ImageIcon mainLevel1=new ImageIcon(updateMainLevel1);

        Image mainLv2=mainLevel2.getImage();
        Image updateMainLevel2=mainLv2.getScaledInstance(275,93,Image.SCALE_SMOOTH);
        ImageIcon mainLevel2=new ImageIcon(updateMainLevel2);

        Image mainLv3=mainLevel3.getImage();
        Image updateMainLevel3=mainLv3.getScaledInstance(275,93,Image.SCALE_SMOOTH);
        ImageIcon mainLevel3=new ImageIcon(updateMainLevel3);

        Image mainLv4=mainLevel4.getImage();
        Image updateMainLevel4=mainLv4.getScaledInstance(275,93,Image.SCALE_SMOOTH);
        ImageIcon mainLevel4=new ImageIcon(updateMainLevel4);


        //배경 Panel
        JPanel panel=new JPanel();
        panel.setSize(800,660);
        panel.setLayout(null);

        //이미지삽입
        snowflake.getCurrentStageIcon();
        secondPanel room=new secondPanel();
        room.setSize(800,660);
        panel.add(room);

        //마이페이지 버튼 삽입
//        myPageButton=new JButton(mypage);
//        myPageButton.setBorderPainted(false);
//        myPageButton.setContentAreaFilled(false);
//        myPageButton.setOpaque(false);
//        myPageButton.setBounds(48,556,218,46);
//        add(myPageButton);

        //공부하기 버튼 삽입
        studyButton=new JButton(study);
        studyButton.setBorderPainted(false);
        studyButton.setContentAreaFilled(false);
        studyButton.setOpaque(false);
        studyButton.setBounds(123,558,218,46);
        add(studyButton);

        //오답확인 버튼 삽입
        wrongButton=new JButton(wrongQ);
        wrongButton.setBorderPainted(false);
        wrongButton.setContentAreaFilled(false);
        wrongButton.setOpaque(false);
        wrongButton.setBounds(459,558,218,46);
        add(wrongButton);

        //quit 버튼 삽입
        quitButton=new JButton(quit);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setOpaque(false);
        quitButton.setBounds(664,25,90,55);
        add(quitButton);


        setLayout(null);
        add(panel);
        //add(bt);


        // 버튼 이벤트
        studyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // 공부하기 창 열기
                new ThirdMenu().setVisible(true);
                // 현재 창을 닫습니다.
                dispose();
            }
        });

        wrongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // 오답확인 창 열기
               new WrongMenu().setVisible(true);
               //new WrongAnswersPage1(wrongAnswers).setVisible(true);
                // 현재 창을 닫습니다.
                dispose();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    public class secondPanel extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g.drawImage(room.getImage(),0,0,800,660,null);
            g2d.drawImage(ImageActivate().getImage(),35,25,275,93,null);
            g2d.drawImage(snowflake.getCurrentStageIcon(),279,294,231,264,null);
        }
    }

    private static String MyLevel(){
        int level = snowflake.getStage();
        level+=1;
        return String.valueOf(level);
    }

    //레벨별 레벨 글씨 프린트
    public ImageIcon ImageActivate() {
        if ((snowflake.getStage()) == 0) {
            return mainLevel1;
        } else if ((snowflake.getStage()) == 1) {
            return mainLevel2;
        } else if ((snowflake.getStage()) == 2) {
            return mainLevel3;
        } else {
            return mainLevel4;
        }
    }


     public static void main(String[] args) {
         new SecondMenu();
     }

}