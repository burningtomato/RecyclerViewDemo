package com.burningtomato.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.burningtomato.bt_adapter.BTAdapter;
import com.burningtomato.bt_adapter.BTViewHolder;
import com.burningtomato.recyclerviewdemo.databinding.ActivityMainBinding;
import com.burningtomato.recyclerviewdemo.databinding.ItemLayoutBinding;

public class MainActivity extends AppCompatActivity {
    private BTAdapter adapter;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.bind(LayoutInflater.from(this).inflate(R.layout.activity_main,null));
        setContentView(activityMainBinding.getRoot());
        testAdapter();
        initDataList();
    }

    private void testAdapter() {
        adapter = new BTAdapter<MainBean, ItemLayoutBinding>(R.layout.item_layout) {
            @Override
            public void convert(@NonNull BTViewHolder<ItemLayoutBinding> holder, MainBean data) {
                holder.binding.txContent.setText(data.getContent() + data.getIndex());
            }
        };

        activityMainBinding.recyclerView.setAdapter(adapter);
    }

    private void initDataList(){
        for (int i = 0; i < 30; i++) {
            adapter.addData(new MainBean("这个是测试数据", i));
        }

    }
}