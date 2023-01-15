package school.admin.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler implements Serializable {

    public static ResponseEntity<Object> generateResponse(String message, String status, HttpStatus statusCode, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status_code", statusCode.value());
        map.put("status",status );
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map,statusCode);
    }
}
