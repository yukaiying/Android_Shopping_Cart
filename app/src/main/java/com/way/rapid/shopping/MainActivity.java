package com.way.rapid.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.way.rapid.shopping.adapter.ProListAdapter;
import com.way.rapid.shopping.bean.Product;
import com.way.rapid.shopping.help.ProductHttpThread;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProductHttpThread productHttpThread = new ProductHttpThread();
        productHttpThread.start();
        try {
            productHttpThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Product> list = JSON.parseArray(productHttpThread.getResult(), Product.class);
        ListView listView = (ListView)findViewById(R.id.list_pro);
        ProListAdapter proListAdapter = new ProListAdapter(this, R.layout.pro_list_linear, list);
        listView.setAdapter(proListAdapter);
    }

    public void goShopping(View v){
        Intent intent = new Intent(this, ShoppingActivity.class);
        startActivity(intent);
    }
}
