package ru.zatelyapin.kiiisdate.back.dao;

import ru.zatelyapin.kiiisdate.back.model.Profile;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProfileDao {

    private final ConcurrentHashMap<Long, Profile> storage;

    private final AtomicLong idStorage;

    public ProfileDao(){
        this.storage = new ConcurrentHashMap<>();
        this.idStorage = new AtomicLong();
    }

    public  Profile save(Profile profile){
        long id = idStorage.incrementAndGet();
        profile.setId(id);
        storage.put(id, profile);
        return profile;
    }

    public Optional<Profile> findById(long id){return Optional.ofNullable(storage.get(id));}

    public List<Profile> findAll(){return new ArrayList<>(storage.values());}

    public void update(Profile profile){
        Long id = profile.getId();
        if (id == null) return;
        storage.put(id, profile);
    }

    public boolean deleteById(long id){return storage.remove(id) != null;}





    //TODO delete, update, findAll
}
