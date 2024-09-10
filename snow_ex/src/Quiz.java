// 퀴즈 관련 클래스

import java.util.*;

public abstract class Quiz {
    private String question;
    private int difficulty;
    private String explanation;
    private int questionNumber;

    public Quiz(String question,int difficulty,String explanation,int questionNumber) {
        this.question = question;
        this.difficulty = difficulty;
        this.explanation= explanation;
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public abstract boolean checkAnswer(String answer);
}

class OXQuiz extends Quiz {
    private boolean answer;

    public OXQuiz(String question, boolean answer, int difficulty,String explanation,int questionNumber) {
        super(question, difficulty,explanation, questionNumber);
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return this.answer == Boolean.parseBoolean(answer);
    }

    public boolean getAnswer() {
        return answer;
    }

}

class MultipleChoiceQuiz extends Quiz {
    private List<String> options;
    private String correctAnswer;

    public MultipleChoiceQuiz(String question, List<String> options, String correctAnswer, int difficulty,String explanation, int questionNumber) {
        super(question, difficulty,explanation, questionNumber);
        this.options = options;
        this.correctAnswer = correctAnswer;
    
    }

    @Override
    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }

}

class ShortAnswerQuiz extends Quiz {
    private String correctAnswer;

    public ShortAnswerQuiz(String question, String correctAnswer, int difficulty,String explanation,int questionNumber) {
        super(question, difficulty,explanation, questionNumber);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }
}
