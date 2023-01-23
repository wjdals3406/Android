package dduwcom.mobile.finalreport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    Movie movie;
    MovieDBManager movieDBManager;
    EditText etTitle;
    EditText etGenre;
    EditText etRating;
    EditText update_director;
    EditText update_actor;
    EditText update_date;
    ImageView update_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        movie = (Movie) getIntent().getSerializableExtra("movie");
        etTitle = findViewById(R.id.update_title);
        etGenre = findViewById(R.id.update_genre);
        etRating = findViewById(R.id.update_rating);
        update_director = findViewById(R.id.update_director);
        update_actor = findViewById(R.id.update_actor);
        update_date = findViewById(R.id.update_date);
        update_img = findViewById(R.id.update_img);

        etTitle.setHint(movie.getMovieName());
        etGenre.setHint(movie.getGenre());
        etRating.setHint(movie.getRating());
        update_director.setHint(movie.getDirector());
        update_actor.setHint(movie.getActor());
        update_date.setHint(movie.getDate());
        update_img.setImageResource(movie.getImgIcon());

        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                movie.setMovieName(etTitle.getText().toString());
                movie.setGenre(etGenre.getText().toString());
                movie.setRating(etRating.getText().toString());
                movie.setDirector(update_director.getText().toString());
                movie.setActor(update_actor.getText().toString());
                movie.setDate(update_date.getText().toString());

                if (etTitle.getText().toString().equals("") || etGenre.getText().toString().equals("") ||
                        etRating.getText().toString().equals("") || update_director.getText().toString().equals("") ||
                        update_actor.getText().toString().equals("") || update_date.getText().toString().equals("")) {
                    Toast.makeText(this, "필수 정보를 모두 입력하세요!", Toast.LENGTH_SHORT).show();

                }
                else{
                    if (movieDBManager.modifyMovie(movie)){
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie", movie);
                        setResult(RESULT_OK, resultIntent);
                    } else {
                        setResult(RESULT_CANCELED);
                    }
                }

                break;
            case R.id.update_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
        finish();
    }
}