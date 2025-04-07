package com.build.playerconnectbeta.services;

import com.build.playerconnectbeta.entity.VenueMaster;
import com.build.playerconnectbeta.payload.ApiResponse;
import com.build.playerconnectbeta.payload.VenueMasterDto;

import java.util.List;

public interface VenueMasterService {

    VenueMasterDto createVenueMaster(VenueMasterDto venueMaster);
    // Method to create a new venue
    VenueMasterDto createVenue(VenueMasterDto venueMaster);

    // Method to get all venues
    List<VenueMasterDto> getAllVenues();

    // Method to get a venue by ID
    VenueMasterDto getVenueById(int id);

    // Method to update a venue
    VenueMasterDto updateVenue(int id, VenueMasterDto venueMaster);

    // Method to delete a venue
    void deleteVenue(int id);
}
