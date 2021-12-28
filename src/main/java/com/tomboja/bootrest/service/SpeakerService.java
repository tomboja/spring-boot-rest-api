package com.tomboja.bootrest.service;

import com.tomboja.bootrest.domain.Speaker;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/27/21
 */

public interface SpeakerService {
    public List<Speaker> listSpeakers();
    public Optional<Speaker> getSpeaker(Long id);
    public Speaker saveSpeaker(Speaker speaker);
    public boolean deleteSpeaker(Long id);
    public Speaker updateSpeaker(Long id, Speaker speaker);
}
