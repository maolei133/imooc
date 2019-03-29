package com.maolei.muxin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.slyak.spring.jpa.auditing.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "my_friends")
public class MyFriends extends BaseEntity<Long> {

    @Column
    private String myUserId;

    @Column
    private String myFriendUserId;
}
