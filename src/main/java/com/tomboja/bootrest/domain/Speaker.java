package com.tomboja.bootrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

@Entity(name = "speakers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String title;
    private String company;
    @Column(name = "speaker_bio")
    private String speakerBio;

    @Lob // annotation for large object
    @Type(type = "org.hibernate.type.BinaryType") // helps hibernate deal with Binary data
    @Column(name = "speaker_photo")
    private byte[] speakerPhoto;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    private List<Session> sessions;
}
