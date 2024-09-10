import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WrongAnswersPage4 extends JFrame {
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton prevButton;
    private JButton nextButton;
    private Image backgroundImage;
    private int baseYPosition;
    private int gap;
    private QuizFactory quizFactory;
    private QuizCorrect quizCorrect;
    public Quiz currentQuiz;
    static int QuizPage;

    

    private JLabel comment;

    public WrongAnswersPage4() {
        QuizPage=0;
        quizFactory=new QuizFactory();
        quizCorrect=new QuizCorrect(4);



        // JFrame 설정
        setTitle("4단계 오답노트 페이지");
        setSize(800, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
      //backgroundImage = new ImageIcon(getClass().getResource("images/quiz_back.png")).getImage();
        backgroundImage = new ImageIcon("images/quiz_back.png").getImage();
        JPanel panel = new CustomPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // 문제 부분
        questionLabel = new JLabel();
        comment = new JLabel(); //해설 라벨 초기화
        //오답문제 가져오는 부분 여기에 작성 
        quizFactory.prepareQuiz(4);
        loadNewWrongQuiz();

        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setBounds(0, getHeight() / 3 - 50, getWidth(), 50);
        add(questionLabel);

        // 단답형 입력 부분
        answerField = new JTextField();
        answerField.setBounds(getWidth() / 2 - 100, getHeight() / 3 + 20, 200, 30);
        add(answerField);

        baseYPosition = 340;
        //comment = new JLabel();
        comment.setFont(new Font("SansSerif", Font.BOLD, 18));
        comment.setForeground(Color.GREEN);
        comment.setHorizontalAlignment(SwingConstants.CENTER);
        comment.setBounds(0, baseYPosition + 4 * gap, getWidth(), 50); // 선지 아래에 배치
        add(comment);

        // 이전 문제 버튼 (이미지 버튼)
        ImageIcon prevIcon = new ImageIcon("images/backbutton.png");
        Image img = prevIcon.getImage();
        Image newImg = img.getScaledInstance(120, 40, Image.SCALE_SMOOTH); // 원하는 크기로 이미지 크기 조정
        prevButton = new JButton(new ImageIcon(newImg));

        prevButton.setBounds(getWidth() / 4 - 80, getHeight() - 150, 120, 40);
        add(prevButton);

        // 다음 문제 버튼
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
                    loadNewWrongQuiz();
                }
            
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText();
                boolean isCorrect=quizCorrect.checkAnswer(QuizPage, userAnswer);

                if(QuizPage==4){
                        //다섯번째 문제&&단계 모두 성공시 알 성장 페이지로
                        if (quizCorrect.isAllCorrect()){
                            JOptionPane.showMessageDialog(null, "4단계 오답노트 완료! \n 4단계퀴즈에 다시 도전해 보세요!");
                            dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "해설을 참고하여 문제를 다시 풀어보세요!");
                        }    
                }
                else{
                    // 다음 문제 로드
                    QuizPage++;
                    loadNewWrongQuiz();    
                           
                }           


               
                
             
            }
        });

        
    }

    private void loadNewWrongQuiz() {
        currentQuiz = quizFactory.getRandomQuiz(4, QuizPage);
        questionLabel.setText(currentQuiz.getQuestion());
        comment.setText("해설: " + currentQuiz.getExplanation());
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
                new WrongAnswersPage4().setVisible(true);
            }
        });
    }
}