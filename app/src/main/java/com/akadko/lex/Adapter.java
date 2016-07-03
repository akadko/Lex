package com.akadko.lex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akadko.lex.Models.Law;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akadko on 02.07.2016.
 */

public class Adapter extends RecyclerView.Adapter  {

    private List<Law> laws = new ArrayList<>();

    public Adapter(List<Law> laws) {
        this.laws.addAll(laws);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recview, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        vh.title.setText(laws.get(position).getName());
        vh.deputy.setText(laws.get(position).getSubject().getDeputies().get(0).getName());
    }

    @Override
    public int getItemCount() {
        return laws.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View v;
        public TextView title;
        public TextView deputy;

        public ViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            title = (TextView) v.findViewById(R.id.title_textview);
            deputy = (TextView) v.findViewById(R.id.deputy);
        }
    }
}
