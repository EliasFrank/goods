package com.hl.goods.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author hl2333
 */
@Entity
@Table(name = "needs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Needs {
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

    @Column(name = "tel")
    private String tel;

    @Column(name = "userId")
    private int userId;

    @Column(name = "solved")
    private int solved;

    @Column(name = "[createTime]")
    private String createTime;

    @Column(name = "[checked]")
    private int checked;

    /*private String solvedStr;

    private String checkStr;

    public String getSolvedStr() {
        if (solved == 1) {
            return "已解决";
        } else {
            return "未解决";
        }
    }

    public String getCheckStr() {
        if (check == 1) {
            return "审核通过";
        } else {
            return "审核未通过";
        }
    }*/
}
