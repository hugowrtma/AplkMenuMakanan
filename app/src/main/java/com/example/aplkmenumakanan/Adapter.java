package com.example.aplkmenumakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    String data2[],data3[],data4[];
    int image[];
    Context context;

    public Adapter(Context ct, String s2[], String s3[],String s4[], int img[]){
        context = ct;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        image = img;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_rows, parent, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.myText2.setText(data2[position]);
        holder.myText3.setText(data3[position]);
        holder.myImage.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myText2, myText3;
        ImageView myImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myText2 = itemView.findViewById(R.id.myText2);
            myText3 = itemView.findViewById(R.id.myText3);
            myImage = itemView.findViewById(R.id.myImageView1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, DescriptionActivity.class);
            intent.putExtra("Produk", data2[position]);
            intent.putExtra("Harga", data3[position]);
            intent.putExtra("Description", data4[position]);
            intent.putExtra("Image", image[position]);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}