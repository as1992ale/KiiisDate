package ru.zatelyapin.kiiisdate.back.controller;

import ru.zatelyapin.kiiisdate.back.service.ProfileService;

public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    public String work(String request) {

    }
}
