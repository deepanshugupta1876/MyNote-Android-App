package deepanshu.example.com.mynote.models;

import java.text.DateFormat;

/**
 * Created by Deepanshu on 19-07-2018.
 */

public class Note {

    private String noteTitle;
    private String dateTime;
    private String noteSize;
    private String note;
    private int image;

    public Note(String noteTitle, String dateTime, String noteSize, String note, int image) {
        this.noteTitle = noteTitle;
        this.dateTime = dateTime;
        this.noteSize = noteSize;
        this.note = note;
        this.image = image;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getNoteSize() {
        return noteSize;
    }

    public void setNoteSize(String noteSize) {
        this.noteSize = noteSize;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
