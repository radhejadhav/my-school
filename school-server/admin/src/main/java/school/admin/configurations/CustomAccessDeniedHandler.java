package school.admin.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import school.admin.dto.ResponseHandler;

import java.io.IOException;

@Component("customAccessDeniedHandler")
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        ObjectMapper mapper = new ObjectMapper();
        response
                .getOutputStream()
                .println(mapper
                        .writeValueAsString(ResponseHandler
                                .generateResponse(accessDeniedException.getMessage(), HttpStatus.FORBIDDEN.toString(), HttpStatus.FORBIDDEN,null)));

    }
}
