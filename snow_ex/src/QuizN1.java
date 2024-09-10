import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

    

public class QuizN1 extends JFrame {
    //private Snowflake snowflake;
    public QuizCorrect quizCorrect;
    public QuizFactory quizFactory;
    private Snowflake snowflake;
    //public  WrongAnswers wrongAnswers;

    private JLabel questionLabel;
    private JRadioButton optionO;
    private JRadioButton optionX;
    private JButton prevButton;
    private JButton nextButton;
    private Image backgroundImage;
    public Quiz currentQuiz;
    static int QuizPage;


    public QuizN1() {

        
        //퀴즈 페이지 처음 0으로 초기화
        QuizPage = 0;

        snowflake = new Snowflake();
        quizFactory = new QuizFactory();
        quizCorrect=new QuizCorrect(1);
        //this.wrongAnswers=wrongAnswers;


        // JFrame 설정
        setNewTitle();
        setSize(800, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //backgroundImage = new ImageIcon(getClass().getResource("/quiz_back.png")).getImage();
        backgroundImage = new ImageIcon("images/quiz_back.png").getImage();

        JPanel panel = new CustomPanel();
        panel.setLayout(null);
        setContentPane(panel);

        //문제 로드 부분
        questionLabel = new JLabel();
        quizFactory.prepareQuiz(1);
        loadNewQuiz();
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

        nextButton.setBounds(getWidth()* 3 / 4 - 80, getHeight() - 150, 120, 40);
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
                String userAnswer = optionO.isSelected() ? "true" : "false";
                boolean isCorrect=quizCorrect.checkAnswer(QuizPage, userAnswer);

                if(QuizPage==4){
                        //다섯번째 문제&&단계 모두 성공시 알 성장 페이지로
                        if (quizCorrect.isAllCorrect()){
                            //stage가 0일때만 진화
                            if(snowflake.getStage()==0){
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
                    //라디오 버튼 초기화 ----추가---- 
                    optionsGroup.clearSelection();           
                }                
            }
        });
    }


    private void loadNewQuiz() {
        setNewTitle();
        // 문제 로드
        currentQuiz = quizFactory.getRandomQuiz(1,QuizPage);
        //System.out.println(currentQuiz.getQuestion());
        questionLabel.setText(currentQuiz.getQuestion());
        
    }

    private void setNewTitle() {
        setTitle("OX퀴즈 "+(QuizPage+1)+"번 문제");
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
                //WrongAnswers wrongAnswers = new WrongAnswers(); // WrongAnswers 객체 생성
                new QuizN1().setVisible(true);          
             }
         });
     }


   /*public WrongAnswers getWrongAnswers() {
        return wrongAnswers;
   }*/
    



    };
