package com.burningtomato.bt_adapter;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 *
 * @param <B>   xml布局的Databinding类
 *
 *  Author by firetomato, Github:{@link <a href="https://github.com/burningtomato">...</a>}, Date on 2022/11/15.
 *  PS: Not easy to write code, please indicate.
 */
public class BTViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder{
    public B binding;
    public BTViewHolder(@NonNull B itemView) {
        super(itemView.getRoot());
        binding = itemView;
    }
}
