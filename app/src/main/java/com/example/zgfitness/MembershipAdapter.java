package com.example.zgfitness;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MembershipAdapter extends RecyclerView.Adapter<MembershipAdapter.MyViewHolder> {

    Context c1;
    List<Membership> membershipList;
    public MembershipAdapter(Context c1, List<Membership> membershipList)
    {
        this.c1 = c1;
        this.membershipList = membershipList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView desc;
        TextView monthlyFee;
        ImageView image;

        public MyViewHolder (@NonNull View v)
        {
            super(v);
            name = v.findViewById(R.id.txtName);
            desc = v.findViewById(R.id.txtDescription);
            monthlyFee = v.findViewById(R.id.txtMonthlyFee);
            image = v.findViewById(R.id.image1);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent i =  new Intent(c1, MembershipDetails.class);
            i.putExtra("Name", membershipList.get(position).getName());
            i.putExtra("Desc", membershipList.get(position).getDescription());
            i.putExtra("Facilities", membershipList.get(position).getFacilities());
            i.putExtra("Img", membershipList.get(position).getImg());
            i.putExtra("AdmissionFee", membershipList.get(position).getAdmissionFee());
            i.putExtra("MonthlyFee", membershipList.get(position).getMonthlyFee());
            i.putExtra("Commitment", membershipList.get(position).getCommitment());
            c1.startActivity(i);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c1).inflate(R.layout.item_list , parent , false);
        return new MyViewHolder(view);
    }

    //View Holder
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //Assigning the Values in the Movies List Page.
        String name = membershipList.get(position).getName();
        String desc = membershipList.get(position).getDescription();
        String monthlyFee = membershipList.get(position).getMonthlyFee();
        int img = membershipList.get(position).getImg();

        holder.name.setText(name);
        holder.desc.setText(desc);
        holder.monthlyFee.setText(monthlyFee);
        holder.image.setImageResource(img);
    }

    //Counting the number of Items
    @Override
    public int getItemCount() {
        return membershipList.size();
    }
}
