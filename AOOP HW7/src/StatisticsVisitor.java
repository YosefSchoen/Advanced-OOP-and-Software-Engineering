public class StatisticsVisitor implements FilesVisitor{
    public void visit(DirectoryDetails file) {
        CountFilesVisitor folderSize = new CountFilesVisitor();
        file.accept(folderSize);
        int statistic = folderSize.getCount();
        System.out.println("Directory " + file.getName() + " has " + statistic + " files");
    }

    public void visit(DocxFileDetails file){
        double statistic = file.getWords() / file.getPages();
        System.out.println("The file" + file.getName()
                + " has an average of " + statistic + " words per page");
    }

    public void visit(HtmlFileDetails file){
        int statistic = file.getLines();
        System.out.println("The file " + file.getName()
                + " contains " + statistic + " lines");
    }

    public void visit(JpgFileDetails file){
        double statistic = (double)file.getSize() / (file.getWidth()*file.getHeight());
        System.out.println("The picture " + file.getName()
                + " has an average of " + statistic + " bits per pixel");
    }

    public void visit(Mp3FileDetails file){
        double statistic = file.getSize() / file.getLengthSec();
        System.out.println("The bitrate of " + file.getName()
                + " is " + statistic + " bits per second");

    }
    public void visit(PptxFileDetails file){
        double statistic = file.getSize() / file.getSlides();
        System.out.println("The average slide size in " + file.getName()
                + " is" + statistic);
    }

    public void visit(TxtFileDetails file){
        int statistic = file.getWords();
        System.out.println("The file " + file.getName()
                + " contains " + statistic + " words");
    }
}