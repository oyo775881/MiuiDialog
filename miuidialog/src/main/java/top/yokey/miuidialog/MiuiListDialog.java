package top.yokey.miuidialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@SuppressWarnings("ALL")
public class MiuiListDialog {

    private Dialog dialog;
    private Context context;
    private boolean cancelable;
    private String title;
    private ArrayList<String> list;
    private int selector;
    private MiuiListListener miuiListListener;
    private String positive;
    private MiuiListListener positiveListener;

    public MiuiListDialog(Context context) {

        this.context = context;

    }

    public void setCancelable(boolean cancelable) {

        this.cancelable = cancelable;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public void setList(ArrayList<String> list) {

        this.list = list;

    }

    public void setSelector(int selector) {

        this.selector = selector;

    }

    public void setMiuiListListener(MiuiListListener miuiListListener) {

        this.miuiListListener = miuiListListener;

    }

    public void setPositive(String positive) {

        this.positive = positive;

    }

    public void setPositiveListener(MiuiListListener positiveListener) {

        this.positiveListener = positiveListener;

    }

    public void show() {

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.miui_list_dialog);
        dialog.setCancelable(cancelable);
        dialog.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        Window window = dialog.getWindow();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setGravity(Gravity.CENTER | Gravity.BOTTOM);
        layoutParams.width = (int) (displayMetrics.widthPixels * 1);
        window.setAttributes(layoutParams);
        window.setWindowAnimations(R.style.Dialog_Miui);
        AppCompatTextView titleTextView = dialog.findViewById(R.id.titleTextView);
        RecyclerView recyclerView = dialog.findViewById(R.id.mainRecyclerView);
        MiuiListAdapter miuiListAdapter = new MiuiListAdapter(context, selector, list);
        recyclerView.setAdapter(miuiListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new MiuiLineDecoration(1, context.getResources().getColor(R.color.line), false));
        recyclerView.setNestedScrollingEnabled(false);
        AppCompatTextView positiveTextView = dialog.findViewById(R.id.positiveTextView);
        titleTextView.setText(title);
        if (MiuiDialogHelper.get().getPositiveColor() != 0) {
            positiveTextView.setTextColor(context.getResources().getColor(MiuiDialogHelper.get().getPositiveColor()));
        }
        positiveTextView.setText(positive);
        positiveTextView.setOnClickListener(view -> {
            if (positiveListener != null) {
                positiveListener.onClick(selector, list.get(selector));
            }
            dialog.dismiss();
        });
        miuiListAdapter.setOnItemClickListener((position, content) -> {
            if (miuiListListener != null) {
                miuiListListener.onClick(position, content);
            }
            dialog.dismiss();
        });
        dialog.show();

    }

    public static class Builder {

        private Context context = null;
        private boolean cancelable = true;
        private String title = "";
        private ArrayList<String> list;
        private int selector = 0;
        private MiuiListListener miuiListListener = null;
        private String positive = "";
        private MiuiListListener positiveListener = null;

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

        public Builder setList(ArrayList<String> list) {

            this.list = list;
            return this;

        }

        public Builder setSelector(int selector) {

            this.selector = selector;
            return this;

        }

        public Builder setListListener(MiuiListListener miuiListListener) {

            this.miuiListListener = miuiListListener;
            return this;

        }

        public Builder setPositiveButton(int resId, MiuiListListener positiveListener) {

            this.positive = context.getString(resId);
            this.positiveListener = positiveListener;
            return this;

        }

        public Builder setPositiveButton(String positive, MiuiListListener positiveListener) {

            this.positive = positive;
            this.positiveListener = positiveListener;
            return this;

        }

        public MiuiListDialog show() {

            MiuiListDialog miuiListDialog = new MiuiListDialog(context);
            miuiListDialog.setCancelable(cancelable);
            miuiListDialog.setTitle(title);
            miuiListDialog.setList(list);
            miuiListDialog.setSelector(selector);
            miuiListDialog.setMiuiListListener(miuiListListener);
            miuiListDialog.setPositive(positive);
            miuiListDialog.setPositiveListener(positiveListener);
            miuiListDialog.show();
            return miuiListDialog;

        }

    }

}
