package com.pharmerz.iphex.api.server.domain.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by ankur on 16-03-2017.
 */
@Entity
@Table(name = "SCANS", uniqueConstraints = @UniqueConstraint(name = "SCAN_UK", columnNames = {"USER_ID", "OTHER_ID"}))
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Scan.findAll", query = "SELECT s FROM Scan s")
})
public class Scan extends Domain implements Serializable{

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;


    @ManyToOne
    @JoinColumn(name = "OTHER_ID")
    private User other;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getOther() {
        return other;
    }

    public void setOther(User other) {
        this.other = other;
    }
}
