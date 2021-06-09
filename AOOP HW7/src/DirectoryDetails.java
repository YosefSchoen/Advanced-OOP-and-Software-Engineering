import java.util.ArrayList;


// TODO: Implement Composite (change this file).
public class DirectoryDetails extends FileDetails {
    public ArrayList<FileDetails> filesList = new ArrayList();

    public DirectoryDetails(String path, String name){
        super(path,name);
    }

    public void addFile(FileDetails fileDetails){
        // TODO: complete
        filesList.add(fileDetails);
    }

    public void accept(FilesVisitor filesVisitor){
        for(FileDetails f: filesList) {
            f.accept(filesVisitor);
        }

        filesVisitor.visit(this);
    }
}