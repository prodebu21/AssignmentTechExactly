package com.example.assignmenttechexactly.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.assignmenttechexactly.model.AppModel;
import com.example.assignmenttechexactly.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context context;
    private List<AppModel> appList;

    public ItemAdapter(Context context, List<AppModel> appList) {
        this.context = context;
        this.appList = appList;
    }

    public void setItems(List<AppModel> appList) {
        this.appList = appList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppModel app = appList.get(position);
        holder.appName.setText(app.getAppName());
        Glide.with(context).load(app.getAppIcon()).into(holder.appIcon);

        // Set initial state of SwitchCompat
        //holder.appToggle.setChecked(app.getStatus());

        // Set listener for SwitchCompat state change
        holder.appToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update model state
          //  app.setStatusActive(isChecked);

            // Update SwitchCompat colors based on state
           /* if (isChecked) {
                holder.appToggle.setThumbTintList(context.getResources().getColorStateList(R.color.green));
                holder.appToggle.setTrackTintList(context.getResources().getColorStateList(R.color.green));
            } else {
                holder.appToggle.setThumbTintList(context.getResources().getColorStateList(R.color.grey));
                holder.appToggle.setTrackTintList(context.getResources().getColorStateList(R.color.grey));
            }*/
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView appIcon;
        TextView appName;
        SwitchCompat appToggle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appIcon = itemView.findViewById(R.id.app_icon);
            appName = itemView.findViewById(R.id.app_name);
            appToggle = itemView.findViewById(R.id.switchCompat);
        }
    }
}
