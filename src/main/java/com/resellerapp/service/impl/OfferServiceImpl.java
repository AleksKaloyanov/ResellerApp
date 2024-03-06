package com.resellerapp.service.impl;

import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelMapper modelMapper,
                            CurrentUser currentUser,
                            UserService userService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public OfferServiceModel addOffer(OfferServiceModel offerServiceModel) {
        OfferEntity offer = modelMapper.map(offerServiceModel, OfferEntity.class);
        offer.setCreatedBy(userService.findById(currentUser.getId()));

        offerRepository.save(offer);

        return null;
    }
}
