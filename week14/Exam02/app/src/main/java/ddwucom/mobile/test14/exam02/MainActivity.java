package ddwucom.mobile.test14.exam02;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList = null;
    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodList = new ArrayList<Food>();
        adapter = new ArrayAdapter<Food>(this, android.R.layout.simple_list_item_1, foodList);
        listView.setAdapter(adapter);
        foodDBManager = new FoodDBManager(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Food food = foodList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("food", food);
                startActivityForResult(intent, UPDATE_CODE);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title)
                        .setMessage(R.string.dialog_message)
                        .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                deleteRecord(pos);
                                if (foodDBManager.removeFood(foodList.get(pos).get_id())) {
                                    Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT);
                                    foodList.clear();
                                    foodList.addAll(foodDBManager.getAllFood());
                                    adapter.notifyDataSetChanged();
                                }else {
                                    Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.dialog_cancel, null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });
    }

    private void deleteRecord(int pos){
        FoodDBHelper foodDBHelper = new FoodDBHelper(this);
        SQLiteDatabase sqLiteDatabase = foodDBHelper.getWritableDatabase();
        String whereClause = FoodDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(foodList.get(pos).get_id())}; //id는 long타입이라 String으로 바꿔줘야 함
        int result = sqLiteDatabase.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);
        if (result > 0) {
            Toast.makeText(this, "삭제 완료", Toast.LENGTH_SHORT);
            foodList.clear();
            foodList.addAll(foodDBManager.getAllFood());
            adapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "삭제 실패", Toast.LENGTH_SHORT).show();
        }

        foodDBHelper.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        foodList.clear();
        foodList.addAll(foodDBManager.getAllFood());
        adapter.notifyDataSetChanged();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {  // AddActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    String food = data.getStringExtra("food");
                    Toast.makeText(this, food + " 추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (requestCode == UPDATE_CODE) {    // UpdateActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "음식 수정 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 수정 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
