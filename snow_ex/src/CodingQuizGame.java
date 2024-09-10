// //퀴즈 화면 및 눈송이 성장 단계 구현

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class CodingQuizGame extends JFrame {
//    private Snowflake snowflake;
//    private QuizFactory quizFactory;
//    private JLabel snowflakeLabel;
//    private JTextArea questionArea;
//    private JTextField answerField;
//    private JButton submitButton;
//    private JButton nextButton;
//    private JLabel feedbackLabel;

//    public CodingQuizGame() {
//        snowflake = new Snowflake();
//        quizFactory = new QuizFactory();
       
       
//    }


//    private void setupUI() {
//        setTitle("코딩 퀴즈 눈송 키우기");
//        setSize(800, 660);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());



//        snowflakeLabel = new JLabel(snowflake.getCurrentStageIcon(), JLabel.CENTER);
//        questionArea = new JTextArea();
//        questionArea.setLineWrap(true); //줄 바꿈 활성화
//        questionArea.setWrapStyleWord(true); //줄 바꿈 스타일 설정
//        questionArea.setEditable(false); //읽기 전용
//        answerField = new JTextField(10);
//        submitButton = new JButton("제출");
//        nextButton = new JButton("다음 퀴즈");
//        feedbackLabel = new JLabel("", JLabel.CENTER);

//        JPanel topPanel = new JPanel(new BorderLayout());
//        topPanel.add(snowflakeLabel, BorderLayout.CENTER);
//        add(topPanel, BorderLayout.NORTH);

//        JPanel centerPanel = new JPanel(new BorderLayout());
//        centerPanel.add(new JScrollPane(questionArea), BorderLayout.CENTER);
//        add(centerPanel, BorderLayout.CENTER);

//        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
//        JPanel answerPanel = new JPanel(new FlowLayout());
//        answerPanel.add(new JLabel("정답:"));
//        answerPanel.add(answerField);
//        answerPanel.add(submitButton);
//        answerPanel.add(nextButton);
//        bottomPanel.add(answerPanel);
//        bottomPanel.add(feedbackLabel);
//        add(bottomPanel, BorderLayout.SOUTH);

//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                checkAnswer();
//            }
//        });

//        nextButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                loadNewQuiz();
//            }
//        });

//        nextButton.setVisible(false);
//    }

//    private Quiz currentQuiz;

//    private void loadNewQuiz() {
//        currentQuiz = quizFactory.getRandomQuiz(snowflake.getStage());
//        questionArea.setText(currentQuiz.getQuestion());
//        answerField.setText("");
//        feedbackLabel.setText("");
//        submitButton.setVisible(true);
//        nextButton.setVisible(false);
//    }

//    private void checkAnswer() {
//        String userAnswer = answerField.getText();
//        if (currentQuiz.isCorrect(userAnswer)) {
//            feedbackLabel.setText("정답입니다!");
//            snowflake.evolve();
//            snowflakeLabel.setIcon(snowflake.getCurrentStageIcon());
//        } else {
//            feedbackLabel.setText("오답입니다.");
//        }
//        submitButton.setVisible(false);
//        nextButton.setVisible(true);
//    }


//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new CodingQuizGame().setVisible(true);
//            }
//        });
//    }
// }
