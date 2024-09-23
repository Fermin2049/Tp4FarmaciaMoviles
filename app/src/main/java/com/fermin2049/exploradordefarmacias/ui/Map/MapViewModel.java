package com.fermin2049.exploradordefarmacias.ui.Map;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fermin2049.exploradordefarmacias.model.Pharmacy;
import com.fermin2049.exploradordefarmacias.ui.pharmacy.PharmacyViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapViewModel extends AndroidViewModel {

    private MutableLiveData<MapaActual> mMapaActual;
    private PharmacyViewModel pharmacyViewModel; // ViewModel para obtener las farmacias

    public MapViewModel(@NonNull Application application) {
        super(application);
        pharmacyViewModel = new PharmacyViewModel(application); // Inicializamos PharmacyViewModel
    }

    public LiveData<MapaActual> getMMapaActual() {
        if (mMapaActual == null) {
            mMapaActual = new MutableLiveData<>();
        }
        return mMapaActual;
    }

    public void obtenerMapa() {
        MapaActual mapaActual = new MapaActual();
        mMapaActual.setValue(mapaActual);
    }

    public class MapaActual implements OnMapReadyCallback {

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            // Asegurarse de que las farmacias estén cargadas
            pharmacyViewModel.loadPharmacy();

            // Obtener la lista de farmacias
            List<Pharmacy> pharmacies = pharmacyViewModel.getPharmacy().getValue();
            if (pharmacies != null && !pharmacies.isEmpty()) {
                for (Pharmacy pharmacy : pharmacies) {
                    // Convertir la dirección GPS a LatLng
                    String[] latLng = pharmacy.getGpsAddress().split(", ");
                    if (latLng.length == 2) {
                        LatLng location = new LatLng(Double.parseDouble(latLng[0]), Double.parseDouble(latLng[1]));

                        // Agregar un marcador en el mapa
                        googleMap.addMarker(new MarkerOptions()
                                .position(location)
                                .title(pharmacy.getName())
                                .snippet(pharmacy.getAddress()));
                    }
                }

                // Mover la cámara al primer marcador
                String[] firstLatLng = pharmacies.get(0).getGpsAddress().split(", ");
                LatLng firstLocation = new LatLng(Double.parseDouble(firstLatLng[0]), Double.parseDouble(firstLatLng[1]));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(firstLocation, 12));
            }
        }
    }
}
