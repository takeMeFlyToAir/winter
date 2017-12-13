package com.winter.business.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;

@Data
public abstract class BusinessEntity extends BaseEntity {

    @Id
    private Long id;

    private Integer deleted = 0;

}
