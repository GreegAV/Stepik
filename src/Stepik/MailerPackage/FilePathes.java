package Stepik.MailerPackage;

import java.io.File;
import java.io.IOException;

/**
 * Created by avg-m on 26/06/2017.
 */
public class FilePathes {
    public static void main(String[] args) throws IOException {

        File file = new File(".\\a\\b\\..\\b\\c\\.\\file.txt");
        System.out.println(".\\a\\b\\..\\b\\c\\.\\file.txt");
        System.out.println(file.getCanonicalPath());
        System.out.println("____________________________________________");

        File file1 = new File("a\\b\\..\\file.txt");
        System.out.println("a\\b\\..\\file.txt");
        System.out.println(file1.getCanonicalPath());
        System.out.println("____________________________________________");

        File file2 = new File("a\\..\\b\\c\\file.txt");
        System.out.println("a\\..\\b\\c\\file.txt");
        System.out.println(file2.getCanonicalPath());
        System.out.println("____________________________________________");

        File file3 = new File("a\\b\\c\\file.txt");
        System.out.println("a\\b\\c\\file.txt");
        System.out.println(file3.getCanonicalPath());
        System.out.println("____________________________________________");

        File file4 = new File("a\\.\\b\\..\\c\\.\\file.txt");
        System.out.println("a\\.\\b\\..\\c\\.\\file.txt");
        System.out.println(file4.getCanonicalPath());
        System.out.println("____________________________________________");
    }

}
