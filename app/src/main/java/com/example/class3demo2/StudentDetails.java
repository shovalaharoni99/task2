package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView name;
        TextView id;
        TextView address;
        TextView phone;
        CheckBox cb;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        name = findViewById(R.id.student_details_name);
        id = findViewById(R.id.student_details_id);
        phone = findViewById(R.id.student_details_phone);
        address = findViewById(R.id.student_details_address);
        cb = findViewById(R.id.student_checkBox);
        Button editBtn = findViewById(R.id.student_cancel_btn);

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

        editBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this,EditStudentActivity.class);
            intent.putExtras(b);
            startActivity(intent);
        });
    }


}