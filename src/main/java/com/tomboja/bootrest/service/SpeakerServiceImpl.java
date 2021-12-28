package com.tomboja.bootrest.service;

import com.tomboja.bootrest.domain.Speaker;
import com.tomboja.bootrest.exceptions.ResourceNotFoundException;
import com.tomboja.bootrest.repo.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/27/21
 */

@Service
@Transactional
@RequiredArgsConstructor
public class SpeakerServiceImpl implements SpeakerService{

    private final SpeakerRepository speakerRepository;

    @Override
    public List<Speaker> listSpeakers() {
        return speakerRepository.findAll();
    }

    private Optional<Speaker> get(Long id, String method) {
        String crudMethod = method == null ? "GET" : method;
        return Optional.ofNullable(speakerRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Speaker", "Id", id, crudMethod)));
    }

    @Override
    public Optional<Speaker> getSpeaker(Long id) {
        return get(id, "GET");
    }

    @Override
    public Speaker saveSpeaker(Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @Override
    public boolean deleteSpeaker(Long id) {
        Optional<Speaker> speaker = get(id, "DELETE");
        if (speaker.isEmpty())
            return false;
        speakerRepository.deleteById(id);
        return true;
    }

    @Override
    public Speaker updateSpeaker(Long id, Speaker speaker) {
        Optional<Speaker> spk = get(id, "PUT");
        if (spk.isEmpty())
            return null;
        BeanUtils.copyProperties(speaker, spk.get(), "speaker_id");
        return speakerRepository.saveAndFlush(spk.get());
    }
}
