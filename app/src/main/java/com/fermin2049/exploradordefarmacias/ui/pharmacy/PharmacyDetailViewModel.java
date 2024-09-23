package com.fermin2049.exploradordefarmacias.ui.pharmacy;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.fermin2049.exploradordefarmacias.model.Pharmacy;

public class PharmacyDetailViewModel extends AndroidViewModel {
    private final MutableLiveData<Pharmacy> pharmacyMutableLiveData = new MutableLiveData<>();

    public PharmacyDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Pharmacy> getPharmacyMutableLiveData() {
        return pharmacyMutableLiveData;
    }

    public void receivePharmacy(Bundle bundle) {
        Pharmacy pharmacy = (Pharmacy) bundle.getSerializable("pharmacy");
        if (pharmacy != null) {
            pharmacyMutableLiveData.setValue(pharmacy);
        }
    }
}