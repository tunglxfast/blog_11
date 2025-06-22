package com.lab231.myblog.service;

import com.lab231.myblog.model.Advertisement;
import com.lab231.myblog.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public Advertisement getFirstAdvertisement() {
        List<Advertisement> adList = advertisementRepository.findAll();
        if (adList.isEmpty()){
            return null;
        }
        return adList.get(0);
    }
} 