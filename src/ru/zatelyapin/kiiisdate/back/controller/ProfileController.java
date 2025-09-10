package ru.zatelyapin.kiiisdate.back.controller;

import ru.zatelyapin.kiiisdate.back.model.Profile;
import ru.zatelyapin.kiiisdate.back.service.ProfileService;

public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    public String work(String request) {
        return request;
    }

    public String save(String save) {
        String[] params = save.split(",");

        if (params.length <4) return "bad request";

        Profile profile = new Profile();
        profile.setEmail(params[0]);
        profile.setName(params[1]);
        profile.setSurname(params[2]);
        profile.setAbout(params[3]);

        return service.save(profile).toString();
    }
}
