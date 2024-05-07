package com.example.una.kakaoLogin.controller;

import com.example.una.kakaoLogin.dto.KakaoDTO;
import com.example.una.kakaoLogin.entity.MsgEntity;
import com.example.una.kakaoLogin.service.KakaoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("kakao")
//public class KakaoController {
//
//    private final KakaoService kakaoService;
//
//    @GetMapping("/callback")
//    public ResponseEntity<MsgEntity> callback(HttpServletRequest request) throws Exception{
//        KakaoDTO kakaoInfo = kakaoService.getKakaoInfo(request.getParameter("code"));
//
//        return ResponseEntity.ok()
//                .body(new MsgEntity("Success", kakaoInfo));
//    }
//}
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("kakao")
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("/callback")
    public ResponseEntity<MsgEntity> callback(HttpServletRequest request) throws Exception{
        // 카카오에서 받아온 인가 코드를 사용하여 사용자 정보를 가져옴
        KakaoDTO kakaoInfo = kakaoService.getKakaoInfo(request.getParameter("code"));

        // 사용자 정보를 ResponseEntity로 반환
        return ResponseEntity.ok()
                .body(new MsgEntity("Success", kakaoInfo));
    }
}
