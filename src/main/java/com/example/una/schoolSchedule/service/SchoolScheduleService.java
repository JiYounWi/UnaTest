package com.example.una.schoolSchedule.service;

import com.example.una.schoolSchedule.domain.SchoolSchedule;
import com.example.una.schoolSchedule.dto.SchoolScheduleDTO;
import com.example.una.schoolSchedule.repository.SchoolScheduleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
//@RequiredArgsConstructor
@Service
public class SchoolScheduleService {

    private final SchoolScheduleRepository schoolScheduleRepository;

    @Autowired
    public SchoolScheduleService(SchoolScheduleRepository schoolScheduleRepository){
        this.schoolScheduleRepository = schoolScheduleRepository;
    }

    public List<SchoolSchedule> getAllSchoolSchedules(){
        return schoolScheduleRepository.findAll();
    }

//    public List<Map<String, String>> getSchoolSchedule(Map<String, String> requestBody) throws IOException {
//        List<Map<String, String>> rows = new ArrayList<>();
//
//        // API 호출을 위한 URL 생성
//        String urlStr = "https://open.neis.go.kr/hub/SchoolSchedule?" +
//                "KEY=881fba3c77c745878cc257e8746afecd" +
//                "&ATPT_OFCDC_SC_CODE=B10" +
//                "&SD_SCHUL_CODE=" + requestBody.get("SD_SCHUL_CODE");
//        if (requestBody.containsKey("DGHT_CRSE_SC_NM")) {
//            urlStr += "&DGHT_CRSE_SC_NM=" + requestBody.get("DGHT_CRSE_SC_NM");
//        }
//        if (requestBody.containsKey("SCHUL_CRSE_SC_NM")) {
//            urlStr += "&SCHUL_CRSE_SC_NM=" + requestBody.get("SCHUL_CRSE_SC_NM");
//        }
//        if (requestBody.containsKey("AA_YMD")) {
//            urlStr += "&AA_YMD=" + requestBody.get("AA_YMD");
//        }
//        if (requestBody.containsKey("AA_FROM_YMD")) {
//            urlStr += "&AA_FROM_YMD=" + requestBody.get("AA_FROM_YMD");
//        }
//        if (requestBody.containsKey("AA_TO_YMD")) {
//            urlStr += "&AA_TO_YMD=" + requestBody.get("AA_TO_YMD");
//        }
//        urlStr += "&type=json";
//
//        // URL을 통한 API 호출
//        URL url = new URL(urlStr);
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        urlConnection.setRequestMethod("GET");
//
//        StringBuilder result = new StringBuilder();
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"))) {
//            String returnLine;
//            while ((returnLine = br.readLine()) != null) {
//                result.append(returnLine);
//            }
//        } finally {
//            urlConnection.disconnect();
//        }
//
//        // JSON 파싱
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode root = objectMapper.readTree(result.toString());
//        JsonNode rowsNode = root.path("SchoolSchedule").get(1).path("row");
//
//        // "row" 값 추출
//        for (JsonNode rowNode : rowsNode) {
//            Map<String, String> row = objectMapper.convertValue(rowNode, Map.class);
//            rows.add(row);
//        }
//
//        return rows;
//    }
    public void fetchAndSaveSchoolSchedule(String sdSchulCode) {
        try {
            // API 호출을 위한 URL 생성
            String apiUrl = constructApiUrl(sdSchulCode);

            // API 호출하여 데이터 가져오기
            String jsonData = fetchDataFromApi(apiUrl);

            // JSON 데이터를 엔티티로 변환하여 저장
            saveDataToDatabase(jsonData);

            // 성공적으로 저장되었음을 로그로 기록
            log.info("School schedule data successfully fetched and saved.");
        } catch (Exception e) {
            // 에러 발생 시 에러 내용을 로그로 기록
            log.error("Failed to fetch and save school schedule data: {}", e.getMessage());
        }
    }


    private String constructApiUrl(String sdSchulCode) {
        // API 호출을 위한 URL 생성 로직 작성
        String apiUrl = "https://open.neis.go.kr/hub/SchoolSchedule?" +
                "KEY=881fba3c77c745878cc257e8746afecd" +
                "&ATPT_OFCDC_SC_CODE=B10" +
                "&SD_SCHUL_CODE=" + sdSchulCode +
                "&type=json";
        return apiUrl;
    }

    private String fetchDataFromApi(String apiUrl) throws IOException {
        // API 호출하여 데이터를 가져오는 로직 작성
        URL url = new URL(apiUrl);
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
        return result.toString();
    }

    private void saveDataToDatabase(String jsonData) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(jsonData);
            JsonNode rowsNode = root.path("SchoolSchedule").get(1).path("row");

            List<SchoolSchedule> schoolSchedules = new ArrayList<>();
            for (JsonNode rowNode : rowsNode) {
                SchoolSchedule schoolSchedule = objectMapper.treeToValue(rowNode, SchoolSchedule.class);
                schoolSchedules.add(schoolSchedule);
            }
            schoolScheduleRepository.saveAll(schoolSchedules);
        } catch (JsonProcessingException e) {
            log.error("Failed to parse JSON data: {}", e.getMessage());
        }
    }

    public void saveSchoolScheduleEntity(List<SchoolScheduleDTO> data) {
        for (SchoolScheduleDTO schoolScheduleDTO : data) {
            schoolScheduleRepository.save(schoolScheduleDTO.toEntity());
        }
    }
}
