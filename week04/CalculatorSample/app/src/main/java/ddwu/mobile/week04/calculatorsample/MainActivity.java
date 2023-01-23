package ddwu.mobile.week04.calculatorsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etDisplay;
    Button btn_1, btn_2, btn_plus, btn_equal;
    int etDisplay_num_1;
    int etDisplay_num_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDisplay = findViewById(R.id.etDisplay);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_plus = findViewById(R.id.btn_plus);
        btn_equal = findViewById(R.id.btn_equal);
    }

    public void onClick(View v) {

//        String etDisplay_str = etDisplay.getText().toString(); //이 부분 수정할 필요 있음

        switch (v.getId()) {
            case R.id.btn_1:
                String btn_1_str = btn_1.getText().toString();
                etDisplay.setText(etDisplay.getText().toString() + btn_1_str);//toString으로 꼭 해야되나..?
                break;
            case R.id.btn_2:
                String btn_2_str = btn_2.getText().toString();

                etDisplay.setText(etDisplay.getText().toString() + btn_2_str);
                break;
            case R.id.btn_plus:
                String btn_plus_str = btn_plus.getText().toString();
                etDisplay_num_1 = Integer.parseInt(etDisplay.getText().toString());
                etDisplay.setText("");
                break;
            case R.id.btn_equal:
                String btn_equal_str = btn_equal.getText().toString();
                etDisplay_num_2 = Integer.parseInt(etDisplay.getText().toString());
                etDisplay.setText(Integer.toString(etDisplay_num_1 + etDisplay_num_2));
                break;
        }
    }


}