package com.way.rapid.shopping.adapter;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.way.rapid.shopping.R;
import com.way.rapid.shopping.bean.ImageShow;
import com.way.rapid.shopping.bean.Product;
import com.way.rapid.shopping.dao.ShoppingDao;
import com.way.rapid.shopping.help.DataHelp;
import com.way.rapid.shopping.help.ImageHttpThread;
import com.way.rapid.shopping.help.ShowImageByHttp;

import java.util.List;

public class ProListAdapter extends ArrayAdapter {
    private final int resourceId;

    public ProListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Product product = (Product) getItem(position);
        View view;
        ProLayout proLayout = new ProLayout();
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            proLayout.proImage = (ImageView) view.findViewById(R.id.pro_icon_image);
            proLayout.priceView = (TextView) view.findViewById(R.id.price);
            proLayout.titleView = (TextView) view.findViewById(R.id.title);
            proLayout.addShoppingButton = (Button) view.findViewById(R.id.add_shop);
            view.setTag(proLayout);
        } else {
            view = convertView;
            proLayout = (ProLayout) view.getTag();
        }
        ShowImageByHttp.setImage(product.getImage(), proLayout.proImage);
        proLayout.priceView.setText(product.getPrice());
        proLayout.titleView.setText(product.getTitle());
        proLayout.addShoppingButton.setOnClickListener(v -> {
            ShoppingDao.insertOrUpdateShop(new DataHelp(getContext(), "shop.db", null, 1), product);
            Toast.makeText(getContext(), "成功加入购物车", Toast.LENGTH_SHORT).show();
        });
        return view;
    }

    class ProLayout {
        private ImageView proImage;
        private TextView priceView;
        private TextView titleView;
        private Button addShoppingButton;
    }



}
