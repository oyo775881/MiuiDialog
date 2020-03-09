package top.yokey.miuidialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.InputType;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

@SuppressWarnings("ALL")
public class MiuiMutilInputDialog {

    private Dialog dialog;
    private Context context;
    private boolean cancelable;
    private String title;
    private String content;
    private String negative;
    private MiuiMutilInputListener negativeListener;
    private String positive;
    private MiuiMutilInputListener positiveListener;

    public MiuiMutilInputDialog(Context context) {

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

    public void setNegativeListener(MiuiMutilInputListener negativeListener) {

        this.negativeListener = negativeListener;

    }

    public void setPositive(String positive) {

        this.positive = positive;

    }

    public void setPositiveListener(MiuiMutilInputListener positiveListener) {

        this.positiveListener = positiveListener;

    }

    public void show() {

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.miui_mutil_input_dialog);
        dialog.setCancelable(cancelable);
        dialog.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        Window window = dialog.getWindow();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setGravity(Gravity.CENTER | Gravity.BOTTOM);
        layoutParams.width = (int) (displayMetrics.widthPixels * 1);
        window.setAttributes(layoutParams);
        AppCompatTextView titleTextView = dialog.findViewById(R.id.titleTextView);
        AppCompatEditText contentEditText = dialog.findViewById(R.id.contentEditText);
        AppCompatTextView negativeTextView = dialog.findViewById(R.id.negativeTextView);
        AppCompatTextView positiveTextView = dialog.findViewById(R.id.positiveTextView);
        titleTextView.setText(title);
        contentEditText.setText(content);
        negativeTextView.setText(negative);
        if (MiuiDialogHelper.get().getNegativeColor() != 0) {
            negativeTextView.setTextColor(context.getResources().getColor(MiuiDialogHelper.get().getNegativeColor()));
        }
        negativeTextView.setOnClickListener(view -> {
            if (negativeListener != null) {
                negativeListener.onClick(contentEditText.getText().toString());
            }
            dialog.dismiss();
        });
        if (MiuiDialogHelper.get().getPositiveColor() != 0) {
            positiveTextView.setTextColor(context.getResources().getColor(MiuiDialogHelper.get().getPositiveColor()));
        }
        positiveTextView.setText(positive);
        positiveTextView.setOnClickListener(view -> {
            if (positiveListener != null) {
                positiveListener.onClick(contentEditText.getText().toString());
            }
            dialog.dismiss();
        });
        if (!TextUtils.isEmpty(content)) {
            contentEditText.setSelection(content.length());
        }
        contentEditText.post(new Runnable() {
            @Override
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) ((Activity) context).getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                contentEditText.setFocusable(true);
                contentEditText.setFocusableInTouchMode(true);
                contentEditText.requestFocus();
                contentEditText.requestFocusFromTouch();
            }
        });
        dialog.show();

    }

    public static class Builder {

        private Context context = null;
        private boolean cancelable = true;
        private String title = "";
        private String content = "";
        private String negative = "";
        private MiuiMutilInputListener negativeListener = null;
        private String positive = "";
        private MiuiMutilInputListener positiveListener = null;

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

        public Builder setNegativeButton(int resId, MiuiMutilInputListener negativeListener) {

            this.negative = context.getString(resId);
            this.negativeListener = negativeListener;
            return this;

        }

        public Builder setNegativeButton(String negative, MiuiMutilInputListener negativeListener) {

            this.negative = negative;
            this.negativeListener = negativeListener;
            return this;

        }

        public Builder setPositiveButton(int resId, MiuiMutilInputListener positiveListener) {

            this.positive = context.getString(resId);
            this.positiveListener = positiveListener;
            return this;

        }

        public Builder setPositiveButton(String positive, MiuiMutilInputListener positiveListener) {

            this.positive = positive;
            this.positiveListener = positiveListener;
            return this;

        }

        public MiuiMutilInputDialog show() {

            MiuiMutilInputDialog miuiInputDialog = new MiuiMutilInputDialog(context);
            miuiInputDialog.setCancelable(cancelable);
            miuiInputDialog.setTitle(title);
            miuiInputDialog.setContent(content);
            miuiInputDialog.setNegative(negative);
            miuiInputDialog.setNegativeListener(negativeListener);
            miuiInputDialog.setPositive(positive);
            miuiInputDialog.setPositiveListener(positiveListener);
            miuiInputDialog.show();
            return miuiInputDialog;

        }

    }

}
