package com.hl.goods.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author hl2333
 */
@Entity
@Table(name = "all_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class All {
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

    @Column(name = "depositoryId")
    private int depositoryId;

    @Column(name = "createTime")
    private String createTime;
}
