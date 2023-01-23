package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveActivity extends AppCompatActivity {
    EditText etRemoveFood;
    FoodDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        etRemoveFood = findViewById(R.id.etRemoveFood);
        dbHelper = new FoodDBHelper(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnRemoveFood:
                String foodName = etRemoveFood.getText().toString();
                String whereClause = "food=?";
                String[] whereArgs = new String[]{foodName};
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete (FoodDBHelper.TABLE_NAME, whereClause , whereArgs);
                dbHelper.close();
                break;

            case R.id.btnRemoveCancel:
                break;
        }
        finish();
    }

}
