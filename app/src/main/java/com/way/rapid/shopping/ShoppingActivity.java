package com.way.rapid.shopping;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ShoppingActivity.this, R.style.Theme_AppCompat_Light_Dialog_Alert);
                alertDialog.setTitle("确定删除？");
                alertDialog.setMessage("请确定执行删除？");
                alertDialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        shopListAdapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });

    }

    private List<Shopping> queryShopTable() {
        DataHelp dataHelp = new DataHelp(this, "shop.db", null, 1);
        Cursor tabShop = dataHelp.getReadableDatabase().query("tab_shop", null, null, null, null, null, null);
        List<Shopping> list = new ArrayList<Shopping>();
        while (tabShop.moveToNext()) {
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

    public void shopBack(View v) {
        this.finish();
    }
}
