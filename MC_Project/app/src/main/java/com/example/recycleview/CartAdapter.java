package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {

    private List<CartItemModel> cartItemModelList;

    public CartAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()){
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case CartItemModel.CART_ITEM:
                View cartItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
                return new CartItemViewholder(cartItemView);
            case CartItemModel.TOTAL_AMOUNT:
                View cartTotalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout,parent,false);
                return new CartTotalAmountViewholder(cartTotalView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartItemModelList.get(position).getType()){
            case CartItemModel.CART_ITEM:
                int resource = cartItemModelList.get(position).getProductImage();
                String title = cartItemModelList.get(position).getProductTitle();
                int freeCoupens = cartItemModelList.get(position).getFreeCoupens();
                String productPrice = cartItemModelList.get(position).getProductPrice();
                String cuttedPrice = cartItemModelList.get(position).getCuttedPrice();
                int offerApplied = cartItemModelList.get(position).getOfferApplied();

                ((CartItemViewholder)holder).setItemDetails(resource,title,freeCoupens,productPrice,cuttedPrice,offerApplied);

                break;
                case CartItemModel.TOTAL_AMOUNT:
                    String totalItems = cartItemModelList.get(position).getTotalItems();
                    String totalItemPrice = cartItemModelList.get(position).getTotalItemPrice();
                    String deliveryPrice = cartItemModelList.get(position).getDeliveryPrice();
                    String totalAmount = cartItemModelList.get(position).getTotalAmount();
                    String saveAmount = cartItemModelList.get(position).getSavedAmount();
                    ((CartTotalAmountViewholder)holder).setTotalAmount(totalItems,totalItemPrice,deliveryPrice,totalAmount,saveAmount);
                    break;
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    class CartItemViewholder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private ImageView freeCoupenIcon;
        private TextView productTitle;
        private TextView freeCoupens;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplied;
        private TextView coupensApplied;
        private TextView productQuantity;

        public CartItemViewholder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            freeCoupens = itemView.findViewById(R.id.tv_free_coupan);
            freeCoupenIcon = itemView.findViewById(R.id.free_coupan_icon);
            productPrice = itemView.findViewById(R.id.product_price);
            cuttedPrice = itemView.findViewById(R.id.cutted_price);
            offersApplied = itemView.findViewById(R.id.offiers_applied);
            coupensApplied = itemView.findViewById(R.id.coupans_applied);
            productQuantity = itemView.findViewById(R.id.product_quantity);
        }

        private void setItemDetails(int resource,String title, int freeCoupensNo,String productPriceText,String cuttedPriceText, int offerAppliedNo){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCoupensNo > 0){
                freeCoupenIcon.setVisibility(View.VISIBLE);
                freeCoupens.setVisibility(View.VISIBLE);
                if (freeCoupensNo == 1){
                    freeCoupens.setText("free "+ freeCoupensNo +" Coupen");
                }else {
                    freeCoupens.setText("free "+ freeCoupensNo +" Coupens");
                }
            }else {
                freeCoupenIcon.setVisibility(View.INVISIBLE);
                freeCoupens.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPriceText);
            cuttedPrice.setText(cuttedPriceText);
            if (offerAppliedNo > 0){
                offersApplied.setVisibility(View.VISIBLE);
                offersApplied.setText(offerAppliedNo + " offers applied");
            }else {
                offersApplied.setVisibility(View.INVISIBLE);
            }
        }
    }
    class CartTotalAmountViewholder extends RecyclerView.ViewHolder{

        private TextView totalItems;
        private TextView totalItemsPrice;
        private TextView deliveryPrice;
        private TextView totalAmount;
        private TextView savedAmount;

        public CartTotalAmountViewholder(@NonNull View itemView) {
            super(itemView);

            totalItems = itemView.findViewById(R.id.total_items);
            totalItemsPrice = itemView.findViewById(R.id.total_item_price);
            deliveryPrice = itemView.findViewById(R.id.delivery_price);
            totalAmount = itemView.findViewById(R.id.total_price);
            savedAmount = itemView.findViewById(R.id.saved_amount);
        }
        private void setTotalAmount(String totalItemText,String itemPriceText, String deliveryPriceText, String totalAmountText, String savedTextAmountText){
            totalItems.setText(totalItemText);
            totalItemsPrice.setText(itemPriceText);
            deliveryPrice.setText(deliveryPriceText);
            totalAmount.setText(totalAmountText);
            savedAmount.setText(savedTextAmountText);
        }
    }
}
