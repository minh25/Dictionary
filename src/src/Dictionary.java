import java.io.*;
import java.util.Scanner;

public class Dictionary {
    private int MAX_SIZE=50000;
    private Word[] arr = new Word[MAX_SIZE];
    private int size=0;

    public Dictionary(Word[] arr) {
        this.arr = arr;
    }
    public Dictionary(){}
    public static void Load(String filePath){
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    static public void main(){
        Dictionary.Load("dic_1.txt");
    }
}
