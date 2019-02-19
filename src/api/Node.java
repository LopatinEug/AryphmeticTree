package api;

import model.Element;


public class Node {
    private Element element;
    private Node left;
    private Node right;
    private int priority;
    static StringBuilder tab = new StringBuilder("");

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        tab.append('\t');
        builder.append("\n");
        builder.append(tab + "" + element.getClass() + ". " + element.getValue() + " at position: " + element.getPosition() + " \n");
        if (left != null) {
            builder.append(tab + "Left node: ");
            builder.append(left.toString());
        }
        if (left == null) {
            builder.append(tab + "Left node is null \n");
        }
        if (right != null) {
            builder.append(tab + "Right node: ");
            builder.append(right.toString());
        }
        if (right == null) {
            builder.append(tab + "Right node is null \n");
        }
        tab.deleteCharAt(tab.length() - 1);
        return builder.toString();
    }


    public String toString2() {
        StringBuilder builder = new StringBuilder();
        tab.append('\t');
        builder.append("\n");
        builder.append(tab + element.getValue() + " => " + "["+element.getPosition()+"]" + " \n");
        if (left != null) {
            builder.append(tab + "  =>Left node: ");
            builder.append(left.toString2());
        }
        if (left == null) {
           // builder.append(tab + "Left node is null \n");
        }
        if (right != null) {
            builder.append(tab + "  =>Right node: ");
            builder.append(right.toString2());
        }
        if (right == null) {
           // builder.append(tab + "Right node is null \n");
        }
        tab.deleteCharAt(tab.length() - 1);
        return builder.toString();
    }


    public void setElement(Element element) {
        this.element = element;
    }

    public int getPriority() {
        return priority;
    }

    public void reverse(int priority) {

            if (!this.getLeft().equals(null) && this.getLeft().getPriority() == priority) {
                this.getLeft().reverse(priority);
            }

            if (this.getElement().getValue().equals("-")) {
                this.getElement().setValue("+");
            } else if (this.getElement().getValue().equals("+")) {
                this.getElement().setValue("-");
            } else if (this.getElement().getValue().equals("*")) {
                this.getElement().setValue("/");
            } else if (this.getElement().getValue().equals("/")) {
                this.getElement().setValue("*");
            }

            if (!(this.getRight()==null) && this.getRight().getPriority() == priority) {
                this.getRight().reverse(priority);
            }

    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Element getElement() {
        return element;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
