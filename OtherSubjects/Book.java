package OtherSubjects;

import java.util.ArrayList;
import java.util.List;

public enum Book {
    BOOK1("Crime and Punishment","Fyodor Dostoevsky",672,1866),
    BOOK2("To Kill a Mockingbird","Harper Lee",336,1960),
    BOOK3("The Blind Owl","Sadegh Hedayat",208,1936),
    BOOK4("War and Peace","Leo Tolstoy",1392,1869),
    BOOK5("The Stranger","Albert Camus",158,1942),
    BOOK6("What Men Live By","Leo Tolstoy",80,1986),
    BOOK7("The Metamorphosis","Franz Kafka",112,1915),
    BOOK8("Harry Potter and the Philosopher's Stone","J.K. Rowling",320,1997),
    BOOK9("Brave New World","Aldous Huxley",288,1932),
    BOOK10("The Alchemist","Paulo Coelho",208,1988);
    private String bookName;
    private String authorName;
    private int pageNuM;
    private int date;
    private static ArrayList<Book> books = new ArrayList<>();
    Book(String bookName,String authorName,int pageNuM,int date){
        this.bookName = bookName;
        this.authorName = authorName;
        this.pageNuM = pageNuM;
        this.date = date;
    }
    private static void addBooks(){
        books.addAll(List.of(Book.values()));
    }
    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }
    public int getPageNuM() {
        return pageNuM;
    }

    public int getDate() {
        return date;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public static void main(String[] args) {
        Book.addBooks();
        Book.books.stream().map(i -> i.getBookName() + " - " + i.getAuthorName()).forEach(System.out::println);
        System.out.println("----------------------------");
        Book.books.stream().filter(i -> i.getPageNuM() > 100).forEach(i -> System.out.println(i.getBookName()));
    }
}
