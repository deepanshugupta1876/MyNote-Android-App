package deepanshu.example.com.mynote.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import deepanshu.example.com.mynote.R;
import deepanshu.example.com.mynote.main.note_details.DetailNoteActivity;
import deepanshu.example.com.mynote.models.Note;

/**
 * Created by Deepanshu on 18-07-2018.
 */

public class MasterNoteRecyclerViewAdapter extends RecyclerView.Adapter<MasterNoteRecyclerViewAdapter.MasterNoteViewHolder> implements View.OnClickListener {

    private List<Note> notesArrayList;

    public MasterNoteRecyclerViewAdapter(List<Note> notesArrayList) {
        this.notesArrayList = notesArrayList;
    }

    class MasterNoteViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle;
        TextView noteDetails;
        ImageView contentImage;
        RelativeLayout masterRecyclerviewLayout;

        MasterNoteViewHolder(View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.note_title);
            noteDetails = itemView.findViewById(R.id.note_details);
            contentImage = itemView.findViewById(R.id.content_image);
            masterRecyclerviewLayout = itemView.findViewById(R.id.masternote_recyclerview_layout);
        }
    }

    @Override
    public MasterNoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.master_note_recyclerview_item,parent,false);
        return new MasterNoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MasterNoteViewHolder holder, int position) {
        Context context = holder.noteTitle.getContext();
        Note note = notesArrayList.get(position);
        holder.noteTitle.setText(note.getNoteTitle());
        int colorGreen = context.getColor(R.color.colorGreen);
        String text = context.getString(R.string.master_note_date_time,note.getDateTime()) + context.getString(R.string.master_note_note_size,note.getNoteSize());
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(colorGreen),0,text.length(),0);
        holder.noteDetails.setText(spannableString);
        holder.noteDetails.append(note.getNote());
        holder.masterRecyclerviewLayout.setOnClickListener(this);
        holder.masterRecyclerviewLayout.setTag(position);
    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), DetailNoteActivity.class);
        v.getContext().startActivity(intent);
    }
}