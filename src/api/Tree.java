package api;

import api.model.PriorityList;
import impl.SyntaxAnalyzer;
import model.Element;
import util.PriorityAdapter;

import java.util.ArrayList;

public class Tree {
    private Node root;
    private PriorityList priorities;

    private PriorityList adapt(ArrayList<Element> list) {
        PriorityAdapter adapter = new PriorityAdapter();
        PriorityList priorityList = adapter.adapt(list);

        return priorityList;
    }

    public Tree(String expression) throws LexicalAnalyzerExeption, SyntaxAnalyzerExeption {

        ArrayList<Element> list = SyntaxAnalyzer.analyze(expression);

        this.priorities = this.adapt(list);
        root = new Node();
    }


    private void completeRec(Node node, PriorityList list) {

        if (list.size() >= 3) {
            ArrayList<Integer> postions = new ArrayList<>();

            int minPosition = 1;
            int minValue = list.getPriority(minPosition);

            if (minValue == 0) {
                minPosition = 0;
                minValue = list.getPriority(minPosition);
            }

            postions.add(minPosition);

            for (int i = 2; i < list.size(); i++) {
                if (list.getPriority(i) > 0 && list.getPriority(i) <= minValue) {
                    minPosition = i;

                    if (list.getPriority(minPosition) < minValue) {
                        postions.clear();
                    }

                    postions.add(minPosition);
                    minValue = list.getPriority(minPosition);
                }
            }

            if(postions.size()==1){
                minPosition=postions.get(0);
            }else if(postions.size()%2==0){
                minPosition=postions.get(postions.size()/2-1);
            }else {
                minPosition=postions.get(postions.size()/2);
            }

            node.setElement(list.getElement(minPosition));
            node.setPriority(list.getPriority(minPosition));

            PriorityList leftList = list.getLeftSublist(minPosition);
            node.setLeft(new Node());
            completeRec(node.getLeft(), leftList);

            PriorityList rightList = list.getRightSublist(minPosition);
            node.setRight(new Node());
            completeRec(node.getRight(), rightList);
        } else if (list.size() == 2) {
            node.setElement(list.getElement(0));
            node.setRight(new Node());
            node.getRight().setElement(list.getElement(1));
            node.setLeft(null);
        } else if (list.size() == 1) {
            node.setElement(list.getElement(0));
            node.setRight(null);
            node.setLeft(null);
        }


    }

    public Node complete() {
        completeRec(root, priorities);
        return root;
    }

    public Node getRoot() {
        return root;
    }

    public void transform(Node node){
        if(!(node.getLeft()==null)){
            transform(node.getLeft());
        }

        if((!(node.getRight()==null)&&node.getRight().getPriority()==node.getPriority())&&(node.getElement().getValue().equals("-")||node.getElement().getValue().equals("/"))){
            node.getRight().reverse(node.getPriority());
        }

        if(!(node.getRight()==null)){
            transform(node.getRight());
        }

    }
}
