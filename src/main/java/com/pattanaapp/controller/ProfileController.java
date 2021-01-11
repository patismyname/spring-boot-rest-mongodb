package com.pattanaapp.controller;

import com.pattanaapp.model.Profile;
import com.pattanaapp.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> findProfile(@PathVariable int id) {

        Profile profile = profileRepository.findById(id);
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

    @PutMapping(value = "/profile")
    public Profile updateProfile(@RequestBody Profile profile) {
        Profile updatedProfile = profileRepository.save(profile);
        return updatedProfile;
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
    public boolean deleteProfile(@PathVariable int id) {
      boolean canDelete=false;
        try {
         Long longDelById=   profileRepository.deleteById(id);

         if(longDelById!=null){
             canDelete=true;
         }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return canDelete;
    }


    @DeleteMapping(value = "/deleteProfile/{id}")
    public Map<String, Object> deleteThisProfile(@PathVariable int id) {

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

