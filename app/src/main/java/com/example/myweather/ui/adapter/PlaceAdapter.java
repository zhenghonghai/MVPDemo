package com.example.myweather.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweather.R;
import com.example.myweather.model.Province;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.InnerHolder> {


    // 存放数据
    private List<Province> mData = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new InnerHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        Province province = mData.get(position);
        // 绑定数据
        holder.setData(province);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView content;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.home_place_content);
        }


        public void setData(Province province) {
            //TODO： 设置数据
            content.setText(province.getName());
        }
    }

    // 传递数据
    public void setmData(List<Province> contents) {
        mData.clear();
        mData.addAll(contents);
        notifyDataSetChanged();
    }

}
