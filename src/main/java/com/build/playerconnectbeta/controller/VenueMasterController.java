package com.build.playerconnectbeta.controller;

import com.build.playerconnectbeta.payload.ApiResponse;
import com.build.playerconnectbeta.payload.VenueMasterDto;
import com.build.playerconnectbeta.services.VenueMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class VenueMasterController {

    @Autowired
    private VenueMasterService venueMasterService;

    @PostMapping("/create/venue-master")
    ResponseEntity<VenueMasterDto> createVenueMaster(@RequestBody VenueMasterDto venueMasterDto) {
        VenueMasterDto createdVenueMaster = venueMasterService.createVenueMaster(venueMasterDto);
        return new ResponseEntity<>(createdVenueMaster, HttpStatus.CREATED);
    }

    @PutMapping("/updatevenuemaster/{venuemasterid}")
    ResponseEntity<ApiResponse> updateVenueMaster(@RequestBody VenueMasterDto venueMasterDto, @PathVariable int venuemasterid) {
        VenueMasterDto updatedVenueMaster = venueMasterService.updateVenueMaster(venuemasterid, venueMasterDto);
        return ResponseEntity.ok(new ApiResponse("Venue master updated successfully", true));
    }

    @GetMapping("/getvenuemaster/{venuemasterid}")
    ResponseEntity<VenueMasterDto> getVenueMaster(@PathVariable int venuemasterid) {
        VenueMasterDto venueMasterDto = venueMasterService.getVenueMasterById((venuemasterid));
        return ResponseEntity.ok(venueMasterDto);
    }

    @DeleteMapping("/deletevenuemaster/{venuemasterid}")
    ResponseEntity<ApiResponse> deleteVenueMaster(@PathVariable int venuemasterid) {
        venueMasterService.deleteVenueMaster(venuemasterid);
        return ResponseEntity.ok(new ApiResponse(String.format("Venue master with id %d deleted successfully", venuemasterid), true));
    }

}
