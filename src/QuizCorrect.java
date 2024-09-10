import java.util.ArrayList;
import java.util.List;

public class QuizCorrect {
    private QuizFactory quizFactory;
    private List<Boolean> userAnswers;
    private int correctCount;
    private int selectedDifficulty;
    public List<Boolean> answersCheckList;

    public QuizCorrect(int selectedDifficulty) {
        this.selectedDifficulty=selectedDifficulty;
        quizFactory = new QuizFactory();
        quizFactory.setSelectedDifficulty(selectedDifficulty);
        //quizFactory.prepareQuiz(selectedDifficulty);

        userAnswers = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            userAnswers.add(null);
        }

        answersCheckList =  new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
           answersCheckList.add(null);
        }
        correctCount = 0;
    }

//public boolean checkAnswer(int quizIndex, String userAnswer) {
        // 사용자가 선택한 난이도 가져오기
        // 사용자가 선택한 난이도에 맞는 퀴즈 가져오기
  //      Quiz quiz = quizFactory.getRandomQuiz(selectedDifficulty,quizIndex);
    //    boolean isCorrect = quiz.checkAnswer(userAnswer);
      //  userAnswers.set(quizIndex, isCorrect);
       // if (isCorrect) {
        //    correctCount++;
        //}
      //  return isCorrect;
    //}
//}

public boolean checkAnswer(int quizIndex, String userAnswer) {
    // 퀴즈 객체를 가져오기 위해 selectedDifficulty와 quizIndex를 사용
    Quiz quiz = quizFactory.getRandomQuiz(selectedDifficulty, quizIndex);

    boolean isCorrect = false;

    switch (selectedDifficulty) {
        case 1:
            // 1단계는 OX 퀴즈로 boolean 값을 사용하여 정답을 판별
            if (quiz instanceof OXQuiz) {
                boolean correctAnswer = ((OXQuiz) quiz).getAnswer();
                isCorrect = correctAnswer == Boolean.parseBoolean(userAnswer);
            }
            break;
        case 2:
        case 3:
        case 4:
            // 2단계부터 4단계는 String 값을 사용하여 정답을 판별
            if (quiz instanceof MultipleChoiceQuiz) {
                String correctAnswer = ((MultipleChoiceQuiz) quiz).getCorrectAnswer();
                isCorrect = correctAnswer.equalsIgnoreCase(userAnswer);
            } else if (quiz instanceof ShortAnswerQuiz) {
                String correctAnswer = ((ShortAnswerQuiz) quiz).getCorrectAnswer();
                isCorrect = correctAnswer.equalsIgnoreCase(userAnswer);
            }
            break;
        default:
            throw new IllegalArgumentException("Invalid difficulty level: " + selectedDifficulty);
    }

    // 사용자의 정답을 기록
    userAnswers.set(quizIndex, isCorrect);
    answersCheckList.set(quizIndex, isCorrect);

    // 정답인 경우 correctCount 증가
    if (isCorrect) {
        correctCount++;
    }

    return isCorrect;
}


public boolean isAllCorrect() {
        //return correctCount == 5;
        //answersCheckList안의 원소가 모두 true인지 
        boolean allTrue = answersCheckList.stream().allMatch(Boolean::booleanValue);  
        return allTrue;
    }

    public List<Boolean> getUserAnswers() {
        return userAnswers;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public List<Boolean> getAnswersCheckList() {
        return answersCheckList;
    }

    public static void main(String[] args) {
        
    }
}
