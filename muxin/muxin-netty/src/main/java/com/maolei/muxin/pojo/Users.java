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
@Table(name = "users")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Users {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String faceImage;

    @Column
    private String faceImageBig;

    @Column
    private String nickname;

    @Column
    private String qrcode;

    @Column
    private String cid;

    public static UsersBuilder builder() {
        return new UsersBuilder();
    }

    public static class UsersBuilder {

        private String username;
        private String password;
        private String faceImage;
        private String faceImageBig;
        private String nickname;
        private String qrcode;
        private String cid;

        UsersBuilder() {}

        public Users build() {
            Users users = new Users();
            users.setUsername(this.username);
            users.setPassword(this.password);
            users.setFaceImage(this.faceImage);
            users.setFaceImageBig(this.faceImageBig);
            users.setNickname(this.nickname);
            users.setQrcode(this.qrcode);
            users.setCid(this.cid);
            return users;
        }

        public UsersBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UsersBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UsersBuilder faceImage(String faceImage) {
            this.faceImage = faceImage;
            return this;
        }

        public UsersBuilder faceImageBig(String faceImageBig) {
            this.faceImageBig = faceImageBig;
            return this;
        }

        public UsersBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public UsersBuilder qrcode(String qrcode) {
            this.qrcode = qrcode;
            return this;
        }

        public UsersBuilder cid(String cid) {
            this.cid = cid;
            return this;
        }

    }

}
