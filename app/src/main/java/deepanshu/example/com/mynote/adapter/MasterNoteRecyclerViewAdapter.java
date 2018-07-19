package deepanshu.example.com.mynote.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import deepanshu.example.com.mynote.R;
import deepanshu.example.com.mynote.models.Notes;

/**
 * Created by Deepanshu on 18-07-2018.
 */

public class MasterNoteRecyclerViewAdapter extends RecyclerView.Adapter<MasterNoteRecyclerViewAdapter.MasterNoteViewHolder>{

    private ArrayList<Notes> notesArrayList;

    public MasterNoteRecyclerViewAdapter(ArrayList<Notes> notesArrayList) {
        this.notesArrayList = notesArrayList;
    }

    class MasterNoteViewHolder extends RecyclerView.ViewHolder {

        MasterNoteViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public MasterNoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.master_note_recyclerview_item,parent,false);
        return new MasterNoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MasterNoteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }
}