package top.yokey.miuidialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.widget.AppCompatTextView;

@SuppressWarnings("ALL")
public class MiuiQueryDialog {

    private Dialog dialog;
    private Context context;
    private boolean cancelable;
    private String title;
    private String content;
    private String negative;
    private View.OnClickListener negativeListener;
    private String positive;
    private View.OnClickListener positiveListener;

    public MiuiQueryDialog(Context context) {

        this.context = context;

    }

    public void setCancelable(boolean cancelable) {

        this.cancelable = cancelable;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public void setContent(String content) {

        this.content = content;

    }

    public void setNegative(String negative) {

        this.negative = negative;

    }

    public void setNegativeListener(View.OnClickListener negativeListener) {

        this.negativeListener = negativeListener;

    }

    public void setPositive(String positive) {

        this.positive = positive;

    }

    public void setPositiveListener(View.OnClickListener positiveListener) {

        this.positiveListener = positiveListener;

    }

    public void show() {

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.miui_query_dialog);
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
        AppCompatTextView titleTextView = dialog.findViewById(R.id.titleTextView);
        AppCompatTextView contentTextView = dialog.findViewById(R.id.contentTextView);
        AppCompatTextView negativeTextView = dialog.findViewById(R.id.negativeTextView);
        AppCompatTextView positiveTextView = dialog.findViewById(R.id.positiveTextView);
        titleTextView.setText(title);
        contentTextView.setText(content);
        negativeTextView.setText(negative);
        negativeTextView.setOnClickListener(view -> {
            if (negativeListener != null) {
                negativeListener.onClick(view);
            }
            dialog.dismiss();
        });
        positiveTextView.setText(positive);
        positiveTextView.setOnClickListener(view -> {
            if (positiveListener != null) {
                positiveListener.onClick(view);
            }
            dialog.dismiss();
        });
        dialog.show();

    }

    public static class Builder {

        private Context context = null;
        private boolean cancelable = true;
        private String title = "";
        private String content = "";
        private String negative = "";
        private View.OnClickListener negativeListener = null;
        private String positive = "";
        private View.OnClickListener positiveListener = null;

        public Builder(Context context) {

            this.context = context;

        }

        public Builder setCancelable(boolean cancelable) {

            this.cancelable = cancelable;
            return this;

        }

        public Builder setTitle(int resId) {

            this.title = context.getString(resId);
            return this;

        }

        public Builder setTitle(String title) {

            this.title = title;
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

        public Builder setNegativeButton(int resId, View.OnClickListener negativeListener) {

            this.negative = context.getString(resId);
            this.negativeListener = negativeListener;
            return this;

        }

        public Builder setNegativeButton(String negative, View.OnClickListener negativeListener) {

            this.negative = negative;
            this.negativeListener = negativeListener;
            return this;

        }

        public Builder setPositiveButton(int resId, View.OnClickListener positiveListener) {

            this.positive = context.getString(resId);
            this.positiveListener = positiveListener;
            return this;

        }

        public Builder setPositiveButton(String positive, View.OnClickListener positiveListener) {

            this.positive = positive;
            this.positiveListener = positiveListener;
            return this;

        }

        public MiuiQueryDialog show() {

            MiuiQueryDialog miuiQueryDialog = new MiuiQueryDialog(context);
            miuiQueryDialog.setCancelable(cancelable);
            miuiQueryDialog.setTitle(title);
            miuiQueryDialog.setContent(content);
            miuiQueryDialog.setNegative(negative);
            miuiQueryDialog.setNegativeListener(negativeListener);
            miuiQueryDialog.setPositive(positive);
            miuiQueryDialog.setPositiveListener(positiveListener);
            miuiQueryDialog.show();
            return miuiQueryDialog;

        }

    }

}
