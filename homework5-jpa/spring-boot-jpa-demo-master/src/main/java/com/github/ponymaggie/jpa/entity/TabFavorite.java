package com.github.ponymaggie.jpa.entity;

import javax.persistence.*;

/**
 * @author XUAN
 * @date 2020/10/22 - 0:21
 * @references
 * @purpose
 * @errors
 */
@Entity
@Table(name="tab_favorite")
public class TabFavorite {

    @Id
    @Column(name = "rid")
    private int rid;//旅游线路对象
    @Column(name = "date")
    private String date;//收藏时间
    @Column(name = "uid")
    private int uid;//所属用户

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
