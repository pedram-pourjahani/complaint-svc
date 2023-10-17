package org.taba.msaapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.taba.msaapp.service.api.FirstService;

import static org.taba.msaapp.utils.AppConstants.CURRENT_USER;

@RestController
@RequestMapping("")
public class BasicController {

    private final FirstService firstService;

    public BasicController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("viewProfile")
    ResponseEntity<?> viewProfile(@SessionAttribute(CURRENT_USER) String nationalCode){
        return null;
    }
}
