package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("imgThumb")
public class ImgThumbDTO {
    Integer imgThumbId;
    Integer commNo;
    Integer productId;
    String imgThumbUrl;
    String imgThumbStore;
}
