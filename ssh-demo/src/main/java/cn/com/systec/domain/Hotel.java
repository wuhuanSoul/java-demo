package cn.com.systec.domain;

import cn.com.systec.base.BaseDomain;

import javax.persistence.*;

/**
 * Created by wh on 10/23/2017.
 */
@Entity
@Table(name = "tb_hotel")
public class Hotel extends BaseDomain{

    private static final long serialVersionUID = 713097944415075123L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "address")
    private String address;

    @Column(name = "post")
    private Integer post;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }
}
