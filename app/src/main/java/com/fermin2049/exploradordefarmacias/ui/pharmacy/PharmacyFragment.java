package com.fermin2049.exploradordefarmacias.ui.pharmacy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.fermin2049.exploradordefarmacias.databinding.FragmentPharmacyBinding;
import com.fermin2049.exploradordefarmacias.model.Pharmacy;
import com.fermin2049.exploradordefarmacias.model.PharmacyAdapter;

import java.util.List;

public class PharmacyFragment extends Fragment {

    private FragmentPharmacyBinding binding;
    private PharmacyViewModel pharmacyViewModel;

    public static PharmacyFragment newInstance() {
        return new PharmacyFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pharmacyViewModel  = new ViewModelProvider(this).get(PharmacyViewModel.class);
        binding = FragmentPharmacyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        pharmacyViewModel.getPharmacy().observe(getViewLifecycleOwner(), new Observer<List<Pharmacy>>() {
            @Override
            public void onChanged(List<Pharmacy> pharmacies) {
                PharmacyAdapter adapter = new PharmacyAdapter(pharmacies, inflater);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.recyclerView.setAdapter(adapter);
                binding.recyclerView.setLayoutManager(gridLayoutManager);
            }
        });

        pharmacyViewModel.loadPharmacy();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pharmacyViewModel = new ViewModelProvider(this).get(PharmacyViewModel.class);
        // TODO: Use the ViewModel
    }
}