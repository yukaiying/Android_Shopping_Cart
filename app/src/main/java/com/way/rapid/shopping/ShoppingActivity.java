package com.way.rapid.shopping;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.way.rapid.shopping.adapter.ShopListAdapter;
import com.way.rapid.shopping.bean.Shopping;
import com.way.rapid.shopping.help.DataHelp;

import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        List<Shopping> list = queryShopTable();
        ShopListAdapter shopListAdapter = new ShopListAdapter(this, R.layout.shopping_list_linear, list);
        ListView listView = findViewById(R.id.list_shop);
        listView.setAdapter(shopListAdapter);

    }

    private List<Shopping> queryShopTable(){
        DataHelp dataHelp = new DataHelp(this, "shop.db", null, 1);
        Cursor tabShop = dataHelp.getReadableDatabase().query("tab_shop", null, null, null, null, null, null);
        List<Shopping> list = new ArrayList<Shopping>();
        while (tabShop.moveToNext()){
            Shopping shopping = new Shopping();
            shopping.setId(tabShop.getInt(0));
            shopping.setTitle(tabShop.getString(1));
            shopping.setPrice(tabShop.getString(2));
            shopping.setImg(tabShop.getString(3));
            shopping.setNum(tabShop.getInt(4));
            list.add(shopping);
        }
        return list;
    }
}
