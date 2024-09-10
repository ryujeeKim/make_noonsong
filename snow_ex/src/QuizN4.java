import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class QuizN4 extends JFrame {
    private QuizCorrect quizCorrect;
    private QuizFactory quizFactory;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton prevButton;
    private JButton nextButton;
    private Image backgroundImage;
    private Snowflake snowflake;

    static int QuizPage;

    public QuizN4() {

        //퀴즈 페이지 처음 0으로 초기화
        QuizPage = 0;

        quizFactory = new QuizFactory();
        quizCorrect=new QuizCorrect(4);
        snowflake= new Snowflake();

        // JFrame 설정
        setNewTitle();
        //setTitle("단답형"+QuizPage+1+"번 문제");
        setSize(800, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        backgroundImage = new ImageIcon("images/quiz_back.png").getImage();

        JPanel panel = new CustomPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // 문제 부분
        questionLabel = new JLabel("단답형"+QuizPage+1+"번 문제");

        quizFactory.prepareQuiz(4);
        loadNewQuiz();

        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setBounds(0, getHeight() / 3 - 50, getWidth(), 50);
        add(questionLabel);

        // 단답형 입력 부분
        answerField = new JTextField();
        answerField.setBounds(getWidth() / 2 - 100, getHeight() / 3 + 20, 200, 30);
        add(answerField);

        // 이전 문제 버튼 (이미지 버튼)
        //ImageIcon prevIcon = new ImageIcon(getClass().getResource("/backbutton.png"));
        ImageIcon prevIcon = new ImageIcon("images/backbutton.png");
        Image img = prevIcon.getImage();
        Image newImg = img.getScaledInstance(120, 40, Image.SCALE_SMOOTH); // 원하는 크기로 이미지 크기 조정
        prevButton = new JButton(new ImageIcon(newImg));

        prevButton.setBounds(getWidth() / 4 - 80, getHeight() - 150, 120, 40);
        add(prevButton);

        // 다음 문제 버튼
        //ImageIcon nextIcon = new ImageIcon(getClass().getResource("/nextbutton.png"));
        ImageIcon nextIcon = new ImageIcon("images/nextbutton.png");
        Image img2 = nextIcon.getImage();
        Image newImg2 = img2.getScaledInstance(120, 40, Image.SCALE_SMOOTH); // 원하는 크기로 이미지 크기 조정
        nextButton = new JButton(new ImageIcon(newImg2));

        nextButton.setBounds(getWidth() * 3 / 4 - 80, getHeight() - 150, 120, 40);
        add(nextButton);

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 첫번째 문제는 이전으로 가면 메인으로 가게 했음
                if(QuizPage==0){
                    new ThirdMenu().setVisible(true);
                    System.out.println("메인 화면으로 이동");
                    dispose();
                }
                else{
                    //이전 문제 로드
                    //System.out.println("이전 문제로 이동");
                    QuizPage--;
                    loadNewQuiz();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText();
                quizCorrect.checkAnswer(QuizPage, userAnswer);
                if(QuizPage==4){
                    //다섯번째 문제&&단계 모두 성공시 알 성장 페이지로
                    if (quizCorrect.isAllCorrect()){
                        //stage가 3일때만 진화
                        if(snowflake.getStage()==3){
                            new noonsong_growth().setVisible(true);
                            dispose();
                            snowflake.evolve();
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "이미 클리어 한 단계입니다.");
                            new SecondMenu().setVisible(true);
                            dispose();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "모든 문제를 맞추어야 다음 단계로 넘어갈 수 있습니다.");
                        new noonsong_fail().setVisible(true);
                        dispose();
                    }
                }
                else{
                    // 다음 문제 로드
                    QuizPage++;
                    answerField.setText(""); //답란 초기화
                    loadNewQuiz();           
                }
            }
        });
    }

    private Quiz currentQuiz;

    private void loadNewQuiz() {
        setNewTitle();
        // 문제 로드
        currentQuiz = quizFactory.getRandomQuiz(4, QuizPage);
        //System.out.println(currentQuiz.getQuestion());
        questionLabel.setText(currentQuiz.getQuestion());
        
    }

    private void setNewTitle() {
        setTitle("단답형 "+(QuizPage+1)+"번 문제");
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
        if (questionLabel != null) {
            questionLabel.setBounds(0, height / 3 - 50, width, 50);
        }
        if (answerField != null) {
            answerField.setBounds(width / 2 - 100, height / 3 + 20, 200, 30);
        }
        if (prevButton != null) {
            prevButton.setBounds(width / 4 - 60, height - 130, 120, 40);
        }
        if (nextButton != null) {
            nextButton.setBounds(width * 3 / 4 - 60, height - 130, 120, 40);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizN4().setVisible(true);
            }
        });
    }
}