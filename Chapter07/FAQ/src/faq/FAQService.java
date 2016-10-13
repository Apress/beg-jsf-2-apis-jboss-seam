package faq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Named;
import javax.context.SessionScoped;

@Named("faqService")
@SessionScoped
public class FAQService implements Serializable {
    private List<Question> questions;
    
    public FAQService() {
        questions = new ArrayList<Question>();
        questions.add(new Question("How to run Eclipse?", "Double-click its icon."));
        questions.add(new Question("How to auto-complete?", "Press Ctrl-Space."));
        questions.add(new Question("How to delete a file?", "Press Del."));
    }
    public List<Question> getQuestions() {
        return questions;
    }
}