package top.yokey.miuidialog;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

@SuppressWarnings("ALL")
public class MiuiLineDecoration extends RecyclerView.ItemDecoration {

    private int height;
    private Paint paint;
    private boolean edag;

    public MiuiLineDecoration(int height, int color, boolean edag) {

        this.height = height;
        this.paint = new Paint();
        this.edag = edag;
        paint.setColor(color);

    }

    @Override
    public void getItemOffsets(Rect rect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(rect, view, parent, state);
        if (edag) {
            rect.bottom = height;
            if (parent.getChildAdapterPosition(view) == 0) {
                rect.top = height;
            }
        } else {
            rect.bottom = height;
            if (parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1) {
                rect.bottom = 0;
            }
        }
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {

        int count = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 0; i < count - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + height;
            canvas.drawRect(left, top, right, bottom, paint);
        }

    }

}
