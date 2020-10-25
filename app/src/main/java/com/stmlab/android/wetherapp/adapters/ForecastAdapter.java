package com.stmlab.android.wetherapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stmlab.android.wetherapp.R;
import com.stmlab.android.wetherapp.models.ForecastList;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class ForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ForecastList> mForecastList = new ArrayList<ForecastList>();
    OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setupForecastList(ArrayList<ForecastList> data) {
        mForecastList = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_forecast, viewGroup, false);
        return new ForecastHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if ( viewHolder instanceof ForecastHolder ) {
            ((ForecastHolder) viewHolder).bind(mForecastList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mForecastList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ForecastList model);
    }

    public class ForecastHolder extends RecyclerView.ViewHolder {
        TextView mTextViewTime;
        TextView mTextViewTemperature;
        TextView mTextViewCloudy;

        public ForecastHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTime = itemView.findViewById(R.id.textViewTime);
            mTextViewTemperature = itemView.findViewById(R.id.textViewForecastTemperature);
            mTextViewCloudy = itemView.findViewById(R.id.textViewForecastCloudy);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if ( position != NO_POSITION ) {
//                    mOnItemClickListener.onItemClick(mForecastList.get(position));
                }
            });
        }

        public void bind(ForecastList test) {
            mTextViewTime.setText(test.getDtTxt());
            mTextViewTemperature.setText("Температура: " + ((test.getMain().getTemperature() > 0 ? "+" : "") + String.valueOf(test.getMain().getTemperature())));
            mTextViewCloudy.setText(test.getWeather().get(0).getDescription());
        }
    }
}
