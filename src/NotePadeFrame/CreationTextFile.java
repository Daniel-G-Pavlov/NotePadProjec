package NotePadeFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreationTextFile extends StartFrame{

    CreationTextFile(){

        int inputLines = 0;
        int inputString = 0;
        File file = new File(fileName + ".txt");
        Scanner scanner = null;

        try{
            scanner = new Scanner(file, "UTF-8");
            while (scanner.hasNextLine()){
                inputLines++;
                inputString++;
                System.out.println("Line: " + inputString + " " + scanner.nextLine());
            }
            scanner.close();
        } catch (
                FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found");

        }finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }
}
