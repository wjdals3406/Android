package ddwu.mobile.week06.eventtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Four {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(myInterfaceClick);

    }

    //원래는 interface에서 객체 만들 수 없으나, interface의 메소드를 채워 넣으면 객체 만들 수 있음 -> java에서 지원
    //객체 만드는 시점에 메소드 채움
    View.OnClickListener myInterfaceClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Interface Click!!", Toast.LENGTH_SHORT).show();

        }
    };


}
