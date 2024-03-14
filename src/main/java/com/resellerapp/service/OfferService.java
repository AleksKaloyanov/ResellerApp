package com.resellerapp.service;

import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.model.view.BoughtOfferViewModel;
import com.resellerapp.model.view.MyOfferViewModel;
import com.resellerapp.model.view.OtherOfferViewModel;

import java.util.List;

public interface OfferService {
    OfferServiceModel addOffer(OfferServiceModel offerServiceModel);


    List<MyOfferViewModel> findMyOffersView();

    void remove(Long id);

    List<OtherOfferViewModel> findOtherOffers();

    void buy(Long id);

    List<BoughtOfferViewModel> findBoughtOffers();
}
