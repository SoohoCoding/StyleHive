package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("comm_tag_product")
public class CommunityTagProductDTO {
    private int commProductId;
    private int commNo;
    private int productId;
}
