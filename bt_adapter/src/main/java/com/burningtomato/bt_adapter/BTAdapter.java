package com.burningtomato.bt_adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
/**
 * 使用见：{@link com.burningtomato.recyclerviewdemo.MainActivity}
 * @param <T>   数据Bean的类
 * @param <B>   item布局的ViewDataBinding
 *
 *  Author by firetomato, Github:{@link <a href="https://github.com/burningtomato">...</a>}, Date on 2022/11/15.
 *  PS: Not easy to write code, please indicate.
 */
public abstract class BTAdapter<T,B extends ViewDataBinding> extends RecyclerView.Adapter<BTViewHolder<B>> {
    private List<T> datas = new ArrayList<>();
    private int layoutId;

    public BTAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public BTViewHolder<B> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BTViewHolder<>(Objects.requireNonNull(DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false))));
    }

    @Override
    public void onBindViewHolder(@NonNull BTViewHolder holder, int position) {
        convert(holder, position);
    }

    /**
     * 使用position来获取数据
     *
     * super的内容是获取data的数据类获取数据{@link #convert(BTViewHolder, Object)} }
     * 如果不需要可以不用super
     *
     * @param holder
     * @param position
     */
    public void convert(@NonNull BTViewHolder<B> holder, int position){
        convert(holder, getDataByPosition(position));
    }

    /**
     * 使用数据类型来获取数据
     * 没有super内容，只是方便使用，不用两个convert方法都实现
     *
     * @param holder
     * @param data
     */
    public void convert(@NonNull BTViewHolder<B> holder, T data){};


    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(T data, int position){
        datas.add(position, data);
        notifyItemChanged(position);
    }

    public void addData(T data){
        datas.add(data);
        notifyItemChanged(datas.size());
    }

    public void addData(Collection<T> dataList){
        datas.addAll(dataList);
        notifyItemRangeInserted(datas.size()-dataList.size(),datas.size());
    }

    /**
     * 如果要多次移除，使用此方法
     * 因为多次移除的时候，可能position会错误
     * @param data
     */
    public void remove(T data){
        int i = datas.indexOf(data);
        if (i==-1) {
            return;
        }
        removeAt(i);
    }

    public void removeAt(int position){
        datas.remove(position);
        notifyItemRemoved(position);
    }

    public T getDataByPosition(int position){
        return datas.get(position);
    }

    /**
     * 获取整个adapter的数据列表
     * @return
     */
    public Collection<T> getDatas(){
        return datas;
    }

    /**
     * 刷新元素
     * @param data
     */
    public void refreshItem(T data){
        int i = datas.indexOf(data);
        if (i==-1) {
            return;
        }
        datas.set(i, data);
        notifyItemChanged(i);
    }

    /**
     * 刷新数据列表
     * @param dataList
     */
    public void refresh(Collection<T> dataList){
        datas.clear();
        datas.addAll(dataList);
        notifyItemRangeInserted(datas.size()-dataList.size(),datas.size());
    }

}
