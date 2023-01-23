package ddwu.com.mobile.exam.mycircletest;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyCircle myCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Custom View 객체*/
        myCircle = findViewById(R.id.myCircle);
        registerForContextMenu( myCircle );
    }
    @Override //메뉴 생성 메소드
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.bigger:
                myCircle.setR(myCircle.getR() + 50);
                myCircle.invalidate();
                break;
            case R.id.smaller:
                myCircle.setR(myCircle.getR() - 50);
                myCircle.invalidate();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch(v.getId()){
            case R.id.myCircle:
                getMenuInflater().inflate(R.menu.circle_menu, menu);
                break;

        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.red:
                myCircle.setPaintColor(Color.RED);
                myCircle.invalidate();
                break;
            case R.id.green:
                myCircle.setPaintColor(Color.GREEN);
                myCircle.invalidate();
                break;
            case R.id.blue:
                myCircle.setPaintColor(Color.BLUE);
                myCircle.invalidate();
                break;
        }
        return true;
    }






}
