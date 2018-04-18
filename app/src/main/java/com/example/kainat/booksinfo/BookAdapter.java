package com.example.kainat.booksinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kainat on 4/12/2018.
 */
public class BookAdapter extends ArrayAdapter<BookModel> {
    ArrayList<BookModel> data;
    Context mContext;
    private static LayoutInflater inflater=null;

    private static class ViewHolder {
        TextView txtTitle;
        TextView txtAuthor;
    }
    public BookAdapter(Context context, int resource, ArrayList<BookModel> list) {
        super(context, resource, list);
        this.data = list;
        this.mContext=context;
        inflater = (LayoutInflater)mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=new ViewHolder();
        View rowView;
        rowView = inflater.inflate(R.layout.book_layout_custom_row,null);

        BookModel bookModel=getItem(position);
        holder.txtTitle=(TextView) rowView.findViewById(R.id.txtTitle);
        holder.txtAuthor=(TextView) rowView.findViewById(R.id.txtAuthor);
        holder.txtTitle.setText(bookModel.getBookTitle());
        holder.txtAuthor.setText(bookModel.getBookAuthor());

        return rowView;
    }
}
