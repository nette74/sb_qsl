package com.ll.exam.qsl.keyword.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Keyword {
    @Column(columnDefinition="serial")
    private Long uid;

    @Id
    @EqualsAndHashCode.Include
    private String content;

    public Keyword(String content) {
        this.content = content;
    }
}
