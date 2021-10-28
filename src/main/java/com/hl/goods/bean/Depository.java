package com.hl.goods.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "depository")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Depository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "[name]")
    private String name;

    @Column(name = "[desc]")
    private String desc;

    @Column(name = "[location]")
    private String location;

    @Column(name = "createTime")
    private String createTime;
}
