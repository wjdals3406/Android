package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;
    FoodDBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etFood = findViewById(R.id.etAddFood);
        etNation = findViewById(R.id.etAddNation);
        dbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnAddFood:
                String foodName = etFood.getText().toString();
                String foodNation = etNation.getText().toString();

                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, foodName);
                row.put(FoodDBHelper.COL_NATION, foodNation);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.insert(FoodDBHelper.TABLE_NAME, null, row);

                dbHelper.close();
                break;

            case R.id.btnAddCancel:
                break;

        }
        finish();
    }

}
