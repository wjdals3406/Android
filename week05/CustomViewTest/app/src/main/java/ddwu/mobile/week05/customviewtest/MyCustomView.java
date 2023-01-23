package ddwu.mobile.week05.customviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCustomView extends View {

    int x, y, r;

    public MyCustomView(Context context) {
        super(context);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public int get_X() {
        return x;
    }

    public void set_X(int x) {
        this.x = x;
    }

    public int get_Y() {
        return y;
    }

    public void set_Y(int y) {
        this.y = y;
    }

    public int get_R() {
        return r;
    }

    public void set_R(int r) {
        this.r = r;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        Paint pnt = new Paint();
        pnt.setColor(Color.CYAN);
        canvas.drawCircle(get_X(), get_Y(), get_R(), pnt);
    }
}
