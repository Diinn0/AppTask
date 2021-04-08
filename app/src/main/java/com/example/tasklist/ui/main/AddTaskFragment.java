package com.example.tasklist.ui.main;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tasklist.R;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddTaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTaskFragment extends Fragment {

    private static PlaceholderFragment fragment0;

    public AddTaskFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddTask.
     */
    public static AddTaskFragment newInstance(PlaceholderFragment fragment0) {
        AddTaskFragment fragment = new AddTaskFragment();
        AddTaskFragment.fragment0 = fragment0;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_add_task, container, false);

        Button btn = (Button) root.findViewById(R.id.addButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String text = ((TextInputEditText) root.findViewById(R.id.textInputEditText)).getText().toString();

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                text += " " + dtf.format(now);
                Task task = new Task(text);

                AddTaskFragment.fragment0.getListAdapter().addItem(task);
                ((TextInputEditText) root.findViewById(R.id.textInputEditText)).getText().clear();

            }
        });

        return root;
    }
}