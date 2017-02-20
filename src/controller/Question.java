package controller;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Created by AndyLi on 2017-02-19.
 */
public class Question {
    List<poemUnit> questionSet;
    poemUnit selected;
    int answer;

    public Question(List<poemUnit> questionSet) {
        this.questionSet = questionSet;
        setQuestion();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return selected != null ? selected.equals(question.selected) : question.selected == null;

    }

    @Override
    public int hashCode() {
        return selected != null ? selected.hashCode() : 0;
    }

    public void setQuestion(){
        Random random=new Random();
        this.answer=random.nextInt(questionSet.size());
        this.selected=questionSet.get(answer);


    }
    public void showContent(){
        for(poemUnit aUnit:questionSet){
            System.out.println("aUnit:");
            aUnit.showContent();
        }
        System.out.println("selected:"+selected);
    }
}
