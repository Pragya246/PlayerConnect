package com.build.playerconnectbeta.controller;

import com.build.playerconnectbeta.payload.ApiResponse;
import com.build.playerconnectbeta.payload.VenueDto;
import com.build.playerconnectbeta.services.VenueService;
import jakarta.validation.Valid;
import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VenueController {

    @Autowired
    VenueService venueService;

    @PostMapping("/createvenue/{venueMasterId}")
    public ResponseEntity<VenueDto> createVenueForMaster(
            @PathVariable int venueMasterId,
            @Valid @RequestBody VenueDto venueDto) { // Use @Valid for potential DTO validation annotations

        VenueDto createdVenue = venueService.createVenueByMaster(venueDto, venueMasterId);

        return new ResponseEntity<>(createdVenue, HttpStatus.CREATED); // Return 201 Created
    }

    /**
     * GET /api/venue-masters/{venueMasterId}/venues
     * Retrieves all Venues associated with a specific VenueMaster.
     */
    @GetMapping("/getvenuebymaster/{venueMasterId}")
    public ResponseEntity<List<VenueDto>> getVenuesByMaster(@PathVariable int venueMasterId) {
        List<VenueDto> venues = venueService.getAllVenuesByMaster(venueMasterId);
        if (venues.isEmpty()) {
            // You might return 204 No Content or an empty list with 200 OK
            // depending on your preference. 200 OK is common.
            return ResponseEntity.ok(venues);
        }
        return ResponseEntity.ok(venues); // Return 200 OK
    }


    @PostMapping("/venues")
    public ResponseEntity<VenueDto> createStandaloneVenue(@Valid @RequestBody VenueDto venueDto) {
        VenueDto createdVenue = venueService.createVenue(venueDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/venues/{id}")
                .buildAndExpand(createdVenue.getVenueId()).toUri();

        return ResponseEntity.created(location).body(createdVenue); // Return 201 Created
    }

    /**
     * GET /api/venues
     * Retrieves a list of all Venues.
     */
    @GetMapping("/venues")
    public ResponseEntity<List<VenueDto>> getAllVenues() {
        List<VenueDto> venues = venueService.getAllVenues();
        return ResponseEntity.ok(venues); // Return 200 OK
    }

    /**
     * GET /api/venues/{venueId}
     * Retrieves a specific Venue by its ID.
     */
    @GetMapping("/venues/{venueId}")
    public ResponseEntity<VenueDto> getVenueById(@PathVariable int venueId) {
        VenueDto venue = venueService.getVenueById(venueId);
        // ResourceNotFoundException should handle the 404 case via ControllerAdvice
        return ResponseEntity.ok(venue); // Return 200 OK
    }

    /**
     * PUT /api/venues/{venueId}
     * Updates an existing Venue identified by venueId.
     * Note: The service method signature 'updateVenue(int venueMasterId, VenueDto venue)' is slightly unusual
     * for a PUT request on /venues/{venueId}. This implementation assumes the venueMasterId
     * needed for the update logic is passed within the request body (venueDto).
     * If venueMasterId *must* be passed separately, consider using @RequestParam or redesigning the service method/endpoint.
     */
    @PutMapping("/venues/{venueId}")
    public ResponseEntity<VenueDto> updateVenue(
            @PathVariable int venueId,
            @Valid @RequestBody VenueDto venueDto) {
        VenueDto updatedVenue = venueService.updateVenue(venueId, venueDto);
        return ResponseEntity.ok(updatedVenue);

    }

    @DeleteMapping("/venues/{venueId}")
    public ResponseEntity<ApiResponse> deleteVenue(@PathVariable int venueId) {
        venueService.deleteVenue(venueId);
        return  ResponseEntity.ok(new ApiResponse(String.format("Venue with id %d deleted successfully", venueId),true)); // Return 204 No Content
    }
}
