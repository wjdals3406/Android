package ddwu.mobile.week10.customadaptertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MyData> myDataList; //원본데이터 보관
    private MyAdapter myAdapter;
    private ListView listView;
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myDataList = new ArrayList<MyData>();
//        myDataList.add(new MyData(1, "홍길동", "012345"));
//        myDataList.add(new MyData(2, "전우치", "123456"));
//        myDataList.add(new MyData(3, "일자매", "234567"));

        dataManager = new DataManager();
        myDataList = dataManager.getDataList();

        myAdapter = new MyAdapter(this, R.layout.custom_view_layout, myDataList);
        listView = (ListView)findViewById(R.id.customListView);
        listView.setAdapter(myAdapter);
        listView.setOnItemLongClickListener(longClickListener);
    }
    AdapterView.OnItemLongClickListener longClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            dataManager.removeData(i);
            myAdapter.notifyDataSetChanged();
            return false;
        }
    };

}