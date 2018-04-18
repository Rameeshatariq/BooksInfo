package com.example.kainat.booksinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);



        final DBHelper dbHelper=new DBHelper(this);
        final ArrayList<BookModel> books=dbHelper.getData();






        final EditText edtTitle= (EditText) findViewById(R.id.edtBookTitle);

        final EditText edtAuthor= (EditText) findViewById(R.id.edtBookAuthor);

        Button btnSave= (Button) findViewById(R.id.btnSave);




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edtTitle.getText().toString();
                String author=edtAuthor.getText().toString();

                Bundle extras = getIntent().getExtras();

                int bookid = (extras.getInt("book id"));





                long id=dbHelper.updateBook(title, author, bookid);
                if(id!=0)
                {
                    Toast.makeText(UpdateActivity.this,"Updated sucessfully",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(UpdateActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }




}
