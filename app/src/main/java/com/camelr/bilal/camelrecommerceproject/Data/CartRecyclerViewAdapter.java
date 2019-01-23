package com.camelr.bilal.camelrecommerceproject.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.camelr.bilal.camelrecommerceproject.Models.Item;
import com.camelr.bilal.camelrecommerceproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Item> itemList;

    public CartRecyclerViewAdapter(Context context, List<Item> items) {

        this.context = context;
        itemList = items;

    }

    @NonNull
    @Override
    public CartRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        // Create a View that inflates the item_row layout

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup,
            false);

        return new ViewHolder(view, context);

    }

    @Override
    public void onBindViewHolder(@NonNull CartRecyclerViewAdapter.ViewHolder viewHolder, int i) {

/*
         The viewHolder parameter has been created according to the statements from the onCreateViewHolder
         method above and the ViewHolder class/constructor below
*/

        // Binding the view from onCreateViewHolder method to the data

        Item item = itemList.get(i);

        String imageFile = item.getImageFile();

        viewHolder.title.setText(item.getTitle());
        viewHolder.description.setText(item.getDescription());

        Picasso.get().load(imageFile).placeholder(R.drawable.fragrances).into(viewHolder.image);

        viewHolder.price.setText("Price: " + item.getPrice() + " AED");
        viewHolder.quantity.setText("Quantity: " + item.getQuantity());
        viewHolder.sku.setText("SKU: " + item.getSku());
        viewHolder.exchangePolicy.setText("Exchange Policy: " + item.getExchangePolicy());
        viewHolder.returnPolicy.setText("Return Policy: " + item.getReturnPolicy());
        viewHolder.domCharge.setText("Domestic: " + item.getDomesticChrg());
        viewHolder.intlCharge.setText("International: " + item.getIntlChrg());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title;
        TextView description;
        TextView quantity;
        TextView price;
        TextView sku;
        TextView returnPolicy;
        TextView exchangePolicy;
        TextView shippingCharges;
        TextView domCharge;
        TextView intlCharge;

        public ViewHolder(@NonNull View itemView, Context ctx) {

            super(itemView);

            context = ctx;

            // Instantiating all of the widgets of the item_row layout

            image = itemView.findViewById(R.id.itemImageID);
            title = itemView.findViewById(R.id.itemTitleID);
            description = itemView.findViewById(R.id.itemDescID);
            quantity = itemView.findViewById(R.id.itemQtyID);
            price = itemView.findViewById(R.id.itemPriceID);
            sku = itemView.findViewById(R.id.itemSkuID);
            returnPolicy = itemView.findViewById(R.id.returnPolID);
            exchangePolicy = itemView.findViewById(R.id.exchangePolID);
            shippingCharges = itemView.findViewById(R.id.shippingChargesID);
            domCharge = itemView.findViewById(R.id.domesticChargeID);
            intlCharge = itemView.findViewById(R.id.intlChargeID);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

        @Override
        public void onClick(View v) {

        }
    }
}
