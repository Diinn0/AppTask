package com.example.tasklist.ui.main;

public class Task {

    private String text;
    private boolean isChecked = false;

    public Task(String text) {
        this.text = text;
    }

    public void toggleCheck() {
        this.isChecked = !isChecked;
    }

    public String getText() {
        return this.text;
    }

    public boolean isChecked() {
        return isChecked;
    }
}
