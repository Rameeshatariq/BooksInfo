package com.example.kainat.booksinfo;

/**
 * Created by kainat on 4/12/2018.
 */
public class BookModel {
    private int bookId;
    private String bookTitle;
    private String bookAuthor;

    public static final String TABLE_NAME="BooksTable";
    public static final String COLUMN1 = "bookId";
    public static final String COLUMN2 = "bookTitle";
    public static final String COLUMN3 = "bookAuthor";

    public static final String CREATE_BOOK_TABLE = "CREATE TABLE "+ TABLE_NAME+"("+
            COLUMN1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN2+" TEXT,"+COLUMN3+" TEXT)";

    public static final String DROP_BOOK_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    BookModel(int bookId, String bookTitle,String bookAuthor)
    {
        this.bookId=bookId;
        this.bookTitle=bookTitle;
        this.bookAuthor=bookAuthor;
    }
    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

}
