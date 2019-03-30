package top.yokey.miuidialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

@SuppressWarnings("ALL")
public class MiuiListAdapter extends RecyclerView.Adapter<MiuiListAdapter.ViewHolder> {

    private final Context context;
    private final int selector;
    private final ArrayList<String> arrayList;
    private OnItemClickListener onItemClickListener;

    public MiuiListAdapter(Context context, int selector, ArrayList<String> arrayList) {
        this.context = context;
        this.selector = selector;
        this.arrayList = arrayList;
        this.onItemClickListener = null;
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String content = arrayList.get(position);
        holder.mainTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(context.getDrawable(R.drawable.ic_miui_arrow_empty), null, null, null);
        holder.mainTextView.setTextColor(context.getColor(R.color.title));
        if (selector == position) {
            holder.mainTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(context.getDrawable(R.drawable.ic_miui_arrow_right), null, null, null);
            holder.mainTextView.setTextColor(context.getColor(R.color.blue));
        }
        holder.mainTextView.setText(content);
        holder.mainTextView.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onClick(position, content);
            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.miui_item_list, group, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {

        return arrayList.size();

    }

    @SuppressWarnings("unused")
    public void setOnItemClickListener(OnItemClickListener listener) {

        this.onItemClickListener = listener;

    }

    @SuppressWarnings("unused")
    public interface OnItemClickListener {

        @SuppressWarnings({"unused", "EmptyMethod"})
        void onClick(int position, String content);

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView mainTextView;

        private ViewHolder(View view) {
            super(view);
            mainTextView = view.findViewById(R.id.mainTextView);
        }

    }

}
