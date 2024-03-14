package ListBooks;

import java.util.Comparator;
import java.util.TreeSet;

public class printBooks {
    public static void main(String[] args) {
        TreeSet<Book> books = new TreeSet<>();
        books.add(new Book("1984",328,"08-06-1949","George Orwell"));
        books.add(new Book("Harry Potter and the Philosopher's Stone",320,"26-06-1997","J.K.Rowling"));
        books.add(new Book("War and Peace",1200,"1869","Lev Tolstoy"));
        books.add(new Book("The Lord of the Rings: The Fellowship of the Ring",423,"29-07-1954","J.R.R.Tolkien"));
        books.add(new Book("The Catcher in the Rye",277,"16-07-1951","J.D.Salinger"));
        for(Book b : books){
            System.out.println(b.getName());
        }
        System.out.println("----------------------");
        TreeSet<Book> books2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNum() - o2.getPageNum();
            }
        });
        books2.addAll(books);
        for (Book b : books2){
            System.out.println(b.getName()+"-"+b.getPageNum());
        }
    }
}
