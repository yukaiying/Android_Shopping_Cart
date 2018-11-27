package com.way.rapid.shopping.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.way.rapid.shopping.R;
import com.way.rapid.shopping.bean.Shopping;

import java.util.List;

public class ShopListAdapter extends ArrayAdapter {
    private int resourceId;

    public ShopListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shopping shopping = (Shopping) getItem(position);
        View view;
        ShopLayout shopLayout = new ShopLayout();
        if (convertView == null){
           view = LayoutInflater.from(getContext()).inflate(resourceId, null);
           shopLayout.titleView = view.findViewById(R.id.shop_title);
           shopLayout.priceView = view.findViewById(R.id.shop_price);
           shopLayout.numText = view.findViewById(R.id.shop_num);
           shopLayout.imageView = view.findViewById(R.id.shop_img);
           shopLayout.addButton = view.findViewById(R.id.add_num_button);
           shopLayout.delButton = view.findViewById(R.id.del_num_button);
           view.setTag(shopLayout);
        }else {
            view = convertView;
            shopLayout = (ShopLayout) view.getTag();
        }
        shopLayout.titleView.setText(shopping.getTitle());
        shopLayout.priceView.setText(shopping.getPrice());
        shopLayout.numText.setText(shopping.getNum()+"");
        shopLayout.addButton.setOnClickListener(v -> {

        });
        shopLayout.delButton.setOnClickListener(v -> {

        });
        return view;
    }

    class ShopLayout {
      ImageView imageView;
      TextView titleView;
      TextView priceView;
      Button addButton;
      EditText numText;
      Button delButton;
    }
}
