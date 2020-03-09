package top.yokey.example;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import top.yokey.miuidialog.MiuiDialogHelper;
import top.yokey.miuidialog.MiuiInputDialog;
import top.yokey.miuidialog.MiuiListDialog;
import top.yokey.miuidialog.MiuiLoadDialog;
import top.yokey.miuidialog.MiuiMutilInputDialog;
import top.yokey.miuidialog.MiuiQueryDialog;

public class MainActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle bundle) {

        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        //设置按钮颜色
        MiuiDialogHelper.get().setAccentColor(R.color.title);
        MiuiDialogHelper.get().setNegativeColor(R.color.title);
        MiuiDialogHelper.get().setPositiveColor(R.color.title);
        MiuiDialogHelper.get().setListArrow(R.drawable.ic_miui_arrow_right);
        //设置各个对话框
        AppCompatButton miuiQueryDialogButton = findViewById(R.id.miuiQueryDialogButton);
        AppCompatButton miuiMutilInputDialogButton = findViewById(R.id.miuiMutilInputDialogButton);
        AppCompatButton miuiInputDialogButton = findViewById(R.id.miuiInputDialogButton);
        AppCompatButton miuiListDialogButton = findViewById(R.id.miuiListDialogButton);
        AppCompatButton miuiLoadDialogButton = findViewById(R.id.miuiLoadDialogButton);
        miuiQueryDialogButton.setOnClickListener(view -> new MiuiQueryDialog.Builder(this)
                .setCancelable(true)
                .setTitle("MIUI对话框")
                .setContent("MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框MIUI对话框")
                .setNegativeButton("取消", v -> Toast.makeText(MainActivity.this, "点击了取消", Toast.LENGTH_LONG).show())
                .setPositiveButton("确认", v -> Toast.makeText(MainActivity.this, "点击了确认", Toast.LENGTH_LONG).show())
                .show()
        );
        miuiMutilInputDialogButton.setOnClickListener(view -> new MiuiMutilInputDialog.Builder(this)
                .setCancelable(false)
                .setTitle("MIUI多行输入框")
                .setContent("MIUI多行输入框")
                .setNegativeButton("取消", content -> Toast.makeText(MainActivity.this, "点击了取消:" + content, Toast.LENGTH_LONG).show())
                .setPositiveButton("确认", content -> Toast.makeText(MainActivity.this, "点击了确认:" + content, Toast.LENGTH_LONG).show())
                .show()
        );
        miuiInputDialogButton.setOnClickListener(view -> new MiuiInputDialog.Builder(this)
                .setCancelable(false)
                .setTitle("MIUI输入框")
                .setContent("MIUI输入框")
                .setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .setNegativeButton("取消", content -> Toast.makeText(MainActivity.this, "点击了取消:" + content, Toast.LENGTH_LONG).show())
                .setPositiveButton("确认", content -> Toast.makeText(MainActivity.this, "点击了确认:" + content, Toast.LENGTH_LONG).show())
                .show()
        );
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("男");
        arrayList.add("女");
        miuiListDialogButton.setOnClickListener(view -> new MiuiListDialog.Builder(this)
                .setCancelable(false)
                .setTitle("测试List")
                .setList(arrayList)
                .setSelector(1)
                .setListListener((position, content) -> Toast.makeText(MainActivity.this, "点击了选项:" + position + content, Toast.LENGTH_LONG).show())
                .setPositiveButton("取消", (position, content) -> Toast.makeText(MainActivity.this, "点击了取消:" + position + content, Toast.LENGTH_LONG).show())
                .show()
        );
        miuiLoadDialogButton.setOnClickListener(view -> new MiuiLoadDialog.Builder(this)
                .setCancelable(false)
                .setContent("加载中请稍后")
                .show()
        );

    }

    public int getColors(int id) {

        return getResources().getColor(id);

    }

}
