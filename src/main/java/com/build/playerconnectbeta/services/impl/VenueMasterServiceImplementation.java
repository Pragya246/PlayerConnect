package com.build.playerconnectbeta.services.impl;

import com.build.playerconnectbeta.entity.VenueMaster;
import com.build.playerconnectbeta.exceptions.ResourceNotFoundException;
import com.build.playerconnectbeta.payload.ApiResponse;
import com.build.playerconnectbeta.payload.VenueMasterDto;
import com.build.playerconnectbeta.repository.VenueMasterRepository;
import com.build.playerconnectbeta.services.VenueMasterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueMasterServiceImplementation implements VenueMasterService {

    @Autowired
    VenueMasterRepository venueMasterRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public VenueMasterDto createVenueMaster(VenueMasterDto venueMaster) {
        VenueMaster venueMasterEntity = modelMapper.map(venueMaster, VenueMaster.class);
        VenueMaster savedVenueMaster = venueMasterRepository.save(venueMasterEntity);
        return modelMapper.map(savedVenueMaster, VenueMasterDto.class);
    }

    @Override
    public VenueMasterDto createVenue(VenueMasterDto venueMaster) {
        VenueMaster venueMasterEntity = modelMapper.map(venueMaster, VenueMaster.class);

    }

    @Override
    public List<VenueMasterDto> getAllVenues() {
        List<VenueMaster> venueMasters = venueMasterRepository.findAll();
        return venueMasters.stream()
                .map(venueMaster -> modelMapper.map(venueMaster, VenueMasterDto.class))
                .toList();
    }

    @Override
    public VenueMasterDto getVenueById(int id) {
        VenueMaster venueMaster = venueMasterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("venue master",id));
        return modelMapper.map(venueMaster, VenueMasterDto.class);
    }

    @Override
    public VenueMasterDto updateVenue(int id, VenueMasterDto venueMasterDto) {
        VenueMaster venueMaster1 = venueMasterRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("venue master", id));
        venueMaster1.setName(venueMasterDto.getName());
        venueMaster1.setAddress(venueMasterDto.getAddress());
        venueMaster1.setPhoneNo(venueMasterDto.getPhoneNo());
        return modelMapper.map(venueMasterRepository.save(venueMaster1), VenueMasterDto.class);
    }

    @Override
    public void deleteVenue(int id) {
        VenueMaster venueMaster = venueMasterRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("venue master", id));
        venueMasterRepository.delete(venueMaster);
    }
}
