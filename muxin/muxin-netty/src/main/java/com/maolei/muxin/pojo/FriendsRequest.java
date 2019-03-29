package com.maolei.muxin.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.slyak.spring.jpa.auditing.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "friends_request")
public class FriendsRequest extends BaseEntity<Long> {

    @Column
    private String sendUserId;

    @Column
    private String acceptUserId;

    @Column
    private Date requestDateTime;
}
