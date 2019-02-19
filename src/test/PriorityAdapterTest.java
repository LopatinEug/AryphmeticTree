package test;

import api.LexicalAnalyzerExeption;
import api.SyntaxAnalyzerExeption;
import api.model.PriorityList;
import impl.SyntaxAnalyzer;
import model.Element;
import util.PriorityAdapter;

import java.util.ArrayList;

public class PriorityAdapterTest {
    public static void main(String[] args) throws LexicalAnalyzerExeption, SyntaxAnalyzerExeption {
        ArrayList<Element> elements=SyntaxAnalyzer.analyze("2 + 2*(2/(4+5)/2+3)");
        PriorityAdapter adapter=new PriorityAdapter();
        PriorityList priorities=adapter.adapt(elements);
        System.out.println();
    }



}
