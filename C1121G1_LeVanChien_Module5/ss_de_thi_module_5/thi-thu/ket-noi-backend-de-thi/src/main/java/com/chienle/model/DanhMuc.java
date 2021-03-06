package com.chienle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "danhMuc")
    @JsonBackReference
    private Set<BatDongSan> batDongSans;

    public DanhMuc() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BatDongSan> getBatDongSans() {
        return batDongSans;
    }

    public void setBatDongSans(Set<BatDongSan> batDongSans) {
        this.batDongSans = batDongSans;
    }
}
