package structural.composite;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory home = new Directory("home");
        Directory user = new Directory("user");

        File file1 = new File("resume.pdf", 30);
        File file2 = new File("passport.jpg", 20);

        user.addNode(file1);
        user.addNode(file2);
        home.addNode(user);
        root.addNode(home);

        System.out.println("Size of root : " + root.getSize());
        System.out.println("Contents of the root directory");
        root.print(" ");
    }
}
