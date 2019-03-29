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
@Table(name = "chat_msg")
public class ChatMsg extends BaseEntity<Long> {

    @Column
    private String sendUserId;

    @Column
    private String acceptUserId;

    @Column
    private String msg;

    @Column
    private Integer signFlag;

    @Column
    private Date createTime;
}
