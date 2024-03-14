package com.resellerapp.controller;

import com.resellerapp.service.OfferService;
import com.resellerapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final OfferService offerService;
    private final CurrentUser currentUser;

    public HomeController(OfferService offerService, CurrentUser currentUser) {
        this.offerService = offerService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index() {
        if (currentUser.getId() != null) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (currentUser.getId() == null) {
            return "redirect:/";
        }

        model.addAttribute("myOffers", offerService.findMyOffersView());
        model.addAttribute("otherOffers", offerService.findOtherOffers());
        model.addAttribute("boughtOffers", offerService.findBoughtOffers());

        return "home";
    }
}
