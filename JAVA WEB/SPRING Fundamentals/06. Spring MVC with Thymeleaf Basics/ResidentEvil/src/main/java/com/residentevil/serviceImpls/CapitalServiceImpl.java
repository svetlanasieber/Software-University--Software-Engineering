package com.residentevil.serviceImpls;

import com.residentevil.entities.Capital;
import com.residentevil.repositories.CapitalRepository;
import com.residentevil.services.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CapitalServiceImpl implements CapitalService {

    private final CapitalRepository capitalRepository;

    @Autowired
    public CapitalServiceImpl(CapitalRepository capitalRepository) {
        this.capitalRepository = capitalRepository;
    }

    @Override
    public List<String> getCapitals() {
        List<Capital> all = capitalRepository.findAll();
        List<String> result = new ArrayList<>();
        for (Capital c : all) {
            result.add(c.getName());
        }

        return result;
    }
}
