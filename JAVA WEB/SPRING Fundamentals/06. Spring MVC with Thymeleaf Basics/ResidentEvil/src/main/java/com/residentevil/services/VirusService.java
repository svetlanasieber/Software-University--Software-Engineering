package com.residentevil.services;

import com.residentevil.models.VirusBindingModel;

public interface VirusService {

    void create(VirusBindingModel virusBindingModel);

    String getGeoData();
}
