package com.example.blog.controller;

import com.example.blog.config.OauthConfig;
import com.example.blog.model.OAuthProfile;
import com.example.blog.model.OAuthToken;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/*
 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
 그냥 주소가 / 이면 index.jsp 허용
 static 이하에 있는 리소스 파일(js,css,image) 허용
 */
@Log4j2
@Controller
public class PlayerController {
    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "player/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(Model model) throws Exception {
        model.addAttribute("clientKey",OauthConfig.KAKAO_CLIENT_KEY);
        return "player/loginForm";
    }

    @GetMapping("/auth/kakao/callback")
    @ResponseBody
    public  String kakaoCallback(String code){

        //POST 방식으로 key=value 데이터 를 요청
        //Retrofit2
        //OkHttp
        //RestTemplate
        RestTemplate rt= new RestTemplate();
        //HTTPHeader 오브 젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
        //HttpBody 오브젝트 생성
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id",OauthConfig.KAKAO_CLIENT_KEY);
        params.add("redirect_uri",OauthConfig.KAKAO_REDIRECT_URI);
        params.add("code",code);
        //HttpHeader  HttpBody 하나의 오브젝트 결합
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
                new HttpEntity<>(params,headers);
        //Http 요청하기 - Post 방식 - 그리고 response 변수의 응답 받음
        ResponseEntity response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );
        //Gson, Json Simple, ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = null;
        try {
            oAuthToken = objectMapper.readValue(response.getBody().toString(), OAuthToken.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        RestTemplate rt2= new RestTemplate();
        //HTTPHeader 오브 젝트 생성
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
        headers2.add("Authorization","Bearer "+oAuthToken.getAccess_token());
        //HttpHeader  HttpBody 하나의 오브젝트 결합
        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest =
                new HttpEntity<>(headers2);
        //Http 요청하기 - Post 방식 - 그리고 response 변수의 응답 받음
        ResponseEntity response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );
//        ObjectMapper objectMapper2 = new ObjectMapper();
//        OAuthProfile oAuthProfile = null;
//        try{
//            oAuthProfile = objectMapper2.readValue(response2.getBody().toString(), OAuthProfile.class);
//        } catch (Exception e){
//            throw new RuntimeException(e);
//        }

        return   response2.getBody().toString();



    }
}

