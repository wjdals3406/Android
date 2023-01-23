package dduwcom.mobile.finalreport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    final int SRESULT_CODE = 500;
    MovieDBManager movieDBManager;
    EditText searchTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchTitle = findViewById(R.id.searchTitle);
        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search:
                Movie movie = movieDBManager.getMovieByTitle(searchTitle.getText().toString());
                if ( movie != null){
                    Intent intent = new Intent(this, SResultActivity.class);
                    intent.putExtra("movie", movie);
                    startActivityForResult(intent, SRESULT_CODE);
                }
                else{
                    Toast.makeText(this, "영화 정보가 없습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.search_cancel:   // 취소에 따른 처리
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }


}