package com.example.kainat.booksinfo;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView= (ListView) findViewById(R.id.listViewBook);
        Button btn=(Button)findViewById(R.id.AddNewButton);

        final DBHelper dbHelper=new DBHelper(this);

        final ArrayList<BookModel> books=dbHelper.getData();
        final BookAdapter bookAdapter=new BookAdapter(this,R.layout.book_layout_custom_row,books);
        listView.setAdapter(bookAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AddNewBookActivity.class);
                startActivity(i);
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dbHelper.deleteBook(books.get(position));

                books.remove(position);
                bookAdapter.notifyDataSetChanged();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {




                BookModel position = books.get(i);
                int id=position.getBookId();

                Intent ns=new Intent(MainActivity.this,UpdateActivity.class);
                ns.putExtra("book id",id);
                startActivity(ns);


            }
        });
    }
}
