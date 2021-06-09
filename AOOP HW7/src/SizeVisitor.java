public class SizeVisitor implements FilesVisitor {
    private int size = 0;
    public int getSize() {return size; }
    public void visit(DirectoryDetails file){}
    public void visit(DocxFileDetails file){size+= file.getSize();}
    public void visit(HtmlFileDetails file){size+= file.getSize();}
    public void visit(JpgFileDetails file){size+= file.getSize();}
    public void visit(Mp3FileDetails file){size+= file.getSize();}
    public void visit(PptxFileDetails file){size+= file.getSize();}
    public void visit(TxtFileDetails file){size+= file.getSize();}
}