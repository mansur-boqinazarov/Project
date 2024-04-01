package user;

import com.sun.source.tree.LambdaExpressionTree;
import type.Role;

public class BookService {

    private int countBook;
    private Book[]books;
    public BookService (int size) {
        this.books = new Book[size];
        books[0] = new Book("Hamsa","Alisher Navoiy",10);
        books[1] = new Book("O'tgan kunlar","Abdulla Qodiriy",10);
        this.countBook = 2;
    }


    public int getCountBook() {
        return countBook;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }


    public Book getBooks(int ind) {
        return books[ind];
    }

    public void setBooks(Book book) {
        this.books[countBook++] = book;
    }

    public String  showBookList() {
        String str  = "";
        for (int i = 0; i < countBook; i++) {
            Book book = books[i];
            str+=(i+1) + ". " + book.getName() + "  |  " + book.getAuthor() + "  |  " + book.getCount() + "\n";
        }
        return str;
    }


    public String addBook(String name, String author, int count) {
        Book book = new Book(name,author,count);
        setBooks(book);
        return "Added";
    }

    public String deleteBook(int ind) {
        books[ind] = null;
        Book[] newBooks = new Book[books.length];
        int k = 0;
        for (int i = 0; i < countBook; i++) {
            if (books[i] != null){
                newBooks[k++] = books[i];
            }
        }
        books = newBooks;
        countBook--;
        return "  Deleted successfully ✔";
    }
}
