package com.example.myshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.ProductListBinding
import com.squareup.picasso.Picasso

class ProductAdapter(var productList: List<Product>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var binding= ProductListBinding.inflate(LayoutInflater.from(parent.context) ,parent ,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct=productList[position]
        var binding=holder.binding
        binding.tvNames.text=currentProduct.title
        binding.tvdescription.text=currentProduct.description
        binding.tvprice.text=currentProduct.price.toString()



        Picasso
            .get()
            .load(currentProduct.thumbnail)
            .resize(300,300)
            .centerCrop()
            .into(binding.ivAvatar)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}




class ProductViewHolder(var binding: ProductListBinding):RecyclerView.ViewHolder(binding.root)
