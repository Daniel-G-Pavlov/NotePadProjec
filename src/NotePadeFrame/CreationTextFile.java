package NotePadeFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreationTextFile extends NewFileFrame {

    public CreationTextFile(){
//        this(fileName);
//        super(fileName);


        int inputLines = 0;
        int inputString = 0;
        File file = new File(fileName + ".txt");
        System.out.println(fileName);
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

    public CreationTextFile( String fileName ) {
        super(fileName);
        this.fileName = fileName;
    }
}
