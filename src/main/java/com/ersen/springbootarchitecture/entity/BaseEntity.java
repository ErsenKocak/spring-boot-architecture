package com.ersen.springbootarchitecture.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean status;
}
