package com.codebee.stylehive.jpa.entity.community;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comm_tag")
public class CommunityTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commTagNo;
    int commNo;

    @OneToMany
    @JoinColumn(name = "commTagNo")
    List<TagEntity> tagList = new ArrayList<>();
}
