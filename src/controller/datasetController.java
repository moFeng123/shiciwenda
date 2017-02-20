package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AndyLi on 2017/2/17.
 */
public class datasetController {
    public datasetController() {
    }


    public  List<String> readTxt(String filePath){
        List<String> list=new ArrayList<String>();
        try
        {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }




    public List<poem> handlePoemText(List<String> list){
        List<poem> result=new ArrayList<poem>();

        int lastTitle=0;
        int poemId=0;
        int temptCato=-1;
        boolean isDeleted=false;
        for(int i=0;i<list.size();i++){
           if (isTitle(list.get(i))){
               lastTitle=i;
               result.add(handleTitle(list.get(lastTitle)));
               break;
           }
       }
        if(lastTitle==0){
            //TODO
        }
        for(int i=lastTitle+1;i<list.size();i++){
            if(isTitle(list.get(i))){
                if(isDeleted){
                    result.remove(result.size()-1);
                }
                result.add(handleTitle(list.get(i)));
                temptCato=-1;

            }
            else{
                String pattern="，";
                String tempt=list.get(i);
               String[] lineResult= tempt.split(pattern);
                if (lineResult.length==2) {
                    lineResult[1] = lineResult[1].substring(0, lineResult[1].length() - 1);
                    if (lineResult[0].length() == lineResult[1].length()) {
                        result.get(result.size()-1).content.add(lineResult[0]);
                        result.get(result.size()-1).content.add(lineResult[1]);
                        if(temptCato==-1 || lineResult[0].length()==temptCato) {
                            result.get(result.size() - 1).catagory = lineResult[0].length();
                            temptCato=lineResult[0].length();
                        }
                        else{
                            isDeleted=true;
                        }
                    }

                }

            }
        }
        return result;
    }


    public List<poemUnit> transfer2Unit(List<poem> input){
        List<poemUnit> output=new ArrayList<poemUnit>();
        for(poem aPoem :input){
            if(aPoem.content.size()%2==0&&aPoem.catagory==5) {
                for (int i = 0; i < aPoem.content.size() - 1;i=i+2 ) {
                    output.add(new poemUnit(aPoem.content.get(i),aPoem.content.get(i+1),aPoem.catagory,
                            aPoem.name,aPoem.author));
                }
            }
        }

        return output;
    }

    public Map<Integer,poemSet> transfetU2Set(List<poemUnit> input){
        Map<Integer,poemSet> output=new HashMap<Integer, poemSet>();
        for(poemUnit aUnit:input){
            int cato=aUnit.caragory;
            if(output.containsKey(cato)){
                output.get(cato).data.add(aUnit);
            }
            else{
                output.put(cato,new poemSet(cato));
                output.get(cato).data.add(aUnit);
            }
        }

        return output;
    }






    public boolean isTitle(String input){
        boolean result=false;
        String pattern="\\d{3}.*";
        result=input.matches(pattern);
        return result;
    }
    public poem handleTitle(String line){
        poem aPoem=new poem("","");

        line=line.substring(3);
        String pattern1="：";
        String[] tempt=line.split(pattern1);
        aPoem.author=tempt[0];
        aPoem.name=tempt[1];

        return aPoem;
    }

}
