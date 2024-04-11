package com.example.una.schoolSchedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@RestController
public class SchoolScheduleController {

//    @GetMapping("/school-schedule-api")
//    public String schoolSchedule(
//    ) throws IOException {
//        StringBuilder result = new StringBuilder();
//
//        String urlStr = "https://open.neis.go.kr/hub/SchoolSchedule?" +
//                "KEY=881fba3c77c745878cc257e8746afecd" +
//                "&ATPT_OFCDC_SC_CODE=B10" +
//                "&SD_SCHUL_CODE=7091367" +
//                "&type=json";
//        URL url = new URL(urlStr);
//
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        urlConnection.setRequestMethod("GET");
//
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"))) {
//            String returnLine;
//            while ((returnLine = br.readLine()) != null) {
//                result.append(returnLine);
//            }
//        } finally {
//            urlConnection.disconnect();
//        }
//
//        // JSON을 보기 좋게 출력하기 위해 ObjectMapper 사용
//        ObjectMapper objectMapper = new ObjectMapper();
//        Object json = objectMapper.readValue(result.toString(), Object.class);
//        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
//    }

    @PostMapping("/getSchoolSchedule")
    public String getSchoolSchedule(@RequestBody Map<String, String> requestBody) throws IOException {
        StringBuilder result = new StringBuilder();

        // API 호출을 위한 URL 생성
        String urlStr = "https://open.neis.go.kr/hub/SchoolSchedule?" +
                "KEY=881fba3c77c745878cc257e8746afecd" +
                "&ATPT_OFCDC_SC_CODE=" + requestBody.get("ATPT_OFCDC_SC_CODE") +
                "&SD_SCHUL_CODE=" + requestBody.get("SD_SCHUL_CODE");
        if (requestBody.containsKey("DGHT_CRSE_SC_NM")) {
            urlStr += "&DGHT_CRSE_SC_NM=" + requestBody.get("DGHT_CRSE_SC_NM");
        }
        if (requestBody.containsKey("SCHUL_CRSE_SC_NM")) {
            urlStr += "&SCHUL_CRSE_SC_NM=" + requestBody.get("SCHUL_CRSE_SC_NM");
        }
        if (requestBody.containsKey("AA_YMD")) {
            urlStr += "&AA_YMD=" + requestBody.get("AA_YMD");
        }
        if (requestBody.containsKey("AA_FROM_YMD")) {
            urlStr += "&AA_FROM_YMD=" + requestBody.get("AA_FROM_YMD");
        }
        if (requestBody.containsKey("AA_TO_YMD")) {
            urlStr += "&AA_TO_YMD=" + requestBody.get("AA_TO_YMD");
        }
        urlStr += "&type=json";

        // URL을 통한 API 호출
        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"))) {
            String returnLine;
            while ((returnLine = br.readLine()) != null) {
                result.append(returnLine);
            }
        } finally {
            urlConnection.disconnect();
        }

        // JSON을 보기 좋게 출력하기 위해 ObjectMapper 사용
        ObjectMapper objectMapper = new ObjectMapper();
        Object json = objectMapper.readValue(result.toString(), Object.class);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }
}
