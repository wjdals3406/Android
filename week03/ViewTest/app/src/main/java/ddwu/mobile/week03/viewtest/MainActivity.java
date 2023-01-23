package ddwu.mobile.week03.viewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //compat = compatable (호환성)
    EditText name, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        phone = findViewById(R.id.etPhone);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHello:
                String n_str = name.getText().toString();
                String p_str = phone.getText().toString();
                String print = "안녕하세요, 저는 " +  n_str + " 입니다.\n" + "전화번호는 " +  p_str + " 입니다.";
                Toast.makeText(this, print, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnExit:
                finish();
                break;

        }
    }
}