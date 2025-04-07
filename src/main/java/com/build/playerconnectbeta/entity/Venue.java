package com.build.playerconnectbeta.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Venue {
    @Id
    @GeneratedValue
    private Long venueId;

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "id")
    private VenueMaster venuemaster;

    @ElementCollection
    private List<String> gamesAvailable;
}
