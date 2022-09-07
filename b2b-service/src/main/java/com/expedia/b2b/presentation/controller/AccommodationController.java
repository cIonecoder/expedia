package com.expedia.b2b.presentation.controller;

import com.expedia.b2b.application.dto.RequestSaveAccommodationDto;
import com.expedia.b2b.domain.accommodation.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accommodation")
public class AccommodationController {
    private final AccommodationService accommodationService;

    @PostMapping("")
    public String saveAccommodation(RequestSaveAccommodationDto requestSaveAccommodationDto) {
        return "";
    }
}
