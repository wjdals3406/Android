package ddwu.mobile.week09.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DataManager dataManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayList<String> subjectList = new ArrayList<String>();
//        subjectList.add("모바일소트웨어");
//        subjectList.add("네트워크");
//        subjectList.add("웹서비스");
//        subjectList.add("운영체제");
//        subjectList.add("웹프로그래밍2"); -> DataManger에서 해줌
        dataManager = new DataManager();
        subjectList = dataManager.getSubjectList(); //list만들고 list 반환

        adapter =
                new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, subjectList);
        // android.R.layout.simple_list_item_1는 android에 내장되어 있는 layout
        // subjectList에 요소가 5개 이므로 5개의 화면 만들어줌

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);// adapter와 listView(adapterview)에 연결
        listView.setOnItemClickListener(itemClickListener);
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        //View view : 네트워크, 웹서비스 한줄 한줄

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
            Toast.makeText(MainActivity.this, subjectList.get(pos), Toast.LENGTH_SHORT).show();
//            dataManager.removeData(pos);
//            adapter.notifyDataSetChanged();
        }
    };

}