package com.example.recycleview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {

    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public HorizontalProductScrollAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizonal_scroll_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder viewholder, int position) {
       int resourse = horizontalProductScrollModelList.get(position).getProductImage();
       String title = horizontalProductScrollModelList.get(position).getProductTitle();
       String description = horizontalProductScrollModelList.get(position).getProductDescription();
       String price = horizontalProductScrollModelList.get(position).getProductPrice();

        viewholder.setProductImage(resourse);
        viewholder.setProductTitle(title);
        viewholder.setProductDescription(description);
        viewholder.setProductPrice(price);


    }

    @Override
    public int getItemCount() {
        if(horizontalProductScrollModelList.size() > 8){
            return 8;
        }else {
            return horizontalProductScrollModelList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.h_s_product_image);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDescription = itemView.findViewById(R.id.h_s_product_discription);
            productPrice = itemView.findViewById(R.id.h_s_product_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailIntent = new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailIntent);
                }
            });
        }

        private void setProductImage(int resourse) {
            productImage.setImageResource(resourse);
        }

        private void setProductTitle(String title) {
            productTitle.setText(title);
        }

        private void setProductDescription(String description) {
            productDescription.setText(description);
        }

        private void setProductPrice(String price) {
            productPrice.setText(price);
        }

    }
}
