package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_coupon")
public class UserCouponEntity {
    @Id
    private String couId;
    private String couName;
    private String couRate;
}
