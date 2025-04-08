package com.build.playerconnectbeta.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Entity
@Data
public class Venue {
    @Id
    @GeneratedValue(generator = "VenueSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "VenueSeq", allocationSize = 1)
    private int venueId;

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "venueMasterId")
    private VenueMaster venuemaster;

    @ElementCollection
    private Map<String, String> gamesAvailable;
}
