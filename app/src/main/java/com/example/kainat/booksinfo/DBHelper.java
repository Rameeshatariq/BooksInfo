package com.example.kainat.booksinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLDataException;
import java.util.ArrayList;

/**
 * Created by kainat on 4/12/2018.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static int DATABASE_VERSION=1;
    public static String DATABASE_NAME="BooksDB";

    public static String TABLE_NAME=BookModel.TABLE_NAME;

    public static String COLUMN1=BookModel.COLUMN1;
    public static String COLUMN2=BookModel.COLUMN2;
    public static String COLUMN3=BookModel.COLUMN3;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(BookModel.CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(BookModel.DROP_BOOK_TABLE);
    }

    public long insertNewBook(String title, String author)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(BookModel.COLUMN2,title);
        values.put(BookModel.COLUMN3,author);

        long rowID=db.insert(BookModel.TABLE_NAME,null,values);
        db.close();
        return rowID;

    }

    public ArrayList<BookModel> getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery = "SELECT  * FROM " + BookModel.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<BookModel> books = new ArrayList<>();
        // looping through all rows and adding to list



        if (cursor.moveToFirst()) {
            do {

                int id=cursor.getInt(cursor.getColumnIndex(BookModel.COLUMN1));
                String title=cursor.getString(cursor.getColumnIndex(BookModel.COLUMN2));
                String author=cursor.getString(cursor.getColumnIndex(BookModel.COLUMN3));

            books.add(new BookModel(id,title,author));

            } while (cursor.moveToNext());
        }
        db.close();
        return books;
    }
    public void deleteBook(BookModel book) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BookModel.TABLE_NAME, BookModel.COLUMN1 + " = ?",
                new String[]{String.valueOf(book.getBookId())});
        db.close();
    }


    public int updateBook(String title, String author, int bookid) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BookModel.COLUMN2, title);

        values.put(BookModel.COLUMN3, author);
        // updating row
        return db.update(BookModel.TABLE_NAME, values, BookModel.COLUMN1 + " = ?",
                new String[]{String.valueOf(bookid)});
    }
}
