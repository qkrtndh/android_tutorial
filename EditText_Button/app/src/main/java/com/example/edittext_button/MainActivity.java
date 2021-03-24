package com.example.edittext_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        //아이디를 통해 불러옴
        btn_test = findViewById(R.id.btn_test);

        //버튼 클릭시의 처리
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼의 텍스트를 edittext 의 글씨를 가져와서 버튼의 글자로 지정
                btn_test.setText(et_id.getText());

                //edittext창의 글자를 바꿈
               et_id.setText("입력됨");
            }
        });

    }

}