import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WrongAnswersPage3 extends JFrame {
    private JLabel questionLabel;
    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;
    private JRadioButton option4;
    private JButton prevButton;
    private JButton nextButton;
    private QuizFactory quizFactory;
    private QuizCorrect quizCorrect;
    public Quiz currentQuiz;
    static int QuizPage;



    private Image backgroundImage;
    private JLabel comment;

    public WrongAnswersPage3() {

        QuizPage=0;
        quizFactory=new QuizFactory();
        quizCorrect=new QuizCorrect(3);



        // JFrame 설정
        setTitle("3단계 오답노트 페이지");
        setSize(800, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        backgroundImage = new ImageIcon("images/quiz_back.png").getImage();

        JPanel panel = new CustomPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // 문제 부분
        questionLabel = new JLabel();
        comment = new JLabel(); //해설 라벨 초기화
        //오답문제 가져오는 부분 여기에 작성 
        quizFactory.prepareQuiz(3);
        loadNewWrongQuiz();

        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setBounds(0, getHeight() / 3 - 50, getWidth(), 50);
        add(questionLabel);

        // 4지 선지 부분 -> 라디오버튼만 남겨두고 텍스트는 검정배경에 글씨만 두게 하고 싶은데 어케해야할지 모르게씀;;
        option1 = new JRadioButton("1번 선지입니다");
        option2 = new JRadioButton("2번 선지입니다");
        option3 = new JRadioButton("3번 선지입니다");
        option4 = new JRadioButton("4번 선지입니다");
        ButtonGroup optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        // 선지 위치+크기 설정
        int optionWidth = 200;
        int optionHeight = 30;
        int gap = 40; // 선지 간의 간격
        int baseYPosition = getHeight() / 3 + 20;

        option1.setBounds((getWidth() - optionWidth) / 2, baseYPosition, optionWidth, optionHeight);
        option2.setBounds((getWidth() - optionWidth) / 2, baseYPosition + gap, optionWidth, optionHeight);
        option3.setBounds((getWidth() - optionWidth) / 2, baseYPosition + 2 * gap, optionWidth, optionHeight);
        option4.setBounds((getWidth() - optionWidth) / 2, baseYPosition + 3 * gap, optionWidth, optionHeight);

        add(option1);
        add(option2);
        add(option3);
        add(option4);

       // comment = new JLabel("<html> -> 이 곳에 오답을 쓰던지 말던지 하 객체를 내가 두번쨰 듣고 있다<br>하하핳하하하하하하하개짜증!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</html>");
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
        ImageIcon nextIcon = new ImageIcon("/nextbutton.png");
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
                String userAnswer = option1.isSelected() ? option1.getText() :
                           option2.isSelected() ? option2.getText() :
                           option3.isSelected() ? option3.getText() :
                           option4.getText();

                boolean isCorrect=quizCorrect.checkAnswer(QuizPage, userAnswer);

                if(QuizPage==4){
                        //다섯번째 문제&&단계 모두 성공시 알 성장 페이지로
                        if (quizCorrect.isAllCorrect()){
                            JOptionPane.showMessageDialog(null, "3단계 오답노트 완료! \n 3단계퀴즈에 다시 도전해 보세요!");
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
                    optionsGroup.clearSelection();       
                }           


               
                
             
            }
        });
        
    }

     //해설까지 함께 불러오는 함수

     private void loadNewWrongQuiz() {
        currentQuiz = quizFactory.getRandomQuiz(3, QuizPage);
        questionLabel.setText(currentQuiz.getQuestion());
        comment.setText("<html>해설: " + currentQuiz.getExplanation() + "</html>");
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
        if (option1 != null) {
            int optionWidth = 200;
            int optionHeight = 30;
            int gap = 40; // 선지 간의 간격
            int baseYPosition = height / 3 + 20;

            option1.setBounds((width - optionWidth) / 2, baseYPosition, optionWidth, optionHeight);
            option2.setBounds((width - optionWidth) / 2, baseYPosition + gap, optionWidth, optionHeight);
            option3.setBounds((width - optionWidth) / 2, baseYPosition + 2 * gap, optionWidth, optionHeight);
            option4.setBounds((width - optionWidth) / 2, baseYPosition + 3 * gap, optionWidth, optionHeight);
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
                new WrongAnswersPage3().setVisible(true);
            }
        });
    }
}
