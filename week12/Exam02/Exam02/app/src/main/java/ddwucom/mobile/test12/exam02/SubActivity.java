package ddwucom.mobile.test12.exam02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                Intent resultIntent = new Intent();
                String food = etFood.getText().toString();
                String nation = etNation.getText().toString();
                resultIntent.putExtra("food", new Food(food, nation));
                setResult(RESULT_OK, resultIntent);
                break;
        }
        finish();
        //입력한 음식과 나라명 돌려주기 -> 객체 넣어주기
//        버튼의 종류에 따라 결과 설정 후 finish()

    }
}

