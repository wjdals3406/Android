package ddwu.mobile.week05.customviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    MyCustomView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = findViewById(R.id.CustomView);

//        MyView myView = new MyView(this);
//        setContentView(myView);
    }

    public void onClick(View v) {
        myView.set_X(random.nextInt(500));
        myView.set_Y(random.nextInt(800));
        myView.set_R((random.nextInt(3) + 1) * 100);
        myView.invalidate();
    }

//    class MyView extends View {
//        public MyView(Context context) {
//            super(context);
//        }
//
//        protected void onDraw(Canvas canvas){
//            super.onDraw(canvas);
//            canvas.drawColor(Color.YELLOW);
//            Paint pnt = new Paint();
//            pnt.setColor(Color.CYAN);
//        }

    //        @Override
//        public boolean onTouchEvent(MotionEvent event){
//
//        }
//    }


}