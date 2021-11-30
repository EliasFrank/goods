package com.hl.goods.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author hl2333
 */
@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "[needId]")
    private int needId;

    @Column(name = "[content]")
    private String content;

    @Column(name = "[userId]")
    private int userId;

    @Column(name = "[createTime]")
    private String createTime;
}
