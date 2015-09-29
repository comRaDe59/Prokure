package com.example.khyati.prokureii;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Collections;
import java.util.List;

/**
 * Created by khyati on 9/25/2015.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    List<Product>  list = Collections.emptyList();
    static Context context;
    LayoutInflater inflater;



    public ProductAdapter(Context context,List<Product> list){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.product_detail1, viewGroup, false);
        ProductViewHolder holder = new ProductViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ProductViewHolder holder, int i) {
        Product current  = list.get(i);
        holder.name.setText(current.getProductName());
        holder.image.setImageResource(current.getImgId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        CardView card;
        public ProductViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.product_image);
            name = (TextView) itemView.findViewById(R.id.product_name);
            card = (CardView) itemView.findViewById(R.id.card);
        }



    }
}
