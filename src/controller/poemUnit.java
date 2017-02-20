package controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndyLi on 2017/2/17.
 */
public class poemUnit {
    public String firstSen;
    public String secondSen;
    public int caragory;
    public String name;
    public String author;
    public List<String> sentences;



    public poemUnit(String firstSen, String secondSen, int caragory,
                    String name, String author) {
        this.firstSen = firstSen;
        this.secondSen = secondSen;
        this.sentences=new ArrayList<String>();
        sentences.add(firstSen);
        sentences.add(secondSen);
        this.caragory = caragory;
        this.name = name;
        this.author = author;
    }

    public void showContent(){
        System.out.println(1+firstSen);
        System.out.println(2+secondSen);
        System.out.println("catagory:"+caragory);
        System.out.println("name: "+name);
        System.out.println("author"+author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        poemUnit poemUnit = (poemUnit) o;

        if (!firstSen.equals(poemUnit.firstSen)) return false;
        return secondSen.equals(poemUnit.secondSen);
    }

    @Override
    public int hashCode() {
        int result = firstSen.hashCode();
        result = 31 * result + secondSen.hashCode();
        return result;
    }
}
