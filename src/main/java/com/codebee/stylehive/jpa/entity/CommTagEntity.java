package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comm_tag")
public class CommTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commTagNo;

    @ManyToOne
    @JoinColumn(name = "comm_no", insertable = false, updatable = false)
    private CommunityEntity community;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tag;

}
