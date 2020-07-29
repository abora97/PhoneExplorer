package com.abora.phoneexplorer.ui.fragment.explore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.ui.activity.details.DetailsActivity;
import com.abora.phoneexplorer.util.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {

    private List<PhoneResponse> list;
    Context context;

    PhoneAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_phone, parent, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhoneResponse mlist = list.get(position);
        holder.tvPhoneName.setText(mlist.getDeviceName());
        holder.cardPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constants.DETAILS_DATA, mlist);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

    public void setList(List<PhoneResponse> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPhoneName)
        TextView tvPhoneName;
        @BindView(R.id.cardPhone)
        CardView cardPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}