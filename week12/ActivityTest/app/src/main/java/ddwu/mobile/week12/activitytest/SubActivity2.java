package ddwu.mobile.week12.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        TextView textView = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String data = intent.getStringExtra("subject");

        textView.setText(data);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.sub_button_click:
                Intent resultIntent = new Intent(); //결과를 담기 위한 intent 생성
                resultIntent.putExtra("result_data", "SubActivity returns data");
                setResult(RESULT_OK, resultIntent);
                break;
            case R.id.sub_button_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish(); // 이때 result 반환됨
    }
}