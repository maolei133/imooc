package com.maolei.muxin.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import com.maolei.muxin.pojo.ChatMsg;

public interface ChatMsgRepository extends JpaRepositoryImplementation<ChatMsg, String> {

}
