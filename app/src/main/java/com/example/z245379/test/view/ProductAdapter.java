package com.example.z245379.test.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.z245379.test.R;
import com.example.z245379.test.databinding.ItemProductBinding;
import com.example.z245379.test.model.Product;
import com.example.z245379.test.viewmodel.ProductItemViewModel;

import java.util.Collections;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder> {

    private List<Product> productList;

    public ProductAdapter(){this.productList = Collections.emptyList();}

    @NonNull
    @Override
    public ProductAdapter.ProductAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemProductBinding itemProductBinding;
        itemProductBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_product, parent, false);


        return new ProductAdapterViewHolder(itemProductBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductAdapterViewHolder holder, int position) {
        holder.bindProduct(productList.get(position));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setProductList(List<Product> productList){
        this.productList = productList;
        notifyDataSetChanged();
    }

    public class ProductAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemProductBinding mItemProductBinding;

        public ProductAdapterViewHolder(ItemProductBinding itemProductBinding) {
            super(itemProductBinding.itemProduct);
            this.mItemProductBinding = itemProductBinding;
        }

        public void bindProduct(Product product){
            if(mItemProductBinding.getProductViewModel() == null) {
                mItemProductBinding.setProductViewModel(
                        new ProductItemViewModel(product, itemView.getContext()));
            }else{
                mItemProductBinding.getProductViewModel().setProduct(product);
            }

        }
    }
}
