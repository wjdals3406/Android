package ddwu.mobile.week06.eventtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Two extends AppCompatActivity implements View.OnClickListener{ //Two 대신 mainactivity여야함
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Click!!", Toast.LENGTH_SHORT).show(); //this -> mainactivity 넣어야하므로 MainActivity.this, 그냥 this는 MyClick지칭
    }
}
