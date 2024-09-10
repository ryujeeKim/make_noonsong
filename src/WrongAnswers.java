import java.util.*;


public class WrongAnswers {

    private List<Integer> wrongAnswerNumbers;

    

    public WrongAnswers() {
        wrongAnswerNumbers = new ArrayList<>();

        
    }
    public void addWrongAnswer(int questionNumber) {
        if (!wrongAnswerNumbers.contains(questionNumber)) {
            wrongAnswerNumbers.add(questionNumber);
        }
    }

    public List<Integer> getWrongAnswerNumbers() {
        return new ArrayList<>(wrongAnswerNumbers);
    }

}


