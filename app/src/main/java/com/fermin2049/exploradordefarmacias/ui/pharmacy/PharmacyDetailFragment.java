package com.fermin2049.exploradordefarmacias.ui.pharmacy;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fermin2049.exploradordefarmacias.R;
import com.fermin2049.exploradordefarmacias.databinding.FragmentPharmacyDetailBinding;

public class PharmacyDetailFragment extends Fragment {

    private PharmacyDetailViewModel mViewModel;
    private FragmentPharmacyDetailBinding binding;

    public static PharmacyDetailFragment newInstance() {
        return new PharmacyDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel=new ViewModelProvider(this).get(PharmacyDetailViewModel.class);
        binding=FragmentPharmacyDetailBinding.inflate(inflater, container, false);
        View root=binding.getRoot();
        mViewModel.getPharmacyMutableLiveData().observe(getViewLifecycleOwner(), pharmacy -> {
            binding.pharmacyName.setText(pharmacy.getName());
            binding.pharmacyAddress.setText(pharmacy.getAddress());
            binding.pharmacyPhone.setText(pharmacy.getPhone());
            binding.pharmacySchedule.setText(pharmacy.getSchedule());
            binding.pharmacyImage.setImageResource(pharmacy.getImage());
            binding.pharmacyEmail.setText(pharmacy.getEmail());
            binding.pharmacyGps.setText(pharmacy.getGpsAddress());
            binding.pharmacyWebsite.setText(pharmacy.getWebsite());
            binding.pharmacyServices.setText(pharmacy.getServices());
        });
        mViewModel.receivePharmacy(getArguments());
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PharmacyDetailViewModel.class);
        // TODO: Use the ViewModel
    }

}