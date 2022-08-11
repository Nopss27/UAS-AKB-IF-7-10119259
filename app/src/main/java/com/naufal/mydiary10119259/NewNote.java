package com.naufal.mydiary10119259;

/*
 * Naufal Daffa Ilyasa
 * 10119259
 * IF7*/

import java.util.ArrayList;
import java.util.Date;

public class NewNote {

    public static ArrayList<NewNote> noteArrayList = new ArrayList<>();
    public static String NOTE_EDIT_EXTRA = "noteEdit";

    private int id;
    private String title;
    private String description;

    public NewNote(int id, String title, String description, Date deleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deleted = deleted;
    }

    public NewNote(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        deleted = null;
    }

    public static NewNote getNoteForID(int passedNoteID) {

        for (NewNote note : noteArrayList) {
            if(note.getId() == passedNoteID)
                return note;
        }
        return null;
    }

    public static ArrayList<NewNote> nonDeletedNotes() {
        ArrayList<NewNote> nonDeleted = new ArrayList<>();
        for (NewNote note : noteArrayList) {
            if(note.getDeleted() == null)
                nonDeleted.add(note);
        }

        return nonDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    private Date deleted;


}
