package golovatch.courses.io.labs;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 11/5/2016.
 */
public class LookForNewBigImage {

    private static List<File> files = new ArrayList<>();
    private static FileFilter bigImageFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.length() > (1024 * 1024) &&
                    pathname.getName().endsWith(".jpg") &&
                    pathname.getName().endsWith(".gif") &&
                    pathname.getName().endsWith(".bmp") &&
                    pathname.getName().endsWith(".png");
        }
    };

    public static void main(String[] args){
        File file = new File(".//src");
        print(file, files);
        System.out.println(Arrays.toString(files.toArray()));
    }


    public static void print(File root, List<File> files) {
        if (root.isFile()) if (bigImageFilter.accept(root)) files.add(root);
        else for (File file : root.listFiles()) print(file, files);
    }
}
