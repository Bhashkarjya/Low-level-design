package structural.composite;

import java.util.ArrayList;
import java.util.List;
public class Directory implements FileSystem {
    private String name;
    private List<FileSystem> filesystem;

    public Directory(String name) {
        this.name = name;
        filesystem = new ArrayList<>();
    }

    public void addNode(FileSystem node) {
        this.filesystem.add(node);
    }

    @Override
    public int getSize() {
        int total = 0;
        for(FileSystem node : this.filesystem) {
            total += node.getSize();
        }

        return total;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + " + " + this.name);
        for(FileSystem node : this.filesystem) {
            node.print(indent + " ");
        }
    }
}
