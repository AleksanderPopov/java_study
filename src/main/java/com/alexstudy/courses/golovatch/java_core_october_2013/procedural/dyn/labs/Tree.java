package golovatch.courses.proc.dyn.labs;

/**
 * Created by Alex on 7/24/2016.
 */
public class Tree {
    int value;
    Tree left;
    Tree right;

    Tree() {
        value = 0;
        left = null;
        right = null;
    }

    Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }


    Tree(Tree left, Tree right) {
        this.left = left;
        this.right = right;
        this.value = left.value + right.value;
    }

    Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int sizeR() {
        if (left != null & right != null) return 1 + left.sizeR() + right.sizeR();
        else if (left != null) return 1 + left.sizeR();
        else if (right != null) return 1 + right.sizeR();
        else return 1;
    }

    public int heightR() {
        if (left != null & right != null)
            return left.heightR() > right.heightR() ? 1 + left.heightR() : 1 + right.heightR();
        else if (right != null) return 1 + right.heightR();
        else if (left != null) return 1 + left.heightR();
        else return 1;
    }

    public int sumR() {
        if (left != null & right != null) return this.value + left.sumR() + right.sumR();
        else if (left != null) return this.value + left.sumR();
        else if (right != null) return this.value + right.sumR();
        return this.value;
    }

    public int maxR() {
        if (left != null & right != null) return maxInt(value, left.maxR(), right.maxR());
        else if (left != null) return maxInt(value, left.maxR());
        else if (right != null) return maxInt(value, right.maxR());
        return value;
    }

    private int maxInt(int... arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Integer i = new Integer("10");
        System.out.println(i);
        System.out.println(i);
//        Object[] ref = new Object[1];
//        while (true) {
//            Object[] a = new Object[1];
//            Object[] b = {a};
//            a[0] = b;
//            ref[0] = new Object[]{ref, a, b};
//        }
    }
}
