package com.maolei.muxin.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Data
@Entity
@Table(name = "friends_request")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class FriendsRequest {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Column
    private String sendUserId;

    @Column
    private String acceptUserId;

    @Column
    private Date requestDateTime;
}
