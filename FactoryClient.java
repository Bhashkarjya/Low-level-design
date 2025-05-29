import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import src.main.java.designPatterns.factory.Dialog;
import src.main.java.designPatterns.factory.WebDialog;
import src.main.java.designPatterns.factory.WindowsDialog;

public class FactoryClient {
    private static Dialog dialog;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        System.out.println("Choose the type of button : \n" +
                            "1. HTML button\n" + 
                            "2. Windows button\n");
        
        String choice = reader.readLine();

        if(choice.equals("1")) {
            dialog = new WebDialog();
        }   
        else if(choice.equals("2")) {
            dialog = new WindowsDialog();
        }

        dialog.render();
    }
}