package com.example.testingfundamentals;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class DetailsActivity extends ListActivity implements View.OnClickListener {

    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter adapter;
    EditText addTextEdit;
    Button saveButton, clearButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        addTextEdit = findViewById(R.id.add_text);
        saveButton = findViewById(R.id.save_text);
        clearButton = findViewById(R.id.clear_text);

        adapter = new ArrayAdapter(this, R.layout.text_container, list);

        saveButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        setListAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.save_text:
                String text = addTextEdit.getText().toString();
                list.add(text);
                addTextEdit.setText("");
                adapter.notifyDataSetChanged();
                break;
            case R.id.clear_text:
                adapter.clear();
                break;
        }


    }
}
