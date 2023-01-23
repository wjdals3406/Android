package ddwu.mobile.week07.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean checkStatus[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        registerForContextMenu( textView );

        checkStatus = new boolean[] {true, false};

    }
    @Override //메뉴 생성 메소드
    public boolean onCreateOptionsMenu(Menu menu) { //받은 menu는 빈 메뉴 -> 메소드로 메뉴를 채워야 함

//        MenuInflater menuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.subItem02:
//                Toast.makeText(this, "sub02 Click", Toast.LENGTH_SHORT).show();
                if (item.isChecked()){ //item이 체크되어 있는지 확인, 체크되어 있으면 체크 풀어줘야 함
                    item.setChecked(false);
//                    checkStatus[0] = false;
                } else {
                    item.setChecked(true);
//                    checkStatus[0] = true;
                }
                break;

//            case R.id.subItem02:
//                break;

        }
        return true;
    }

    public void onMenuClick(MenuItem item){ //매개변수가 view가 아니라 item이 들어옴
        Toast.makeText(this, "sub01 Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch(v.getId()){
            case R.id.textView:
                getMenuInflater().inflate(R.menu.activity_menu, menu);
                break;

        }
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        menu.removeItem(R.id.item01);
//        MenuItem item = menu.findItem(R.id.item01);
//        item.setTitle(R.string.app_name); -> subitem에서 app_name(menutest)로 title이름 바꿀 수 있음
////        menu.clear();
//        return true;
//    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.subItem01:
                Toast.makeText(this, "Context Click", Toast.LENGTH_SHORT).show();


        }
        return true;
    }



   
}