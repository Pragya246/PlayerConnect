package com.build.playerconnectbeta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VenueMaster {
    @Id
    @GeneratedValue(generator = "VenueMasterSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "VenueMasterSeq", allocationSize = 1)
    private int venue_master_id;

    private String name;
    private String phoneNo;
    private String address;

    @OneToMany(mappedBy = "venuemaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Venue> venues = new ArrayList<>();
}
