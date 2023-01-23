package ddwu.mobile.week06.eventtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Thre extends AppCompatActivity {
        class MyView extends View implements View.OnClickListener{
            public MyView(Context context) {
                super(context);
            }

            protected void onDraw(Canvas canvas){
                super.onDraw(canvas);
                canvas.drawColor(Color.YELLOW);
                Paint pnt = new Paint();
                pnt.setColor(Color.CYAN);
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click!!", Toast.LENGTH_SHORT).show(); //this -> mainactivity 넣어야하므로 MainActivity.this, 그냥 this는 MyClick지칭
            }
    }
}
