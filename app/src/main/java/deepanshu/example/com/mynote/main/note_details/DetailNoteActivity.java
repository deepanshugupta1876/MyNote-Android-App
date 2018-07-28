package deepanshu.example.com.mynote.main.note_details;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import deepanshu.example.com.mynote.R;
import deepanshu.example.com.mynote.base.BasePresenter;
import deepanshu.example.com.mynote.base.BasePresenterActivity;

public class DetailNoteActivity extends AppCompatActivity {

//    @NonNull
//    @Override
//    protected BasePresenter getPresenter() {
//        return new DetailNotePresenter(new DetailNoteView(DetailNoteActivity.this,bus),
//                new DetailNoteModel(bus));
//    }
//
//
//    @NonNull
//    @Override
//    protected int getLayout() {
//        return R.layout.activity_detail_note;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().getRoot().child("deepanshugupta1876@gmail_com").child("notes");
        myRef.setValue("My Name Is deepanshu");
    }
}
