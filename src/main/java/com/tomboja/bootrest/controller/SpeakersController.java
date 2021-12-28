package com.tomboja.bootrest.controller;

import com.tomboja.bootrest.domain.Speaker;
import com.tomboja.bootrest.service.SpeakerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 12/27/21
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    private final SpeakerServiceImpl speakerService;

    @GetMapping
    public List<Speaker> getAllSpeakers() {
        return speakerService.listSpeakers();
    }

    @GetMapping("/{id}")
    public Optional<Speaker> getSpeakerById(@PathVariable("id") Long id) {
        return speakerService.getSpeaker(id);
    }

    @PostMapping
    public Speaker saveSpeaker(@RequestBody Speaker speaker) {
        return speakerService.saveSpeaker(speaker);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSpeaker(@PathVariable("id") Long id) {
        return speakerService.deleteSpeaker(id);
    }

    @PutMapping("/{id}")
    public Speaker update(@PathVariable("id") Long id, @RequestBody Speaker speaker) {
        return speakerService.updateSpeaker(id, speaker);
    }
}
