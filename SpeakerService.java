package com.examly.demo.Service;

import com.examly.demo.Model.Speaker;
import com.examly.demo.Repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    // Create Speaker
    public Speaker saveSpeaker(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    // Get All Speakers with Pagination & Sorting
    public Page<Speaker> getAllSpeakers(Pageable pageable) {
        return speakerRepository.findAll(pageable);
    }

    // Get Speaker by ID
    public Optional<Speaker> getSpeakerById(Long id) {
        return speakerRepository.findById(id);
    }

    // Find Speakers by Name
    public List<Speaker> findByName(String name) {
        return speakerRepository.findByName(name);
    }

    // Find Speakers by Topic
    public List<Speaker> findByTopic(String topic) {
        return speakerRepository.findByTopic(topic);
    }

    // Count Speakers by Topic
    public Long countByTopic(String topic) {
        return speakerRepository.countByTopic(topic);
    }

    // Update Speaker by ID
    public Speaker updateSpeaker(Long id, Speaker updatedSpeaker) {
        Speaker existingSpeaker = speakerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Speaker not found"));

        existingSpeaker.setName(updatedSpeaker.getName());
        existingSpeaker.setTopic(updatedSpeaker.getTopic());
        existingSpeaker.setExperience(updatedSpeaker.getExperience());

        return speakerRepository.save(existingSpeaker);
    }

    // Delete Speaker
    public void deleteSpeaker(Long id) {
        speakerRepository.deleteById(id);
    }
}
