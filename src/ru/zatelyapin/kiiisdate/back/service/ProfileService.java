package ru.zatelyapin.kiiisdate.back.service;

import ru.zatelyapin.kiiisdate.back.dao.ProfileDao;
import ru.zatelyapin.kiiisdate.back.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfileService {

    private final ProfileDao dao;

    public ProfileService(ProfileDao dao) {
        this.dao = dao;
    }

    public Profile save(Profile profile){
        return dao.save(profile);
    }

    public Optional<Profile> findById(Long id){
        if(id == null) return Optional.empty();
        return dao.findById(id);
    }

    public List<Profile> findAll(){return dao.findAll();}

    public boolean delete(Long id){
        if (id == null || id <= 0)return false;
        return dao.deleteById(id);
    }

    public boolean update(Long id){
        if (id == null) return false;
        return true;
    }



    //TODO delete, update, findAll


}
