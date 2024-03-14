package com.resellerapp.controller;

import com.resellerapp.model.binding.OfferAddBindingModel;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.service.OfferService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public OfferController(OfferService offerService,
                           ModelMapper modelMapper,
                           CurrentUser currentUser) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() == null) {
            return "redirect:/";
        }
        return "offer-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid OfferAddBindingModel offerAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes rAtt) {
        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("offerAddBindingModel", offerAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);

            return "redirect:add";
        }

        offerService.addOffer(modelMapper.map(offerAddBindingModel, OfferServiceModel.class));

        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        offerService.remove(id);
        return "redirect:/home";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id) {
        offerService.buy(id);

        return "redirect:/home";
    }

    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }
}
