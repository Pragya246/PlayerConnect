package com.build.playerconnectbeta.payload;

import com.build.playerconnectbeta.entity.User;
import com.build.playerconnectbeta.entity.VenueMaster;
import lombok.Data;

import java.util.Map;

@Data
public class VenueDto {

    private int venueId;

    private String name;

    private String address;

    private Map<String, String> gamesAvailable;

    private VenueMasterDto venueMaster;

}
