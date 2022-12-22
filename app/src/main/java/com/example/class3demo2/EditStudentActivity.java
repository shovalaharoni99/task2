package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

public class EditStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText name;
        EditText id;
        EditText address;
        EditText phone;
        CheckBox cb;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        name = findViewById(R.id.editstudent_name_et);
        id = findViewById(R.id.editstudent_id_et);
        phone = findViewById(R.id.editstudent_phone_et);
        address = findViewById(R.id.editstudent_address_et);
        cb = findViewById(R.id.student_checkBox);
        Button saveBtn = findViewById(R.id.student_save_btn);
        Button deleteBtn = findViewById(R.id.student_delete_btn);
        Button cancelBtn = findViewById(R.id.student_cancel_btn);

        Bundle b = getIntent().getExtras();
        int value = -1; // or other values
        if(b != null)
            value = b.getInt("pos");
        Log.d("TAG", "Row was clicked " + value);
        Student st = Model.instance().getStudent(value);
        name.setText(st.name);
        id.setText(st.id);
        address.setText(st.address);
        phone.setText(st.phone);
        cb.setChecked(st.cb);

        cancelBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this,StudentRecyclerList.class);
            startActivity(intent);
        });

        int pos = value;
        deleteBtn.setOnClickListener(view -> {
            Model.instance().deleteStudent(pos);
            Intent intent = new Intent(this,StudentRecyclerList.class);
            startActivity(intent);
        });


        EditText nameEt = findViewById(R.id.editstudent_name_et);
        EditText idEt = findViewById(R.id.editstudent_id_et);
        EditText addressEt = findViewById(R.id.editstudent_address_et);
        EditText phoneEt = findViewById(R.id.editstudent_phone_et);
        CheckBox cbEt = findViewById(R.id.student_checkBox);
        String avatarUrl = "app/src/main/res/drawable-v24/avatar.png";


        saveBtn.setOnClickListener(view -> {
            Model.instance().deleteStudent(pos);
            Student editst = new Student(nameEt.getText().toString(),idEt.getText().toString(),avatarUrl,
                    cbEt.isChecked(),phoneEt.getText().toString(),addressEt.getText().toString());
            Model.instance().addStudentInPos(editst,pos);

            Intent intent = new Intent(this,StudentRecyclerList.class);
            startActivity(intent);

        });
    }
}