package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
        myDbHelper = new FoodDBHelper(this);
    }


    public void onClick(View v) {
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        switch(v.getId()) {
            case R.id.btnSelect:

                //select * from FoodDBHelper.TABLE_NAME;
                Cursor cursor = db.query(FoodDBHelper.TABLE_NAME,  null, null,
                        null, null, null, null, null);

                String result = "";
                ArrayList<Food> list = new ArrayList<>();
                while (cursor.moveToNext()) {
                    long id = cursor.getInt(cursor.getColumnIndex( FoodDBHelper.COL_ID));
                    String foodName = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
                    String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));
                    Food food = new Food(id, foodName, nation);
                    result += food.toString() + "\n";
                    list.add(food);
                }
                tvDisplay.setText(result);
                cursor.close();
                myDbHelper.close();
                break;
            case R.id.btnAdd:
                Intent addIntent = new Intent(this, AddActivity.class);
                startActivity(addIntent);
                break;

            case R.id.btnUpdate:
                Intent updateIntent = new Intent(this, UpdateActivity.class);
                startActivity(updateIntent); //startActivityForResult가 아니라 startActivity인 이유 찾아보기 ->12주차랑 비교해보기
                break;

            case R.id.btnRemove:
                Intent removeIntent = new Intent(this, RemoveActivity.class);
                startActivity(removeIntent);
                break;
        }

        myDbHelper.close();
    }

}
