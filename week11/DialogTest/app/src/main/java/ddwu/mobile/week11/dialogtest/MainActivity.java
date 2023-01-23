package ddwu.mobile.week11.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.MalformedInputException;

public class MainActivity extends AppCompatActivity {
    int selectedItem = 0;
    boolean[] selectedItems = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        final ConstraintLayout orderLayout = (ConstraintLayout)View.inflate(this, R.layout.order_layout,null);
        switch (v.getId()){
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("대화상자 제목")
//                .setMessage("대화상자 메시지")
//                        .setItems(R.array.foods, new DialogInterface.OnClickListener() { //목록 표시
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                Toast.makeText(MainActivity.this, foods[i], Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setSingleChoiceItems(R.array.foods, selectedItem, new DialogInterface.OnClickListener() { //라디오버튼
//                            @OverrideDialogInterface
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                selectedItem = i;
//                            }
//                        })
//                        .setMultiChoiceItems(R.array.foods, selectedItems, new .OnMultiChoiceClickListener() { //체크버튼
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i, boolean b) { //몇번쨰 항목이 어떤상태다(체크되었는지, 안되었는지) / 선택이 되면 true가 들어옴
//                                selectedItems[i] = b;
//                            }
//                        })
                        .setView(orderLayout) //dialog 직접 만들 수 있음
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton("확인버튼", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                String result = "";
//                                for(int idx=0; idx < foods.length; idx++){
//                                    if(selectedItems[idx]){
//                                        result += foods[idx] + " ";
//                                    }
//                                }
////                                String food = foods[selectedItem];
//
//                                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                                EditText etProduct = orderLayout.findViewById(R.id.etProduct);
                                String product = etProduct.getText().toString();
                                Toast.makeText(MainActivity.this, product, Toast.LENGTH_SHORT).show();


                            }
                        })
                        .setNeutralButton("대기버튼", null)
                        .setNegativeButton("취소버튼", null) // listener가 null이면 버튼 누르면 닫힘
                        .show();

//                Toast.makeText(this, "진행중!!!", Toast.LENGTH_SHORT).show();

//                Dialog dlg = builder.create();
//                dlg.setCanceledOnTouchOutside(false);
//                dlg.show();
//                builder.show();
                break;
        }
    }
}