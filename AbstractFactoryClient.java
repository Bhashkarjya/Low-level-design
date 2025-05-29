import java.io.BufferedReader;
import java.io.InputStreamReader;

import src.main.java.designPatterns.abstractFactory.Button;
import src.main.java.designPatterns.abstractFactory.Checkbox;
import src.main.java.designPatterns.abstractFactory.checkbox.GUIFactory;
import src.main.java.designPatterns.abstractFactory.concreteFactory.MacOSFactory;
import src.main.java.designPatterns.abstractFactory.concreteFactory.WindowsFactory;

public class AbstractFactoryClient {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static GUIFactory factory;
    public static void main(String[] args) throws Exception{
        System.out.println("Enter the OS type (MacOS/Windows) ?");
        String operatingSystem = reader.readLine();

        if(operatingSystem.equals("MacOS")) {
            factory = new MacOSFactory();
        }
        else if(operatingSystem.equals("Windows")) {
            factory = new WindowsFactory();
        }
        else {
            throw new Exception("Invalid OS chosen");
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.paint();
    }
}