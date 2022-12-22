package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText nameEt = findViewById(R.id.addstudent_name_et);
        EditText idEt = findViewById(R.id.addstudent_id_et);
        EditText addressEt = findViewById(R.id.addstudent_address_et);
        EditText phoneEt = findViewById(R.id.addstudent_phone_et);
        CheckBox cb = findViewById(R.id.addstudent_checkBox);
        String avatarUrl = "app/src/main/res/drawable-v24/avatar.png";
        Button saveBtn = findViewById(R.id.student_save_btn);
        Button cancelBtn = findViewById(R.id.student_cancel_btn);

        saveBtn.setOnClickListener(view -> {
            Student st = new Student(nameEt.getText().toString(),idEt.getText().toString(),avatarUrl,
                    cb.isChecked(),phoneEt.getText().toString(),addressEt.getText().toString());
            Model.instance().addStudent(st);

            Intent intent = new Intent(this,StudentRecyclerList.class);
            startActivity(intent);

        });

        cancelBtn.setOnClickListener(view -> finish());
    }
}