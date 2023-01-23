package ddwu.mobile.week04.layouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setContentView(R.layout.activity_main); xml 설계도를 이용해 자바 객체로 바꿔서 화면에 보여줌, inflation 기능 내부에 존재 / 방법 1

//        LinearLayout linear = new LinearLayout(this); 방법 2
//        linear.setOrientation(LinearLayout.VERTICAL);
//        linear.setBackgroundColor(Color.LTGRAY);
//
//        TextView text = new TextView(this);
//        text.setText("TextView");
//        text.setGravity(Gravity.CENTER);
//        text.setTextColor(Color.RED);
//        text.setTextSize(20);
//
//        linear.addView(text);
//        setContentView(linear, LinearLayout); //화면 객체 직접 넣어줌

//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); //방법 3
//
//        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_main, null); //xml파일에서 자바 객체 만들어주는 역할 함
//        setContentView(layout);


//    public void onClick(View v) {
//        LinearLayout layout = findViewById(R.id.layout);
//        layout.setOrientation(LinearLayout.HORIZONTAL);
//        switch (layout.getOrientation()) {
//            case LinearLayout.HORIZONTAL:
//                layout.setOrientation(LinearLayout.VERTICAL);
//                break;
//            case LinearLayout.VERTICAL:
//                layout.setOrientation(LinearLayout.HORIZONTAL);
//                break;
//        }
//        //layout의 orientation 속성이 horizon인지 vertical인지 알아내서 horizon이면 vertical로 바꿈

//    }
    }

}