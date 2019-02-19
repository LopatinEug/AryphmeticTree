package test;

import api.LexicalAnalyzerExeption;
import api.SyntaxAnalyzerExeption;
import api.Tree;
import impl.SyntaxAnalyzer;
import model.Element;

import java.util.ArrayList;

public class AryphmeticTreeTest {
    public static void main(String[] args) {

        String expression="20-10-5-2";

        Tree tree = null;
        try {
          tree = new Tree(expression);
        } catch (LexicalAnalyzerExeption lexicalAnalyzerExeption) {
            lexicalAnalyzerExeption.printStackTrace();
        } catch (SyntaxAnalyzerExeption syntaxAnalyzerExeption) {
            syntaxAnalyzerExeption.printStackTrace();
        }

        tree.complete();
        System.out.println(expression);
        System.out.println(tree.getRoot().toString2());
        System.out.println("Tree after transform");
        tree.transform(tree.getRoot());
        System.out.println(tree.getRoot().toString2());
    }


}
