package ddwu.mobile.week06.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String p_str = editText.getText().toString();
            Toast.makeText(MainActivity.this, "Click!!", Toast.LENGTH_SHORT).show(); //this -> mainactivity 넣어야함
        }

    }


}