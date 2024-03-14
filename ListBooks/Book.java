package ListBooks;

public class Book implements Comparable<Book>{
    private String name;
    private int pageNum;
    private String date;
    private String authorName;

    public Book(String name, int pageNum, String date, String authorName) {
        this.name = name;
        this.pageNum = pageNum;
        this.date = date;
        this.authorName = authorName;
    }

    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
