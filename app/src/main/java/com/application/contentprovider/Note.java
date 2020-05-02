package com.application.contentprovider;

public class Note {

    private String _id;
    private String _title;

    private String _dateOfCreation;


    public Note() {
    }

    public Note(String _title, String _dateOfCreation) {
        this._title = _title;

        this._dateOfCreation = _dateOfCreation;
    }

    public Note(String id, String title, String dateOfCreation) {
        this._id = id;
        this._title = title;
        this._dateOfCreation = dateOfCreation;

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }



    public String get_dateOfCreation() {
        return _dateOfCreation;
    }

    public void set_dateOfCreation(String _dateOfCreation) {
        this._dateOfCreation = _dateOfCreation;
    }


    @Override
    public String toString() {
        return "Notes{" +
                "_id=" + _id +
                ", _title='" + _title + '\'' +
                ", _dateOfCreation='" + _dateOfCreation + '\'' +
                '}';
    }
}

