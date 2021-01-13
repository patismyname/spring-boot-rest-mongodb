package com.pattanaapp.controller;

import com.pattanaapp.model.Profile;
import com.pattanaapp.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping(value = "/profile")
    public List<Profile> getAllprofiles() {

        List<Profile> listProfiles =  profileRepository.findAll();

        return listProfiles;
    }
    @GetMapping(value = "/findAll")
    public Map<String, Object> findAll() {

        List<Profile> profiles =  profileRepository.findAll();
        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("profiles", profiles);
        responseMap.put("status", 200);
        responseMap.put("message", "Success");

        return responseMap;
    }

    @GetMapping(value = "/Profile/{id}")
    public Map<String, Object> findProfile(@PathVariable String id) {

        Optional<Profile> profile = profileRepository.findById(id);
        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("Profile", profile);
        responseMap.put("status", 200);
        responseMap.put("message", "Success");
        return responseMap;
    }

    @PostMapping(value = "/profile")
    public Profile saveProfile(@RequestBody Profile Profile) {
        Profile savedProfile = profileRepository.save(Profile);
        return savedProfile;
    }

    @PostMapping(value = "/saveProfile")
    public Map<String, Object> saveMyProfile(@RequestBody Profile Profile) {
        Profile savedProfile = profileRepository.save(Profile);
        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("Profile", savedProfile);
        responseMap.put("status", 200);
        responseMap.put("message", "Success");
        return responseMap;
    }

    @PutMapping(value = "/profile/{id}")
    public Profile updateProfile(@PathVariable String id, @RequestBody Profile profile) {
        Optional<Profile> prof = profileRepository.findById(id);
        if(profile.getName() != null)
            prof.get().setName(profile.getName());
        if(profile.getEmail() != null)
            prof.get().setEmail(profile.getEmail());
        if(profile.getAge() != null)
            prof.get().setAge(profile.getAge());

        profileRepository.save(prof.get());
        return prof.get();

    }

    @PutMapping(value = "/updateProfile")
    public Map<String, Object> updateThisProfile(@RequestBody Profile profile) {
        Profile updatedProfile = profileRepository.save(profile);
        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("user", updatedProfile);
        responseMap.put("status", 200);
        responseMap.put("message", "Success");
        return responseMap;
    }

    @DeleteMapping(value = "/profile/{id}")
    public boolean deleteProfile(@PathVariable String id) {
      boolean canDelete=false;
        try {
            Optional<Profile> profile = profileRepository.findById(id);
            profileRepository.delete(profile.get());
         if(profile!=null){
             canDelete=true;
         }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return canDelete;
    }


    @DeleteMapping(value = "/deleteProfile/{id}")
    public Map<String, Object> deleteThisProfile(@PathVariable String id) {

        Map<String, Object> responseMap = new HashMap<>();

        try {
            profileRepository.deleteById(id);

            responseMap.put("Profile", true);
            responseMap.put("status", 200);
            responseMap.put("message", "Success");

        } catch (Exception e) {
            responseMap.put("Profile", false);
            responseMap.put("status", 500);
            responseMap.put("message", "Error");
        }

        return responseMap;
    }

}

