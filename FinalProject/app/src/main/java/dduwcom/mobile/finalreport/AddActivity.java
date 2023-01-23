package dduwcom.mobile.finalreport;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    MovieDBManager movieDBManager;
    EditText etTitle;
    EditText etGenre;
    EditText etRating;
    EditText add_director;
    EditText add_actor;
    EditText add_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etTitle = findViewById(R.id.add_title);
        etGenre = findViewById(R.id.add_genre);
        etRating = findViewById(R.id.add_rating);
        add_director = findViewById(R.id.add_director);
        add_actor = findViewById(R.id.add_actor);
        add_date = findViewById(R.id.add_date);
        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                if (etTitle.getText().toString().equals("") || etGenre.getText().toString().equals("") ||
                        etRating.getText().toString().equals("") || add_director.getText().toString().equals("") ||
                        add_actor.getText().toString().equals("") || add_date.getText().toString().equals("")) {
                    Toast.makeText(this, "필수 정보를 모두 입력하세요!", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean result = movieDBManager.addNewMovie(
                            new Movie(etTitle.getText().toString(), etGenre.getText().toString(), etRating.getText().toString(),
                                    R.mipmap.kakao, add_director.getText().toString(), add_actor.getText().toString(), add_date.getText().toString())
                    );
                    if (result) {    // 정상수행에 따른 처리
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie", etTitle.getText().toString() );
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    } else {        // 이상에 따른 처리
                        Toast.makeText(this, "추가 실패!", Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.add_cancel:   // 취소에 따른 처리
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}