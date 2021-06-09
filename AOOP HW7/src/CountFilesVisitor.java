public class CountFilesVisitor implements FilesVisitor{
    private int count = 0;
    public int getCount() { return count; }
    public void visit(DirectoryDetails file) {}
    public void visit(DocxFileDetails file){count ++; }
    public void visit(HtmlFileDetails file){ count++; }
    public void visit(JpgFileDetails file){ count++; }
    public void visit(Mp3FileDetails file){ count++; }
    public void visit(PptxFileDetails file){ count++; }
    public void visit(TxtFileDetails file){ count++; }
}
