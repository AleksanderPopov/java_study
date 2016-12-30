package golovatch.courses.proc.dyn.labs;

/**
 * Created by apop on 7/25/2016.
 */
public class fibonachi_tree_5 {
    private static void print(Tree root, int depth) {
        if (root != null) {
            print(root.right, depth + 1);
            for (int k = 0; k < depth; k++) {
                System.out.print("   ");
            }
            System.out.println(root.value);
            print(root.left, depth + 1);
        }
    }

    private static Tree generateFibValues(int number) {
        return number <= 2 ? new Tree(1) : new Tree(generateFibValues(number - 1), generateFibValues(number - 2));
    }

    private static Tree generateFibNumbers(int number) {
        return number < 2 ? new Tree(number) : new Tree(number, generateFibNumbers(number-1), generateFibNumbers(number-2));
    }

    public static void main(String[] args) {
        Tree root = generateFibValues(6);
//        Tree root1 = generateFibNumbers(6);
        print(root, 0);
//        print(root1, 0);
    }
}