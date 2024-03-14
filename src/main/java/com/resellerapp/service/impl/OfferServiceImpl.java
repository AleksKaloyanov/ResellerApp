package com.resellerapp.service.impl;

import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.model.view.BoughtOfferViewModel;
import com.resellerapp.model.view.MyOfferViewModel;
import com.resellerapp.model.view.OtherOfferViewModel;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.service.ConditionService;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ConditionService conditionService;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelMapper modelMapper,
                            UserService userService,
                            ConditionService conditionService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.conditionService = conditionService;
    }

    @Override
    public OfferServiceModel addOffer(OfferServiceModel offerServiceModel) {
        OfferEntity offer = modelMapper.map(offerServiceModel, OfferEntity.class);

        offer
                .setCondition(conditionService.findByName(offerServiceModel.getCondition()))
                .setCreatedBy(userService.findCurrentLoginUserEntity());

        offerRepository.save(offer);

        return modelMapper.map(offer, OfferServiceModel.class);
    }

    @Override
    public List<MyOfferViewModel> findMyOffersView() {
        return offerRepository
                .findAllOffersCreatedByTheCurrentlyLoggedUser(userService.findCurrentLoginUserEntity())
                .stream()
                .map(offer -> modelMapper.map(offer, MyOfferViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public List<OtherOfferViewModel> findOtherOffers() {
        return offerRepository
                .findAllOffersCreatedByOtherUsers(userService.findCurrentLoginUserEntity())
                .stream()
                .map(offer -> modelMapper.map(offer, OtherOfferViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buy(Long id) {
        OfferEntity offer = offerRepository
                .findById(id)
                .orElse(null);
        if (offer != null) {
            offer.setBoughtBy(userService.findCurrentLoginUserEntity());
            offerRepository.save(offer);
        }
    }

    @Override
    public List<BoughtOfferViewModel> findBoughtOffers() {
        return offerRepository
                .findAllByBoughtBy(userService.findCurrentLoginUserEntity())
                .stream()
                .map(offerEntity -> modelMapper.map(offerEntity, BoughtOfferViewModel.class))
                .collect(Collectors.toList());
    }
}
