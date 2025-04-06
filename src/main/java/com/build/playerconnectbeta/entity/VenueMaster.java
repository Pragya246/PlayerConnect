package com.build.playerconnectbeta.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class VenueMaster {
    @Id
    @GeneratedValue(generator = "VenueMasterSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "VenueMasterSeq", allocationSize = 1)
    private int id;

    private String name;
    private String phoneNo;
    private String address;

    @OneToMany(mappedBy = "venuemaster")
    @JoinColumn(name = "venue_id")
    private List<Venue> venues;
}
