import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class noonsong_fail extends JFrame {
    private JLabel imageLabel;
    private JLabel textLabel;
    private String text = "다시 도전하세요!";
    private int textIndex = 0;
    private Timer imageTimer;
    private Timer textTimer;
    private int baseYPosition; // 이미지의 기본 위치(위아래)
    private int bounceHeight = 100; // 이미지가 튀는 높이
    private double angle = 0;
    private static final int TIMER_DELAY = 30; //이미지 튀어오르는 타이밍??
    private Image backgroundImage;

    public noonsong_fail() {
        // JFrame 설정
        setTitle("눈송이가 웁니다...!");
        setSize(800, 660); //전체 이미지 프레임
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        backgroundImage = new ImageIcon("images/background.png").getImage();

        JPanel panel = new noonsong_fail.CustomPanel();
        panel.setLayout(null);
        setContentPane(panel);

        String ImgIcn = "images/noonsong_cry.png"; //우는 이미지
        ImageIcon imageIcon = new ImageIcon(ImgIcn);

        Image img = imageIcon.getImage();
        Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 원하는 크기로 조정
        imageIcon = new ImageIcon(scaledImg);
        imageLabel = new JLabel(imageIcon);
        int imageWidth = imageIcon.getIconWidth();
        int imageHeight = imageIcon.getIconHeight();

        // 이미지 맨 아래 가운데로 설정
        baseYPosition = getHeight() - imageHeight;
        imageLabel.setBounds((getWidth() - imageWidth) / 2, baseYPosition, imageWidth, imageHeight);
        add(imageLabel);

        // 글자 위치
        textLabel = new JLabel("");
        textLabel.setFont(new Font("SansSerif", Font.BOLD, 34)); // 글자관련
        textLabel.setForeground(Color.BLACK);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER); // 글자 양옆 가운데
        textLabel.setBounds(0, getHeight() / 2 - 150, getWidth(), 50); // 위아래 가운데에서 좀 위
        // height에서 - 어쩌구하면 위로 +어쩌구 하면 아래로감 => 개짜증
        add(textLabel);

        // 이미지 애니메이션 타이머
        imageTimer = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 이미지를 통통 튀는 느낌으로 이동
                angle += 0.1;
                int yPosition = baseYPosition - (int)(Math.abs(Math.sin(angle)) * bounceHeight);
                imageLabel.setLocation(imageLabel.getX(), yPosition);
                repaint();
            }
        });
        imageTimer.start();

        // 텍스트 출력 타이머
        textTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textIndex < text.length()) {
                    textLabel.setText(textLabel.getText() + text.charAt(textIndex));
                    textIndex++;
                } else {
                    textTimer.stop();

                    //second메뉴 열기, 창 닫기
                    new SecondMenu().setVisible(true);
                    dispose();
                }
            }
        });
        textTimer.start();
    }

    private class CustomPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        if (imageLabel != null) {
            int imageHeight = imageLabel.getIcon().getIconHeight();
            baseYPosition = height - imageHeight;
            imageLabel.setBounds((width - imageLabel.getWidth()) / 2, baseYPosition, imageLabel.getWidth(), imageLabel.getHeight());
        }
        if (textLabel != null) {
            textLabel.setBounds(0, getHeight() / 2 - 25, getWidth(), 50);
        }
    }

     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new noonsong_fail().setVisible(true);
             }
         });
     }
}
