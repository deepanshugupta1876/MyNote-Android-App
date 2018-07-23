package deepanshu.example.com.mynote.main.master_note_details;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import deepanshu.example.com.mynote.R;
import deepanshu.example.com.mynote.adapter.MasterNoteRecyclerViewAdapter;
import deepanshu.example.com.mynote.main.note_details.DetailNoteActivity;
import deepanshu.example.com.mynote.models.Note;

public class MasterNoteActivity extends AppCompatActivity {
    private FloatingActionMenu floatingActionMenu;
    private FloatingActionButton reminder;
    private FloatingActionButton attachment;
    private FloatingActionButton camera;
    private FloatingActionButton handwriting;
    private FloatingActionButton textNote;
    private FloatingActionButton audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_master);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawer_icon_24dp);

        floatingActionButton();
        recyclerViewClass();
    }

    private void floatingActionButton(){
        floatingActionMenu = findViewById(R.id.menu_red);
        reminder = findViewById(R.id.reminder);
        attachment = findViewById(R.id.attachment);
        camera = findViewById(R.id.camera);
        handwriting = findViewById(R.id.handwriting);
        textNote = findViewById(R.id.text_note);
        audio = findViewById(R.id.audio);

        floatingActionMenu.setClosedOnTouchOutside(true);


        reminder.setOnClickListener(clickListener);
        attachment.setOnClickListener(clickListener);
        camera.setOnClickListener(clickListener);
        handwriting.setOnClickListener(clickListener);
        audio.setOnClickListener(clickListener);
        textNote.setOnClickListener(clickListener);

        floatingActionMenu.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (floatingActionMenu.isOpened()) {
                    Toast.makeText(getApplicationContext(), floatingActionMenu.getMenuButtonLabelText(), Toast.LENGTH_SHORT).show();
                }

                floatingActionMenu.toggle(true);
            }
        });
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.reminder:
                    break;
                case R.id.camera:
                    break;
                case R.id.attachment:
                    break;
                case R.id.audio:
                    break;
                case R.id.handwriting:
                    break;
                case R.id.text_note:
                    Intent textNoteIntent = new Intent(MasterNoteActivity.this, DetailNoteActivity.class);
                    startActivity(textNoteIntent);
                    break;
            }
        }
    };


    private void recyclerViewClass(){
        List<Note> notesList = new ArrayList<>();
        notesList.add(new Note("first note","19/07/2018","1kb","Hi my name is deepanshu gupta",2));
        notesList.add(new Note("second note","18/07/2018","4mb","Hi I am deepanshu gupta",2));
        notesList.add(new Note("third note","14/07/2018","2kb","Hi my current city is deepanshu gupta",2));
        notesList.add(new Note("forth note","10/07/2018","2mb","Hi my name is deepanshu gupta",2));
        notesList.add(new Note("fifth note","01/07/2018","12kb","Hi my name is deepanshu gupta",2));
        notesList.add(new Note("forth note","10/07/2018","2mb","Hi my name is deepanshu gupta",2));
        notesList.add(new Note("fifth note","01/07/2018","12kb","Hi my name is deepanshu gupta",2));


        RecyclerView recyclerView = findViewById(R.id.masternote_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MasterNoteRecyclerViewAdapter adapter = new MasterNoteRecyclerViewAdapter(notesList);
        recyclerView.setAdapter(adapter);


    }
}