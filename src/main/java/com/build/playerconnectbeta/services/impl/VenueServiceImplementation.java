package com.build.playerconnectbeta.services.impl;

import com.build.playerconnectbeta.entity.Venue;
import com.build.playerconnectbeta.entity.VenueMaster;
import com.build.playerconnectbeta.exceptions.ResourceNotFoundException;
import com.build.playerconnectbeta.payload.VenueDto;
import com.build.playerconnectbeta.repository.VenueMasterRepository;
import com.build.playerconnectbeta.repository.VenueRepository;
import com.build.playerconnectbeta.services.VenueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueServiceImplementation implements VenueService {

    @Autowired
    VenueRepository venueRepository;

    @Autowired
    VenueMasterRepository venueMasterRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public VenueDto createVenueByMaster(VenueDto venueDto, int venueMasterId) {
        VenueMaster venueMaster = venueMasterRepository.findById(venueMasterId).orElseThrow(() -> new ResourceNotFoundException("VenueMaster", venueMasterId));
        Venue venue = modelMapper.map(venueDto, Venue.class);
        venue.setVenuemaster(venueMaster);
        Venue savedVenue = venueRepository.save(venue);
        return modelMapper.map(savedVenue, VenueDto.class);
    }
//    User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId));
//    Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));
//    Post post = modelMapper.map(postDto, Post.class);
//		post.setAddedDate(new Date());
//		post.setImgName(uploadImage(file, path));
//		post.setUser(user);
//		post.setCategory(category);
//    Post newPost = postRepo.save(post);
//		return this.modelMapper.map(newPost, PostDto.class);
    @Override
    public List<VenueDto> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return venues.stream()
                .map(venue -> modelMapper.map(venue, VenueDto.class))
                .toList();
    }

    @Override
    public VenueDto createVenue(VenueDto venueDto) {
        Venue venue = modelMapper.map(venueDto, Venue.class);
        Venue savedVenue = venueRepository.save(venue);
        return modelMapper.map(savedVenue, VenueDto.class);
    }

    @Override
    public List<VenueDto> getAllVenuesByMaster(int venueMasterId) {
        VenueMaster venueMaster = venueMasterRepository.findById(venueMasterId)
                .orElseThrow(() -> new ResourceNotFoundException("VenueMaster", venueMasterId));
        List<Venue> venues = venueRepository.findByVenuemaster(venueMaster); // Or findVenueByVenuemaster
        List<VenueDto> venueDtos = venues.stream()
                .map(venue -> modelMapper.map(venue, VenueDto.class))
                .collect(Collectors.toList()); // Use Collectors.toList()

        return venueDtos;
    }

    @Override
    public VenueDto getVenueById(int venueId) {
        Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new ResourceNotFoundException("Venue", venueId));
        return modelMapper.map(venue, VenueDto.class);
    }

    @Override
    public VenueDto updateVenue(int venueid, VenueDto venueDto) {
        Venue venue = venueRepository.findById(venueid).orElseThrow(() -> new ResourceNotFoundException("Venue", venueid));
        venue.setName(venue.getName());
        venue.setAddress(venue.getAddress());
        venue.setGamesAvailable(venue.getGamesAvailable());
        Venue savedVenue = venueRepository.save(venue);
        return modelMapper.map(savedVenue, VenueDto.class);
    }

    @Override
    public void deleteVenue(int venueId) {
        Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new ResourceNotFoundException("Venue", venueId));
        venueRepository.delete(venue);
    }
}
