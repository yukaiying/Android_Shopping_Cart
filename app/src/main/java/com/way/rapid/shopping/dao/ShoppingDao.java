package com.way.rapid.shopping.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.way.rapid.shopping.adapter.ProListAdapter;
import com.way.rapid.shopping.bean.Product;
import com.way.rapid.shopping.help.DataHelp;

public class ShoppingDao {

    public static void insertOrUpdateShop(DataHelp dataHelp, Product product) {
        Cursor cursor = dataHelp.getReadableDatabase().query("tab_shop", null, "pro_id = ?", new String[]{String.valueOf(product.getId())}, null, null, null, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", product.getTitle());
        contentValues.put("price", product.getPrice());
        contentValues.put("img", product.getImage());
        contentValues.put("pro_id", product.getId());
        if (cursor.moveToNext()) {
            contentValues.put("num", cursor.getInt(4) + 1);
            dataHelp.getWritableDatabase().update("tab_shop", contentValues, "id = ?", new String[]{String.valueOf(cursor.getInt(5))});
        } else {
            contentValues.put("num", 1);
            dataHelp.getWritableDatabase().insert("tab_shop", null, contentValues);
        }
    }
}
