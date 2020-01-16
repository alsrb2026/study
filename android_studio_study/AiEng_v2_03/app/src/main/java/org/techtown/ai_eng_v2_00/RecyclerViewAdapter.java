package org.techtown.ai_eng_v2_00;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Activity activity;
    private List<Person> person;
    private MainActivity ac;

    public RecyclerViewAdapter(Activity activity, List<Person> person) {
        this.activity = activity;
        this.person = person;
    }

    @Override
    public int getItemCount() {
        return person.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView cardatk;
        TextView cardhp;
        TextView grade;
        ImageView cardimg;

        public ViewHolder(View itemView) {
            super(itemView);
            /*name*/cardatk = (TextView) itemView.findViewById(R.id.cardatk);
            /*number*/cardhp = (TextView) itemView.findViewById(R.id.cardhp);
            grade = itemView.findViewById(R.id.grade);
            cardimg = itemView.findViewById(R.id.cardimage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity, "click " +
                            person.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Toast.makeText(activity, "remove " +
                            person.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    removeItemView(getAdapterPosition());
                    return false;
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // 재활용 되는 View가 호출, Adapter가 해당 position에 해당하는 데이터를 결합
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Person data = person.get(position);

        // 데이터 결합
        holder.cardatk.setText(data.getName());
        holder.cardhp.setText(data.getNumber());
        holder.grade.setText(data.getGrade());
        holder.cardimg.setImageDrawable(data.getCardimage());
    }

    private void removeItemView(int position) {
        person.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, person.size()); // 지워진 만큼 다시 채워넣기.
    }
}