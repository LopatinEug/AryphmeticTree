package api;

public class AryphmeticTreeProvider {
    public static Tree provide(String expression){
        Tree tree = null;
        try {
            tree = new Tree(expression);
        } catch (LexicalAnalyzerExeption lexicalAnalyzerExeption) {
            lexicalAnalyzerExeption.printStackTrace();
        } catch (SyntaxAnalyzerExeption syntaxAnalyzerExeption) {
            syntaxAnalyzerExeption.printStackTrace();
        }
        tree.complete();
        tree.transform(tree.getRoot());
        return tree;
    }
}
