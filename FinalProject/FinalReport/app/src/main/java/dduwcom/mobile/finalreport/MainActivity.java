package dduwcom.mobile.finalreport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;
    final int SEARCH_CODE = 300;
    ListView listView;
    ArrayList<Movie> movieList = new ArrayList<Movie>();
    MovieDBManager movieDBManager;
    private MyAdapter myAdapter;
    MovieDBHelper movieDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.customListView);
        myAdapter = new MyAdapter(this, R.layout.custom_layout, movieList);
        listView.setAdapter(myAdapter);
        movieDBManager = new MovieDBManager(this);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String MovieName = movieList.get(pos).getMovieName();
                builder.setTitle("영화목록 삭제")
                        .setMessage(MovieName + "을(를) 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                deleteRecord(pos);
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Movie movie = movieList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("movie", movie);
                startActivityForResult(intent, UPDATE_CODE);
            }
        });
    }

    private void deleteRecord(int pos){
        MovieDBHelper movieDBHelper = new MovieDBHelper(this);
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(movieList.get(pos).get_id())}; //id는 long타입이라 String으로 바꿔줘야 함
        int result = sqLiteDatabase.delete(MovieDBHelper.TABLE_NAME, whereClause, whereArgs);
        if (result > 0) {
            Toast.makeText(this, "삭제 완료", Toast.LENGTH_SHORT);
            movieList.clear();
            movieList.addAll(movieDBManager.getAllFood());
            myAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "삭제 실패", Toast.LENGTH_SHORT).show();
        }

        movieDBHelper.close();
    }
    @Override
    protected void onResume() {
        super.onResume();
        movieList.clear();
        movieList.addAll(movieDBManager.getAllFood());
        myAdapter.notifyDataSetChanged();
    }

    @Override //메뉴 생성 메소드
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.addressAdd:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);

                break;
            case R.id.intro:
                final ConstraintLayout orderLayout = (ConstraintLayout)View.inflate(this, R.layout.introduce,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("개발자 소개")
                        .setView(orderLayout)
                        .setPositiveButton("확인", null)
                        .setCancelable(false)
                        .show();
                break;
            case R.id.exitApp:
                AlertDialog.Builder builders = new AlertDialog.Builder(MainActivity.this);
                builders.setTitle("앱 종료")
                        .setMessage("앱을 종료하시겠습니까?")
                        .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                break;

            case R.id.titleSearch:
                Intent sintent = new Intent(this, SearchActivity.class);
                startActivityForResult(sintent, SEARCH_CODE);

                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {  // AddActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    String movie = data.getStringExtra("movie");
                    Toast.makeText(this, movie + " 추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (requestCode == UPDATE_CODE) {    // UpdateActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "수정 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "수정 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    // 과제명: 영화 정보 관리 앱
    // 분반: 02 분반
    // 학번: 20191076 성명 : 진정민
    // 제출일: 2022년 6월 22일
}
