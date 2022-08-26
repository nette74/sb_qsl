package com.ll.exam.qsl.keyword.entity;

import com.ll.exam.qsl.base.entity.BaseTimedEntity;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
public class Keyword extends BaseTimedEntity {
    @Column(unique = true)
    private String keyword;

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public int hashCode() {
        return getKeyword().hashCode();
    }
}
