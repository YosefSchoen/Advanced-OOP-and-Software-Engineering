public interface FilesVisitor {
    void visit(DirectoryDetails file);
    void visit(DocxFileDetails file);
    void visit(HtmlFileDetails file);
    void visit(JpgFileDetails file);
    void visit(Mp3FileDetails file);
    void visit(PptxFileDetails file);
    void visit(TxtFileDetails file);
}
