package pruefungsvorbereitung.klausurws19;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    private Node root = null;

    public boolean equals(BinarySearchTree bst) {
        if (bst == null)
            return root == null;
        else
            return equalsR(root, bst.root);
    }

    private boolean equalsR(Node p, Node q) {
        if (p == null && q == null)
            return true;
        else if (p == null && q != null)
            return false;
        else if (p != null && q == null)
            return false;
        else
            return p.data == q.data && equalsR(p.left, q.left) && equalsR(p.right, q.right);
    }

    public List<Integer> collect(Predicate<Integer> pred) {
        List<Integer> l = new LinkedList<>();
        collectR(root, l, pred);
        return l;
    }

    private void collectR(Node p, List<Integer> l, Predicate<Integer> pred) {
        if (p != null) {
            collectR(p.left, l, pred);
            if(pred.test(p.data))
                l.add(p.data);
            collectR(p.right, l, pred);
        }
    }
}
