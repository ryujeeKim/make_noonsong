import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WrongMenu extends JFrame {

    ImageIcon classroom2;
    ImageIcon level1;
    ImageIcon level2;
    ImageIcon level3;
    ImageIcon level4;
    ImageIcon home2;
    JButton homeButton;
    JButton level1Button;
    JButton level2Button;
    JButton level3Button;
    JButton level4Button;
    ImageIcon level2_unlock;
    ImageIcon level3_unlock;
    ImageIcon level4_unlock;
    WrongAnswers wrongAnswers = new WrongAnswers();
    

    public static Snowflake snowflake=new Snowflake();



    public WrongMenu(){
        classroom2=new ImageIcon("images/classroom2.png");
        level1=new ImageIcon("images/level1Button.png");
        level2=new ImageIcon("images/level2Button.png");
        level2_unlock=new ImageIcon("images/level2_unlock.png");
        level3=new ImageIcon("images/level3Button.png");
        level3_unlock=new ImageIcon("images/level3_unlock.png");
        level4=new ImageIcon("images/level4Button.png");
        level4_unlock=new ImageIcon("images/level4_unlock.png");
        home2=new ImageIcon("images/home.png");


        //배경 Panel
        JPanel panel=new JPanel();
        panel.setSize(800,660);
        panel.setLayout(null);

        //이미지삽입
        WrongMenu.wrongPanel classroom=new WrongMenu.wrongPanel();
        classroom.setSize(800,660);
        panel.add(classroom);

        //버튼 이미지 크기 조정
        Image img2=level1.getImage();
        Image updateImg2=img2.getScaledInstance(203,46,Image.SCALE_SMOOTH);
        ImageIcon level1=new ImageIcon(updateImg2);

        Image img3=level2.getImage();
        Image updateImg3=img3.getScaledInstance(203,46,Image.SCALE_SMOOTH);
        ImageIcon level2=new ImageIcon(updateImg3);

        Image img4=level3.getImage();
        Image updateImg4=img4.getScaledInstance(203,46,Image.SCALE_SMOOTH);
        ImageIcon level3=new ImageIcon(updateImg4);

        Image img5=level4.getImage();
        Image updateImg5=img5.getScaledInstance(203,46,Image.SCALE_SMOOTH);
        ImageIcon level4=new ImageIcon(updateImg5);

        Image img_unlock2=level2_unlock.getImage();
        Image updateImg6=img5.getScaledInstance(203,46,Image.SCALE_SMOOTH);
        ImageIcon level2_unlock=new ImageIcon(updateImg6);

        Image img_unlock3=level3_unlock.getImage();
        Image updateImg7=img5.getScaledInstance(203,46,Image.SCALE_SMOOTH);
        ImageIcon level3_unlock=new ImageIcon(updateImg7);

        Image img_unlock4=level4_unlock.getImage();
        Image updateImg8=img5.getScaledInstance(203,46,Image.SCALE_SMOOTH);
        ImageIcon level4_unlock=new ImageIcon(updateImg8);


        //home 버튼 크기조절
        Image homeImage=home2.getImage();
        Image updateHomeImage2=homeImage.getScaledInstance(90,55,Image.SCALE_SMOOTH);
        ImageIcon home2=new ImageIcon(updateHomeImage2);

        //home 버튼 삽입
        homeButton=new JButton(home2);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setOpaque(false);
        homeButton.setBounds(26,23,90,55);
        add(homeButton);


        //level 버튼 삽입
        level1Button=new JButton(level1);
        level1Button.setBorderPainted(false);
        level1Button.setContentAreaFilled(false);
        level1Button.setOpaque(false);
        level1Button.setBounds(161,232,203,46);
        add(level1Button);

        level2Button=new JButton(level2);
        level2Button.setBorderPainted(false);
        level2Button.setContentAreaFilled(false);
        level2Button.setOpaque(false);
        level2Button.setBounds(161,327,203,46);
        add(level2Button);

        level3Button=new JButton(level3);
        level3Button.setBorderPainted(false);
        level3Button.setContentAreaFilled(false);
        level3Button.setOpaque(false);
        level3Button.setBounds(423,232,203,46);
        add(level3Button);

        level4Button=new JButton(level4);
        level4Button.setBorderPainted(false);
        level4Button.setContentAreaFilled(false);
        level4Button.setOpaque(false);
        level4Button.setBounds(423,327,203,46);
        add(level4Button);

//        ActionListener listener=new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        }

        //버튼 이벤트
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // SecondMenu 창 열기
                new SecondMenu().setVisible(true);
                // 현재 창을 닫습니다.
                dispose();
            }
        });




    //버튼활성화 
    level1Button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        new WrongAnswersPage1().setVisible(true);
        }

    });

    level2Button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           new WrongAnswersPage2().setVisible(true);
        }

    });
    level3Button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           //new WrongAnswersPage3().setVisible(true);
        }       
    });

    level4Button.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           new WrongAnswersPage4().setVisible(true);
        }

    });



        setLayout(null);
        add(panel);
        //add(bt);

        // JFrame 기본 설정
        setSize(800, 660);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true); // 프레임을 화면에 보이게 설정

        //레벨별 버튼 활성화
        ButtonActivate();





    }

    public class wrongPanel extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g.drawImage(classroom2.getImage(),0,0,800,660,null);


        }

    }





    //레벨별 버튼 활성화시키는 함수
    public void ButtonActivate() {
        if ((snowflake.getStage()) == 0) {
            level1Button.setVisible(true);
            level2Button.setEnabled(false);
            level3Button.setEnabled(false);
            level4Button.setEnabled(false);
            
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
        new WrongMenu();
    }
}




