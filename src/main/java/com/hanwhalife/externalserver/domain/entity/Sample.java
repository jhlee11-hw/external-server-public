package com.hanwhalife.externalserver.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sample")
public class Sample {
    @Id
    @GeneratedValue // 자동 생성되는 키 값
    private Long id;

    private String name;

    private String email;

}
