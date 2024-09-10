import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class QuizN3 extends JFrame {
    //private Snowflake snowflake;
    private WrongAnswers wrongAnswers;
    private QuizCorrect quizCorrect;
    private QuizFactory quizFactory;
    private JLabel questionLabel;
    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;
    private JRadioButton option4;
    private JButton prevButton;
    private JButton nextButton;
    private Snowflake snowflake;

    private Image backgroundImage;

    static int QuizPage;

    public QuizN3() {
        QuizPage = 0;

        snowflake = new Snowflake();
        quizFactory = new QuizFactory();
        quizCorrect=new QuizCorrect(3);
        wrongAnswers=new WrongAnswers();


        // JFrame 설정
        setNewTitle();
        setSize(800, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        backgroundImage = new ImageIcon("images/quiz_back.png").getImage();

        JPanel panel = new CustomPanel();
        panel.setLayout(null);
        setContentPane(panel);

        
        questionLabel = new JLabel();
        // 4지 선지 부분 -> 라디오버튼만 남겨두고 텍스트는 검정배경에 글씨만 두게 하고 싶은데 어케해야할지 모르게씀;;
        option1 = new JRadioButton("1번 선지");
        option2 = new JRadioButton("2번 선지");
        option3 = new JRadioButton("3번 선지");
        option4 = new JRadioButton("4번 선지");

        //문제 로드 부분
        quizFactory.prepareQuiz(3);
        loadNewQuiz();
        questionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setBounds(0, getHeight() / 3 - 50, getWidth(), 50);
        add(questionLabel);

        
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
                    loadNewQuiz();
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

                if(!isCorrect){
                    if (currentQuiz != null) {
                        wrongAnswers.addWrongAnswer(currentQuiz.getQuestionNumber());
                    }
                    
                }
                if(QuizPage==4){
                        //다섯번째 문제&&단계 모두 성공시 알 성장 페이지로
                    if (quizCorrect.isAllCorrect()){
                        //stage가 2일때만 진화
                        if(snowflake.getStage()==2){
                            new noonsong_growth().setVisible(true);
                            snowflake.evolve();
                            dispose();
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
                    loadNewQuiz();    
                    optionsGroup.clearSelection();       
                }           
            }
        });
    }

    private Quiz currentQuiz;

    private void loadNewQuiz() {

        setNewTitle();
        // 문제 로드
        currentQuiz = quizFactory.getRandomQuiz(3, QuizPage);
        //questionLabel.setText(currentQuiz.getQuestion());
        MultipleChoiceQuiz newQuiz = (MultipleChoiceQuiz) currentQuiz;
        questionLabel.setText(newQuiz.getQuestion());

        //선지 로드
        List<String> optionArr = new ArrayList<>();
        optionArr = newQuiz.getOptions();
        option1.setText(optionArr.get(0));
        option2.setText(optionArr.get(1));
        option3.setText(optionArr.get(2));
        option4.setText(optionArr.get(3));  
    }

    private void setNewTitle() {
        setTitle("4지선다 "+(QuizPage+1)+"번 문제");
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
                new QuizN3().setVisible(true);
            }
        });
    }
}
