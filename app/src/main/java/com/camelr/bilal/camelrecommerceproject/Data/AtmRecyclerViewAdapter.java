package com.camelr.bilal.camelrecommerceproject.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.camelr.bilal.camelrecommerceproject.Models.ATM;
import com.camelr.bilal.camelrecommerceproject.R;

import java.util.List;

public class AtmRecyclerViewAdapter extends RecyclerView.Adapter<AtmRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<ATM> atmList;

    public AtmRecyclerViewAdapter (Context context, List<ATM> atms) {

        this.context = context;
        atmList = atms;

    }

    @NonNull
    @Override
    public AtmRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        // Create a View that inflates the item_row layout

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atm_row, viewGroup,
                false);

        return new ViewHolder(view, context);

    }

    @Override
    public void onBindViewHolder(@NonNull AtmRecyclerViewAdapter.ViewHolder viewHolder, int i) {

        // Binding the view from onCreateViewHolder method to the data

        ATM atm = atmList.get(i);

        viewHolder.address.setText("Address: " + atm.getAddress());
        viewHolder.coordinates.setText("(" + String.valueOf(atm.getLat()) + ", " + String.valueOf
                (atm.getLon()) + ")");
        viewHolder.typeAndTitle.setText(atm.getType() + " - " + atm.getTitle());
        viewHolder.atmID.setText("ATM ID: " + atm.getAtmId());
        viewHolder.onlineStatus.setText("Online: " + atm.getOnlineStatus());

    }

    @Override
    public int getItemCount() {
        return atmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView address;
        TextView coordinates;
        TextView typeAndTitle;
        TextView atmID;
        TextView onlineStatus;

        public ViewHolder(@NonNull View itemView, Context ctx) {

            super(itemView);

            context = ctx;

            image = itemView.findViewById(R.id.atmImageID);
            address = itemView.findViewById(R.id.atmAddressID);
            coordinates = itemView.findViewById(R.id.atmCoordinatesID);
            typeAndTitle = itemView.findViewById(R.id.atmTypeAndTitleID);
            atmID = itemView.findViewById(R.id.atmIDTextView);
            onlineStatus = itemView.findViewById(R.id.atmOnlineStatusID);

        }

        @Override
        public void onClick(View v) {

        }

    }

}
