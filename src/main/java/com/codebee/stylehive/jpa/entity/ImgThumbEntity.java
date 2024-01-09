package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "img_thumb")
@Alias("imgThumb")
public class ImgThumbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int imgThumbId;
    Integer commNo;
    Integer productId;
    String imgThumbUrl;
    String imgThumbStore;
}
