package com.careerpath.profile.sevice;

import com.careerpath.profile.entity.Profile;
import com.careerpath.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Optional<Profile> getProfileByUserId(Long userId) {
        return profileRepository.findByUserUserId(userId);
    }
}
