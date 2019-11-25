package com.zhufangda.exercise.file;

import java.io.File;
import java.util.*;

public class FileTest {


        public static void main(String[] args) {

            try (Scanner in = new Scanner(System.in)) {
                System.out.print("Enter base directory:");
                String directory = in.nextLine();
                if (directory.equals("")) {
                    directory = "E:\\github\\Reforcement_Learning";
                }

                File file = new File(directory);

                System.out.printf("File:%s Size:%d\n", file.getAbsolutePath(), file.length());


            }
        }
}
