package com.example.kainat.booksinfo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);


        final DBHelper dbHelper=new DBHelper(this);
        final EditText edtTitle= (EditText) findViewById(R.id.edtBookTitle);

        final EditText edtAuthor= (EditText) findViewById(R.id.edtBookAuthor);

        Button btnSave= (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edtTitle.getText().toString();
                String author=edtAuthor.getText().toString();
                long id=dbHelper.insertNewBook(title,author);
                if(id!=0)
                {
                    Toast.makeText(AddNewBookActivity.this,"Inserted sucessfully",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(AddNewBookActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
