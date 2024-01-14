package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("faq")
public class FaqDTO {
    private int faqNo;
    private String faqCate;
    private String faqTitle;
    private String faqContent;
}
