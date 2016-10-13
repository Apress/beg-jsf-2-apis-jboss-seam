package faq;

import java.io.Serializable;

public class Question implements Serializable {
    private String questionText;
    private String answerText;
    private boolean isShowingAnswer = false;
    private int rating = 0;

    public Question(String questionText, String answerText) {
        this.questionText = questionText;
        this.answerText = answerText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public String trigger() {
        isShowingAnswer = !isShowingAnswer;
        return null;
    }

    public boolean isShowingAnswer() {
        return isShowingAnswer;
    }

    public String rate() {
        System.out.println("Setting rating to: " + rating);
        return null;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}