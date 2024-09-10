import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class WrongAnswersPage1 extends JFrame {
    private JLabel questionLabel;
    private JRadioButton optionO;
    private JRadioButton optionX;
    private JButton prevButton;
    private JButton nextButton;
    private Image backgroundImage;
    private JLabel comment;
    private int gap;
    private QuizFactory quizFactory;
    private QuizCorrect quizCorrect;
    public Quiz currentQuiz;
    static int QuizPage;

    public WrongAnswersPage1() {
        QuizPage=0;
        quizFactory=new QuizFactory();
        quizCorrect=new QuizCorrect(1);


        // JFrame 설정
        setTitle("1단계 오답노트페이지");
        setSize(800, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        backgroundImage = new ImageIcon("images/quiz_back.png").getImage();

        JPanel panel = new CustomPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // 문제 로드 부분
        questionLabel = new JLabel();
        comment = new JLabel(); //해설 라벨 초기화
        //오답문제 가져오는 부분 여기에 작성 
        quizFactory.prepareQuiz(1);
        loadNewWrongQuiz();
        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setBounds(0, getHeight() / 3 - 50, getWidth(), 50);
        add(questionLabel);

        // O/X 부분-> 응용해서 다른 선지 만들어볼수도??
        optionO = new JRadioButton("O");
        optionX = new JRadioButton("X");
        ButtonGroup optionsGroup = new ButtonGroup();
        optionsGroup.add(optionO);
        optionsGroup.add(optionX);

        optionO.setBounds(getWidth() / 2 - 60, getHeight() / 3 + 20, 50, 30); // O 위치 설정
        optionX.setBounds(getWidth() / 2 + 10, getHeight() / 3 + 20, 50, 30); // X 위치 설정

        add(optionO);
        add(optionX);

        //오답 해설 나오는 부분 UI

        int baseYPosition = 340;
         
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
        //ImageIcon nextIcon = new ImageIcon(getClass().getResource("/nextbutton.png"));
        ImageIcon nextIcon = new ImageIcon("images/nextbutton.png");
        Image img2 = nextIcon.getImage();
        Image newImg2 = img2.getScaledInstance(120, 40, Image.SCALE_SMOOTH); // 원하는 크기로 이미지 크기 조정
        nextButton = new JButton(new ImageIcon(newImg2));

        nextButton.setBounds(getWidth()* 3 / 4 - 80, getHeight() - 150, 120, 40);
        add(nextButton);
    //오답 리스트에서 불러오는 로직 작성하는 부분 if-else문으로 
    //displayQuestionAndExplanation();   
    //첫 문제 표시 
    prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(QuizPage==0){
                    new ThirdMenu().setVisible(true);
                    System.out.println("메인 화면으로 이동");
                    dispose();
                }
                else{
                    QuizPage--;
                    loadNewWrongQuiz();

                }
            }
        });
    //오답리스트에서 불러온 문제 다시 정답 체크하는 부분 
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer=optionO.isSelected() ? "true" : "false";
                boolean isCorrect=quizCorrect.checkAnswer(QuizPage, userAnswer);
                // Nextquiz 창 열기 쿠다사이~
                //new QuizOX2().setVisible(true);
                // 현재 창을 닫습니다.
                if(QuizPage==4){
                    //다섯번째 문제&&단계 모두 성공시 알 성장 페이지로
                    if (quizCorrect.isAllCorrect()){
                        JOptionPane.showMessageDialog(null, "1단계 오답노트 완료! \n 1단계퀴즈에 다시 도전해 보세요!");
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "해설을 참고하여 문제를 다시 풀어보세요!");  
                    }    
                } 
                else{
                    QuizPage++;
                    loadNewWrongQuiz();
                }            
            }
        });
    }

   


    //해설까지 함께 불러오는 함수

    private void loadNewWrongQuiz() {
        currentQuiz = quizFactory.getRandomQuiz(1, QuizPage);
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
        if (optionO != null) {
            optionO.setBounds(width / 2 - 60, height / 3 + 20, 50, 30);
        }
        if (optionX != null) {
            optionX.setBounds(width / 2 + 10, height / 3 + 20, 50, 30);
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

            new WrongAnswersPage1().setVisible(true);
                
            }
        });
    }


    
    
}
