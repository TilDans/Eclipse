package KE2;

public class Tree {
    Object value;
    Tree[] children;

    Tree(Object value, int length) {
        this.value = value;
        this.children = new Tree[length];
    }

    Tree(int length) {
        this.value = this;
        this.children = new Tree[length];
    }

    public static void main(String[] args) {
        Object x = new Object();
        Tree Tree1 = new Tree(x, 2);
        Tree Tree2 = new Tree(x, 2);
        Tree Tree3 = new Tree(2);
        Tree Tree4 = new Tree(1);
        Tree2.children[0] = Tree3;
        Tree2.children[1] = Tree4;
        Tree3.value = Tree3.children;
        System.out.println(Tree2.children[1].children.length);
    }
}
