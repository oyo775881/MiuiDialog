package top.yokey.miuidialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.widget.AppCompatTextView;

@SuppressWarnings("ALL")
public class MiuiLoadDialog {

    private Dialog dialog;
    private Context context;
    private boolean cancelable;
    private String content;

    public MiuiLoadDialog(Context context) {
        this.context = context;
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void show() {
        dialog = dialog = new Dialog(context);
        dialog.setContentView(R.layout.miui_load_dialog);
        dialog.setCancelable(cancelable);
        dialog.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        Window window = dialog.getWindow();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setGravity(Gravity.CENTER | Gravity.BOTTOM);
        layoutParams.width = (int) (displayMetrics.widthPixels * 1);
        window.setAttributes(layoutParams);
        window.setWindowAnimations(R.style.Dialog_Miui);
        AppCompatTextView contentTextView = dialog.findViewById(R.id.contentTextView);
        contentTextView.setText(content);
        dialog.show();
    }

    public static class Builder {

        private Context context = null;
        private boolean cancelable = true;
        private String content = "";

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setContent(int resId) {
            this.content = context.getString(resId);
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public MiuiLoadDialog show() {
            MiuiLoadDialog miuiLoadDialog = new MiuiLoadDialog(context);
            miuiLoadDialog.setCancelable(cancelable);
            miuiLoadDialog.setContent(content);
            miuiLoadDialog.show();
            return miuiLoadDialog;
        }

    }

}
