package ddwu.mobile.week06.eventtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class one extends AppCompatActivity { //one 대신 mainactivity

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            Button button = findViewById(R.id.button);
            MyClick myClick = new MyClick(); // OnClickListener 기능 button에 연결해야함
            button.setOnClickListener(myClick);

        }

    class MyClick implements View.OnClickListener { //view가 가지고 있는 내부 클래스 이므로 View.OnClickListener을 사용/ 2.1(정석방법)
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Click!!", Toast.LENGTH_SHORT).show(); //this -> mainactivity 넣어야하므로 MainActivity.this, 그냥 this는 MyClick지칭
        }

    }
}
