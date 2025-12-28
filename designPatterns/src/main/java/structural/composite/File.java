package structural.composite;

public class File implements FileSystem{
    private String filename;
    private int size;

    public File(String name, int size) {
        this.filename = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + " - " + this.filename + " (" + this.size + " KB)");
    }
}
