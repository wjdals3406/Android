package ddwu.mobile.week06.eventtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        textView.setOnLongClickListener(longClick);

//        Button button = findViewById(R.id.button);
//        MyClick myClick = new MyClick(); // OnClickListener 기능 button에 연결해야함
//        button.setOnClickListener(myClick);
//        button.setOnClickListener(myInterfaceClick); //1)
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Interface Click!!", Toast.LENGTH_SHORT).show();
//
//            }
//        }); // 2), 1대신 setOnClickListener안에 직접 넣을 수 있음
    }

    View.OnLongClickListener longClick = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view){
            textView.setText("Mobile Software");
            return true;
        }
    };
    //원래는 interface에서 객체 만들 수 없으나, interface의 메소드를 채워 넣으면 객체 만들 수 있음 -> java에서 지원
//    View.OnClickListener myInterfaceClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(MainActivity.this, "Interface Click!!", Toast.LENGTH_SHORT).show();
//
//        }
//    };

//    class MyClick implements View.OnClickListener { //view가 가지고 있는 내부 클래스 이므로 View.OnClickListener을 사용/ 2.1(정석방법)
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(MainActivity.this, "Click!!", Toast.LENGTH_SHORT).show(); //this -> mainactivity 넣어야하므로 MainActivity.this, 그냥 this는 MyClick지칭
//        }
//
//    }

//    class LongClick implements View.OnLongClickListener {
//
//        @Override
//        public boolean onLongClick(View view) {
//            return false; // true이면 longclick은 여기서 끝, false이면 longclick을 처리할 수 있는 부분이 다른 곳에서도 존재하기에 계속 봐야한다는 뜻
//        }
//    }

    View.OnTouchListener myTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            motionEvent.getAction() == MotionEvent.ACTION_DOWN;
            motionEvent.getX(); //터치한 위치에서의 좌표 얻을 수 있음

            return false;
        }
    };
}