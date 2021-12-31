package com.tomboja.bootrest.models;

import com.tomboja.bootrest.domain.Speaker;
import com.tomboja.bootrest.repo.SpeakerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 12/29/21
 */

@SpringBootTest
@Transactional
public class SpeakerTest {

    @Autowired
    private SpeakerRepository repository;

    @Test
    public void shouldFindSpeakerByFirstnameAndLastname() {
        List<Speaker> speakers = repository.findByFirstNameAndLastName("Justin", "Clark");
        assertTrue(speakers.size() > 0);
    }

    @Test
    public void shouldFindSpeakersByFirstnameOrLastname() {
        // There is no a 'Jason' or 'Bourne' in the firstnames and lastnames
        List<Speaker> speakers = repository.findByFirstNameOrLastName("Jason", "Bourne");
        assertEquals(0, speakers.size());
    }

    @Test
    public void shouldFindSpeakersFromCompanies() {
        List<String> companies = new ArrayList<>();
        companies.add("Contoso");
        companies.add("Microsoft");
        companies.add("National Bank");
        companies.add("NetFlex");

        List<Speaker> speakers = repository.findByCompanyIn(companies);
        assertTrue(speakers.size() > 0);
    }


}
