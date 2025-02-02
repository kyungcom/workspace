package com.careerpath.profile.sevice;

import com.careerpath.profile.dto.EducationRequestDto;
import com.careerpath.profile.dto.ExperienceRequestDto;
import com.careerpath.profile.dto.ProfileResponseDto;
import com.careerpath.profile.entity.Education;
import com.careerpath.profile.entity.Experience;
import com.careerpath.profile.repository.EducationRepository;
import com.careerpath.profile.repository.ExperienceRepository;
import com.careerpath.profile.dto.ProfileRequestDto;
import com.careerpath.profile.entity.Profile;
import com.careerpath.profile.repository.ProfileRepository;
import com.careerpath.user.security.UserDetailImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ExperienceRepository experienceRespository;
    private final EducationRepository educationRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, ExperienceRepository experienceRespository,
                          EducationRepository educationRepository) {
        this.profileRepository = profileRepository;
        this.experienceRespository = experienceRespository;
        this.educationRepository = educationRepository;
    }

    public ProfileResponseDto getProfileResponseDtoByUserId(Long userId) {
        Profile profile = profileRepository.findProfileByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("UserId에 매핑되는 프로필이 없습니다."));

        return new ProfileResponseDto(profile);
    }

    public void addProfile(ProfileRequestDto profileRequestDto, UserDetailImpl user) {
        Profile profile = Profile.builder()
                .skills(profileRequestDto.getSkills())
                .bio(profileRequestDto.getBio())
                .company(profileRequestDto.getCompany())
                .website(profileRequestDto.getWebsite())
                .location(profileRequestDto.getLocation())
                .status(profileRequestDto.getStatus())
                .user(user.getUser())
                .build();

        profileRepository.save(profile);
    }

    public void addExperience(ExperienceRequestDto experienceRequestDto, UserDetailImpl user) {
        Profile profile = user.getUser().getProfile();
        Experience experience = Experience.builder()
                .title(experienceRequestDto.getTitle())
                .from(experienceRequestDto.getFrom())
                .to(experienceRequestDto.getTo())
                .company(experienceRequestDto.getCompany())
                .position(experienceRequestDto.getPosition())
                .description(experienceRequestDto.getDescription())
                .current(experienceRequestDto.getCurrent())
                .profile(profile)
                .build();

        experienceRespository.save(experience);
    }

    public void addEducation(EducationRequestDto educationRequestDto, UserDetailImpl user) {
        Profile profile = user.getUser().getProfile();
        Education education = Education.builder()
                .school(educationRequestDto.getSchool())
                .degree(educationRequestDto.getDegree())
                .fieldOfStudy(educationRequestDto.getFieldOfStudy())
                .from(educationRequestDto.getFrom())
                .to(educationRequestDto.getTo())
                .current(educationRequestDto.getCurrent())
                .profile(profile)
                .build();

        educationRepository.save(education);
    }

    public void deleteEducation(Long educationId) {
        Education education = educationRepository.findById(educationId)
                .orElseThrow(() -> new EntityNotFoundException("Education not found"));

        educationRepository.delete(education);
    }

    public void deleteExperience(Long experienceId) {
        Experience experience = experienceRespository.findById(experienceId)
                .orElseThrow(() -> new EntityNotFoundException("Experience not found"));

        experienceRespository.delete(experience);
    }
}
