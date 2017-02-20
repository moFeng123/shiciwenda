package controller;

import java.util.ArrayList;

/**
 * Created by AndyLi on 2017/2/17.
 */
public class poemSet {
    public int catagory;
    public ArrayList<poemUnit> data;

    public poemSet(int catagory) {
        this.catagory = catagory;
        data=new ArrayList<poemUnit>();
    }

    public void showContent(){
        System.out.println("Begin!!!Catogory is "+catagory);
        for(poemUnit aUnit:data){
            aUnit.showContent();
        }
        System.out.println("Finash???Catogory is "+catagory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        poemSet poemSet = (poemSet) o;

        return catagory == poemSet.catagory;
    }

    @Override
    public int hashCode() {
        return catagory;
    }
}
