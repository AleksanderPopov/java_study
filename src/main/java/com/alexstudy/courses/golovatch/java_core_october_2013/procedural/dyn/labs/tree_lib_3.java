package golovatch.courses.proc.dyn.labs;

/**
 * Created by Alex on 7/24/2016.
 */
public class tree_lib_3 {
    private static Tree fillTree(int length) {
        if (length <= 0) return null;
        return new Tree(0, fillTree(length-1), fillTree(length-2));
    }

    public static void main(String[] args) {
        Tree mainTree = new Tree(10, new Tree(20, null, null), new Tree(30, null, new Tree(40, null, null)));
        System.out.println("main is " + mainTree.value);
        System.out.println("main-left is " + mainTree.left.value);
        System.out.println("main-right is " + mainTree.right.value);
        System.out.println("main-right-right is " + mainTree.right.right.value);

        System.out.println("sizeR is " + mainTree.sizeR());
        System.out.println("heightR is " + mainTree.heightR());
        System.out.println("sumR is " + mainTree.sumR());
        System.out.println("maxR is " + mainTree.maxR());
    }
}
