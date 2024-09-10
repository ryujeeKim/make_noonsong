import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartMenu extends JFrame {
    ImageIcon backGround;
    ImageIcon startButton;
    JButton bt;
    JPanel buttonPanel;


    public StartMenu() {
        backGround = new ImageIcon("images/back.png");
        startButton=new ImageIcon("images/startbutton.png");
        buttonPanel=new JPanel();


        //시작버튼 이미지 크기 조정
        Image img=startButton.getImage();
        Image updateImg=img.getScaledInstance(249,55,Image.SCALE_SMOOTH);
        ImageIcon startButton2=new ImageIcon(updateImg);




            //배경 Panel
            JPanel panel=new JPanel();
            panel.setSize(800,660);
            panel.setLayout(null);

            //이미지삽입
            myPanel panel2=new myPanel();
            panel2.setSize(800,660);
            panel.add(panel2);

            //버튼 삽입
            bt=new JButton(startButton2);
            bt.setBorderPainted(false);
            bt.setContentAreaFilled(false);
            bt.setOpaque(false);
            bt.setBounds(280,400,249,55);
            add(bt);


            setLayout(null);
            add(panel);
            //add(bt);

            bt.addActionListener(new ActionListener() {
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true); // 프레임을 화면에 보이게 설정
    }

    public class myPanel extends JPanel{
        public void paint(Graphics g){
            g.drawImage(backGround.getImage(),0,0,800,660,null);
        }
    }




    public static void main(String[] args) {
        new StartMenu();
    }
}
