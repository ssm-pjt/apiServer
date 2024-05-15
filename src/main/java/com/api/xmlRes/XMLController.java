package com.api.xmlRes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class XMLController {

    @GetMapping(value = "/convertxmltomap", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> convertXMLToMap(@RequestBody String xmlInput) throws Exception {

        // 맵을 XML로 변환
        ObjectMapper xmlMapper = new XmlMapper();

        // RequestBody 어노테이션은 XML 본문을 String으로 받습니다.

        // XML String을 Map으로 변환
        Map<String, Object> inputMap = xmlMapper.readValue(xmlInput, Map.class);


        // 특정 맵 데이터 생성
        Map<String, Object> outputMap = createSampleMap();

        // 맵을 XML로 변환
        String xmlResponse = xmlMapper.writeValueAsString(outputMap);

        // 변환된 XML 응답을 반환합니다.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        return new ResponseEntity<>(xmlResponse, headers, HttpStatus.OK);
    }

    private Map<String, Object> createSampleMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("field1", "Hello");
        map.put("field2", "World");
        return map;
    }
}