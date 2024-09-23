package com.fermin2049.exploradordefarmacias.ui.Map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fermin2049.exploradordefarmacias.R;
import com.fermin2049.exploradordefarmacias.databinding.FragmentMapBinding;
import com.google.android.gms.maps.SupportMapFragment;


public class MapFragment extends Fragment {

    private FragmentMapBinding binding;
    private MapViewModel mapViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MapViewModel mapViewModel =
                new ViewModelProvider(this).get(MapViewModel.class);

        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mapViewModel.getMMapaActual().observe(getViewLifecycleOwner(),mapaActual -> {
        ((SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map)).getMapAsync(mapaActual);
        });
        mapViewModel.obtenerMapa();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}