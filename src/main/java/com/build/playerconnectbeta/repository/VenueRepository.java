package com.build.playerconnectbeta.repository;

import com.build.playerconnectbeta.entity.Venue;
import com.build.playerconnectbeta.entity.VenueMaster;
import com.build.playerconnectbeta.payload.VenueDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Integer> {

    List<Venue> findByVenuemaster(VenueMaster venueMaster);
}
