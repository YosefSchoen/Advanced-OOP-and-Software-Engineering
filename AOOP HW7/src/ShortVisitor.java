public class ShortVisitor implements FilesVisitor{
    public void visit(DirectoryDetails file) { System.out.println(file.getName()); }
    public void visit(DocxFileDetails file) { System.out.println(file.getName()); }
    public void visit(HtmlFileDetails file) { System.out.println(file.getName()); }
    public void visit(JpgFileDetails file) { System.out.println(file.getName()); }
    public void visit(Mp3FileDetails file) { System.out.println(file.getName()); }
    public void visit(PptxFileDetails file){ System.out.println(file.getName()); }
    public void visit(TxtFileDetails file) { System.out.println(file.getName()); }
}
