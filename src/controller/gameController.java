package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by AndyLi on 2017-02-18.
 */
public class gameController {
    int correct;
    int total;
    List<Question> questionList;

    public gameController(int correct, int total,List<poemUnit> unitList) {
        this.correct = correct;
        this.total = total;
        this.questionList = getQuestionList(unitList);
    }

    public  List<Integer> GetRandomSequence4(int max)
    {
        ArrayList<Integer> output=new ArrayList<Integer>();
        Random random=new Random();
        for(int i=0;i<1000&&output.size()<4;i++){
            int tempt=random.nextInt(max);
            if(!output.contains(tempt)){
                output.add(tempt);
            }
        }

        return output;
    }

    public Question getQuestion(List<poemUnit> poemUnits){
        if(poemUnits.size()<50){
            return null;
        }
        List<Integer> indexQuestion=this.GetRandomSequence4(poemUnits.size()-1);
        List<poemUnit> output=new ArrayList<poemUnit>();
       for(int i:indexQuestion){
           output.add(poemUnits.get(i));
       }
        return new Question(output);
    }

    public List<Question> getQuestionList(List<poemUnit> poemUnits){
        List<Question> output=new ArrayList<Question>();
        for(int i=0;output.size()<total;i++){
            Question aQuestion=getQuestion(poemUnits);
            if(!output.contains(aQuestion)){
                output.add(aQuestion);
            }
        }
        this.questionList=output;
        return output;
    }

    public boolean answerQuestion(Question question){
        boolean answer=false;
        Random random=new Random();
        int fos=random.nextInt(2);
        int nfos=1-fos;

        if(fos==0) {
            System.out.print(question.selected.sentences.get(fos)+", _____________");
        }
        else{
            System.out.print("_____________, "+question.selected.sentences.get(fos));
        }
        System.out.println("  "+question.selected.author+"《"+question.selected.name+"》");
        for(int i=1;i<5;i++){
            System.out.println(i+": "+question.questionSet.get(i-1).sentences.get(nfos));
        }

        Scanner scan=new Scanner(System.in);
        System.out.print("Answer:");
        if(scan.nextInt()==question.answer+1){
            correct++;
            answer=true;
        }else{
            System.out.println("Correct answer:"+question.selected.sentences.get(nfos));
        }

        return answer;
    }

    public void showOneQuestion(){
        for(Question aQuestion:questionList){
            answerQuestion(aQuestion);
        }

        System.out.println("正确率:"+correct+"/"+total );

    }




}
