package dduwcom.mobile.finalreport;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SResultActivity extends AppCompatActivity {
    Movie movie;
    MovieDBManager movieDBManager;
    EditText etTitle;
    EditText etGenre;
    EditText etRating;
    EditText director;
    EditText actor;
    EditText date;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sresult);
        movie = (Movie) getIntent().getSerializableExtra("movie");
        etTitle = findViewById(R.id.stitle);
        etGenre = findViewById(R.id.sgenre);
        etRating = findViewById(R.id.srating);
        director = findViewById(R.id.sdirector);
        actor = findViewById(R.id.sactor);
        date = findViewById(R.id.sdate);
        img = findViewById(R.id.simg);

        etTitle.setText(movie.getMovieName());
        etGenre.setText(movie.getGenre());
        etRating.setText(movie.getRating());
        director.setText(movie.getDirector());
        actor.setText(movie.getActor());
        date.setText(movie.getDate());
        img.setImageResource(movie.getImgIcon());
        movieDBManager = new MovieDBManager(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_ok:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }

    }

}