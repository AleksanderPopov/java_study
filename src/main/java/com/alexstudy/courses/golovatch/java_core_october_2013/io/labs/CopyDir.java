package golovatch.courses.io.labs;

import golovatch.courses.io.CopyFile_Demo;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alex on 11/8/2016.
 */
public class CopyDir {
    public static void main(String[] args) throws IOException {
        copy(new File("d:/Dropbox"), new File("d:/Dropbox2"));
    }

    private static void copy(File src, File dst) throws IOException {
        if (src.isDirectory()) {
            if (!dst.exists()) dst.mkdir();

            for (File srcSubDir : src.listFiles()) {
                String subDirName = srcSubDir.getName();
                copy(srcSubDir, new File(dst, subDirName));
            }
        } else {
            if (!dst.exists()) dst.createNewFile();
            CopyFile_Demo.copyBuff(src, dst);
        }
    }
}
