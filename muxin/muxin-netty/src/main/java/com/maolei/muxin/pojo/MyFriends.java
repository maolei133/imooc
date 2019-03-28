package com.maolei.muxin.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Data
@Entity
@Table(name = "my_friends")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class MyFriends {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Column
    private String myUserId;

    @Column
    private String myFriendUserId;
}
