package api.model;

import model.Element;

import java.util.ArrayList;

public class PriorityList {
    private ArrayList<Element> elements;
    private ArrayList<Integer> priority;

    public PriorityList() {
        elements = new ArrayList<>();
        priority = new ArrayList<>();
    }

    public void add(Element el,int pr){
        elements.add(el);
        priority.add(pr);
    }

    public Element getElement(int i){
     return elements.get(i);
    }

    public int getPriority(int i){
     return  priority.get(i);
    }

    public int size(){
        return elements.size();
    }

    public PriorityList getLeftSublist(int i) {
        PriorityList leftList=new PriorityList();
        for (int j = 0; j <i ; j++) {
            leftList.add(getElement(j),getPriority(j));
        }
        return leftList;
    }

    public PriorityList getRightSublist(int i) {
        PriorityList rightList=new PriorityList();
        for (int j = i+1 ; j < size() ; j++) {
            rightList.add(getElement(j),getPriority(j));
        }
        return rightList;
    }
}
