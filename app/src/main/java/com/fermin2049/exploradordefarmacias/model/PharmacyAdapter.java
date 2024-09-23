package com.fermin2049.exploradordefarmacias.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.fermin2049.exploradordefarmacias.R;

import java.util.List;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.ViewHolderPharmacy> {

    private List<Pharmacy> pharmacies;
    private LayoutInflater li;

    public PharmacyAdapter(List<Pharmacy> pharmacies, LayoutInflater li) {
        this.pharmacies = pharmacies;
        this.li = li;
    }

    @NonNull
    @Override
    public PharmacyAdapter.ViewHolderPharmacy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.card_pharmacy, parent, false);
        return new ViewHolderPharmacy(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PharmacyAdapter.ViewHolderPharmacy holder, int position) {
        Pharmacy pharmacy = pharmacies.get(position);
        holder.pharmacyName.setText(pharmacy.getName());
        holder.pharmacyAddress.setText(pharmacy.getAddress());
        holder.pharmacyImage.setImageResource(pharmacy.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Bundle bundle = new Bundle();
                 bundle.putSerializable("pharmacy", pharmacy);
                 Navigation.findNavController(v).navigate(R.id.pharmacyDetailFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pharmacies.size();
    }

    public class ViewHolderPharmacy extends RecyclerView.ViewHolder {
        TextView pharmacyName;
        TextView pharmacyAddress;
        ImageView pharmacyImage;

        public ViewHolderPharmacy(@NonNull View itemView) {
            super(itemView);
            pharmacyName = itemView.findViewById(R.id.pharmacy_name);
            pharmacyAddress = itemView.findViewById(R.id.pharmacy_address);
            pharmacyImage = itemView.findViewById(R.id.pharmacy_image);
        }
    }
}