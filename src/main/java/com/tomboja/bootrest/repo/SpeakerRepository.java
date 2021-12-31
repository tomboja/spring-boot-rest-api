package com.tomboja.bootrest.repo;

import com.tomboja.bootrest.domain.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    // Find speaker by firstname and lastname
    //@Query("select s from speakers s where s.firstName = ?1 and s.lastName = ?2")
    List<Speaker> findByFirstNameAndLastName(String firstname, String lastname);

    // Find Speaker by firstname OR lastname
    //@Query("select s from speakers s where s.firstName = ?1 or s.lastName = ?2")
    List<Speaker> findByFirstNameOrLastName(String firstname, String lastname);

    // Find Speakers with photo value null
    // @Query("select s from speakers s where s.speakerPhoto is null")
    List<Speaker> findBySpeakerPhotoNull();
    List<Speaker> findBySpeakerPhotoIsNull();

    // Find Speakers with photo value not null
    // @Query("select s from speakers s where s.speakerPhoto is not null")
    List<Speaker> findBySpeakerPhotoNotNull();
    List<Speaker> findBySpeakerPhotoIsNotNull();

    // Find List of Speakers whose company is in the given collection
    // @Query("select s from speakers s where s.company in ?1")
    List<Speaker> findByCompanyIn(List<String> companies);
    List<Speaker> findByCompanyIsIn(List<String> companies);

    // Find Speaker by company ignore case
    // @Query("select s from speakers s where upper(s.company) = upper(?1)")
    List<Speaker> findByCompanyIgnoreCase(String company);

    // Find speakers by lastname and order the result by firstname ASCending
    // NOTE: The OrderBy part should always come last in the query DSL
    // @Query("select s from speakers s where s.lastName = ?1 order by s.firstName")
    List<Speaker> findByLastNameOrderByFirstName(String lastname);

    // Find the first speaker with firstname
    @Query("select s from speakers s where s.firstName = ?1")
    Speaker findFirstByFirstName(String firstname);

    // Find the first 5 speaker with firstname
    List<Speaker> findFirst5ByFirstName(String firstname);

    // Find the first speaker with firstname
    @Query("select distinct s from speakers s where s.firstName = ?1")
    List<Speaker> findDistinctByFirstName(String firstname);
}
