package com.example.una.schoolSchedule.service;

import com.example.una.schoolSchedule.entity.SchoolSchedule;
import com.example.una.schoolSchedule.repository.SchoolScheduleRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SchoolScheduleService {
    public List<Map<String, String>> getSchoolSchedule(Map<String, String> requestBody) throws IOException{
        List<Map<String, String>> rows = new ArrayList<>();

        // API 호출을 위한 URL 생성
        String urlStr = "https://open.neis.go.kr/hub/SchoolSchedule?" +
                "KEY=881fba3c77c745878cc257e8746afecd" +
                "&ATPT_OFCDC_SC_CODE=B10" +
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

        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"))) {
            String returnLine;
            while ((returnLine = br.readLine()) != null) {
                result.append(returnLine);
            }
        } finally {
            urlConnection.disconnect();
        }

        // JSON 파싱
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(result.toString());
        JsonNode rowsNode = root.path("SchoolSchedule").get(1).path("row");

        // "row" 값 추출
        for (JsonNode rowNode : rowsNode) {
            Map<String, String> row = objectMapper.convertValue(rowNode, Map.class);
            rows.add(row);
        }

        return rows;
    }
}
