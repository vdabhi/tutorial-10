package com.example.tutorial_10;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private JSONArray jsonArray;

    public CustomAdapter(Context context, JSONArray jsonArray) {
        this.context = context;
        this.jsonArray = jsonArray;
    }

    @Override
    public int getCount() {
        return jsonArray.length();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);

        TextView txtName = view.findViewById(R.id.listTxtName);
        TextView txtEmail = view.findViewById(R.id.listTxtEmail);

        try {
            JSONObject object = jsonArray.getJSONObject(i);
            txtName.setText("Name: " + object.getString("name"));
            txtEmail.setText("Email: " + object.getString("email"));
            txtName.setTextColor(Color.RED);
            txtEmail.setTextColor(Color.RED);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }
}