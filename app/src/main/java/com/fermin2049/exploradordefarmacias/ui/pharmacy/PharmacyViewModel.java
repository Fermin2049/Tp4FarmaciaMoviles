package com.fermin2049.exploradordefarmacias.ui.pharmacy;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fermin2049.exploradordefarmacias.R;
import com.fermin2049.exploradordefarmacias.model.Pharmacy;

import java.util.ArrayList;
import java.util.List;

public class PharmacyViewModel extends AndroidViewModel {
    private final MutableLiveData<List<Pharmacy>> mPharmacy = new MutableLiveData<>();

    public PharmacyViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<List<Pharmacy>> getPharmacy(){
        return mPharmacy;
    }

    public void loadPharmacy(){
        ArrayList<Pharmacy> pharmacies = new ArrayList<>();

        pharmacies.add(new Pharmacy(
                "Farmacia Los Alamos",
                "San Martín 502, Ciudad de San Luis, San Luis",
                "-33.300242, -66.336522",
                "+54 9 2664 21-6492",
                "contacto@farmacialosalamos.com.ar",
                "https://www.farmacialosalamos.com.ar",
                "Lunes a Sábado 8:00 - 20:00",
                "Venta de medicamentos, cuidado personal, dermocosmética",
                R.drawable.farmacia_los_alamos
        ));

        pharmacies.add(new Pharmacy(
                "Farmacias Quintana",
                "Pte. Arturo Illia 216, San Luis Capital, San Luis",
                "-33.302045, -66.338125",
                "+54 2664 42-8382",
                "info@farmaciaquintana.com.ar",
                "https://www.farmaciaquintana.com.ar",
                "Lunes a Sábado 9:00 - 21:00",
                "Medicamentos, perfumería, productos de salud",
                R.drawable.farmacia_quintana
        ));

        pharmacies.add(new Pharmacy(
                "Farmacia San Isidro",
                "General Paz 443, Ciudad de San Luis, San Luis",
                "-33.302506, -66.336930",
                "+54 266 442-8157",
                "info@farmaciasanisidro.com.ar",
                "https://www.farmaciasanisidro.com.ar",
                "Lunes a Viernes 8:30 - 21:00",
                "Medicamentos, atención personalizada",
                R.drawable.farmacia_san_isidro
        ));

        pharmacies.add(new Pharmacy(
                "Farmacia Santa María",
                "Avenida Perón 1200, Juana Koslay, San Luis",
                "-33.234443, -66.269242",
                "+54 266 449-0432",
                "info@farmaciasantamaria.com",
                "https://ar.polomap.com/san-luis/10935",
                "Lunes a Domingo 8:30 - 22:00",
                "Farmacia, productos de higiene y cuidado",
                R.drawable.farmacia_santa_maria
        ));

        pharmacies.add(new Pharmacy(
                "Farmacity San Luis",
                "Ciudad del Rosario 360, San Luis",
                "-33.307998, -66.341591",
                "+54 266 442-7895",
                "contacto@farmacity.com.ar",
                "https://www.farmacity.com",
                "Lunes a Sábado 9:00 - 21:00",
                "Medicamentos, perfumería, cosmética",
                R.drawable.farmacity_san_luis
        ));
        mPharmacy.setValue(pharmacies);
    }

}