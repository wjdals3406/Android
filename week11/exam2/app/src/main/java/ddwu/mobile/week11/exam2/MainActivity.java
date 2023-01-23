package ddwu.mobile.week11.exam2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;
    FoodManager foodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodManager = new FoodManager();
        foodList = foodManager.getFoodList();

        // Food 객체의 toString() 메소드가 호출되어 하나의 문자열로 처리됨
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                final int position = pos;
                String foodName = foodList.get(pos).getFood();
                //다이얼로그 생성 코드
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식 삭제")
                        .setMessage(foodName + "을(를) 삭제하시겠습니까?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) { //i는 dialog 목록의 순서를 의미
                                foodManager.removeData(position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null) // listener가 null이면 버튼 누르면 닫힘
                        .show();

                return false;
            }
        });

    }

    public void onClick(View v) {
        final ConstraintLayout orderLayout = (ConstraintLayout)View.inflate(this, R.layout.food_layout,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("음식 추가")
                .setView(orderLayout) //dialog 직접 만들 수 있음
                .setCancelable(false)
                .setPositiveButton("추가", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText text1 = orderLayout.findViewById(R.id.Text1);
                        EditText text2 = orderLayout.findViewById(R.id.Text2);
                        String strtext1 = text1.getText().toString();
                        String strtext2 = text2.getText().toString();
                        foodManager.addData(new Food(strtext1, strtext2));
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("취소", null) // listener가 null이면 버튼 누르면 닫힘
                .show();

    }
}