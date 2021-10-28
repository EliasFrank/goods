package com.hl.goods.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author hl2333
 */
@Entity
@Table(name = "goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "[name]")
    private String name;

    @Column(name = "[desc]")
    private String desc;

    @Column(name = "[count]")
    private int count;

    @Column(name = "[location]")
    private String location;

    @Column(name = "userId")
    private int userId;

    @Column(name = "createTime")
    private String createTime;

    @Column(name = "[rec]")
    private int rec;
}
