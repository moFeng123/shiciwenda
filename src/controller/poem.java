package controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndyLi on 2017-02-17.
 */
public class poem {
    public String name;
    public String author;
    public List<String> content;
    public int catagory;

    public poem(String name, String author) {
        this.name = name;
        this.author = author;
        content=new ArrayList<String>();
    }
    public void showContent(){
        System.out.println(author+": "+name);
        for(String i :content){
            System.out.println(i);
        }
    }
}
