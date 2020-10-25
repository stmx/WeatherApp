package com.stmlab.android.wetherapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stmlab.android.wetherapp.R;
import com.stmlab.android.wetherapp.models.CurrentWeather;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class CityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<CurrentWeather> mCityList = new ArrayList<>();
    OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public ArrayList<CurrentWeather> getCityList() {
        return mCityList;
    }

    public void setupCityList(ArrayList<CurrentWeather> data) {
        mCityList = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_whether, viewGroup, false);
        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if ( viewHolder instanceof CityHolder ) {
            ((CityHolder) viewHolder).bind(mCityList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(CurrentWeather model);
    }

    public class CityHolder extends RecyclerView.ViewHolder {
        TextView mTextViewCity;
        TextView mTextViewCityTemperature;

        public CityHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewCity = itemView.findViewById(R.id.textViewItemCity);
            mTextViewCityTemperature = itemView.findViewById(R.id.textViewItemCityTemperature);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if ( position != NO_POSITION ) {
                    mOnItemClickListener.onItemClick(mCityList.get(position));
                }
            });
        }

        public void bind(CurrentWeather weather) {
            mTextViewCity.setText(weather.getName());
            mTextViewCityTemperature.setText((weather.getMain().getTemperature() > 0 ? "+" : "") + weather.getMain().getTemperature());
        }
    }
}
