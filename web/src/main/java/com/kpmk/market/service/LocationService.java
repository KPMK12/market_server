package com.kpmk.market.service;

import com.kpmk.market.domain.Location;
import com.kpmk.market.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public Location findOne(Long locationId){
        return locationRepository.findOne(locationId);
    }

    public Location findByLocation(String city, String gu, String dong){
        return locationRepository.findByLocation(city, gu, dong);
    }

    public List<String> findAllCity(){
        return locationRepository.findAllCity();
    }

    public List<String> findAllGu(){
        return locationRepository.findAllGu();
    }

    public List<String> findAllDong(){
        return locationRepository.findAllDong();
    }
}
