package deepanshu.example.com.mynote.main.note_details;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import deepanshu.example.com.mynote.R;
import deepanshu.example.com.mynote.base.BasePresenter;
import deepanshu.example.com.mynote.base.BasePresenterActivity;

public class DetailNoteActivity extends BasePresenterActivity {

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return new DetailNotePresenter(new DetailNoteView(DetailNoteActivity.this,bus),
                new DetailNoteModel(bus));
    }


    @NonNull
    @Override
    protected int getLayout() {
        return R.layout.activity_detail_note;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
