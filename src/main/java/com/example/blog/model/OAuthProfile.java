package com.example.blog.model;

import lombok.Data;

@Data
public class OAuthProfile {
    private long id;
    private String connected_at;
    private Properties properties;
    private Kakao_account kakao_account;
}
@Data
class Properties {
    private String nickname;
}
@Data
class Kakao_account{
    private boolean profile_nickname_needs_agreement;
    private Profile profile;
    private boolean has_email;
    private boolean email_needs_agreement;
    private boolean is_email_valid;
    private boolean getIs_email_verified;
    private String email;
}
@Data
class Profile{
    private String nickname;
}