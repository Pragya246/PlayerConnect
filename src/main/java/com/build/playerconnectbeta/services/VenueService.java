package com.build.playerconnectbeta.services;

import com.build.playerconnectbeta.payload.VenueDto;

import java.util.List;

public interface VenueService {

    VenueDto createVenueByMaster(VenueDto venue, int venueMasterId);
    List<VenueDto> getAllVenues();

    VenueDto createVenue(VenueDto venueDto);

    List<VenueDto> getAllVenuesByMaster(int venueMasterId);

    VenueDto getVenueById(int venueId);
    VenueDto updateVenue(int venue, VenueDto venueDto);
    void deleteVenue(int venueId);
}
