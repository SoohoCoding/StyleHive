package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "img_thumb")
public class ImgThumbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int imgThumbId;
    int commNo;
    int productId;
    String imgThumbUrl;
    String imgThumbStore;
}
