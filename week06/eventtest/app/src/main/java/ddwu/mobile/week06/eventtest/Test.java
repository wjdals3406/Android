package ddwu.mobile.week06.eventtest;

import android.view.MotionEvent;
import android.view.View;

public class Test {

    View.OnTouchListener myTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            motionEvent.getAction() == MotionEvent.ACTION_DOWN;

            motionEvent.getX();

            return false;
        }
    }
}
