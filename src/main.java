import java.util.*;
import java.io.*;
import javax.swing.*;

import controller.*;
/**
 * Created by AndyLi on 2017/2/17.
 */
public class main {

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args){
        String filePath;
        filePath="./material/ts300.txt";
        datasetController datasetcontroller=new datasetController();
        List<String> list=datasetcontroller.readTxt(filePath);
        List<poem> poemList=datasetcontroller.handlePoemText(list);
        List<poemUnit> unitList=datasetcontroller.transfer2Unit(poemList);
//        Map<Integer,poemSet> setMap=datasetcontroller.transfetU2Set(unitList);

        Scanner scan=new Scanner(System.in);
        int numberQuestions=5;
        gameController gamecontroller=new gameController(0,numberQuestions,unitList);
        gamecontroller.showOneQuestion();




    }


}

