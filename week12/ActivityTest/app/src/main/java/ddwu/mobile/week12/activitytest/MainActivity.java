package ddwu.mobile.week12.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.button:
////                Intent intent = new Intent(this, SubActivity.class);
////                startActivity(intent);
                Intent intent = new Intent(this, SubActivity2.class);
                intent.putExtra("subject", "mobile software");
                startActivity(intent);
                startActivityForResult(intent, REQ_CODE);

//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:012-3456-7890"));
//                startActivity(intent);

                break;
        }
    }

    @Override //requestCode : REQ_CODE, resultCode : RESULT_OK/RESULT_CANCELED
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch(requestCode) {
            case REQ_CODE:
                if (resultCode == RESULT_OK) {
                    String resultData = data.getStringExtra("result_data");
                    Toast.makeText(this, "Result: " + resultData, Toast.LENGTH_SHORT).show();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}