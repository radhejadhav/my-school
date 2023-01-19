package school.admin.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;
import school.admin.dto.ResponseHandler;
import school.admin.exceptions.CustomError;

import java.io.IOException;

@Component("customAuthenticationEntryPoint")
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        CustomError error = new CustomError(authException.getMessage(), HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.toString(),"error");
        ObjectMapper mapper = new ObjectMapper();
        ContentCachingResponseWrapper responseCacheWrapperObject = new ContentCachingResponseWrapper(response);
        responseCacheWrapperObject.copyBodyToResponse();
        responseCacheWrapperObject.getResponse().getWriter().write(
                mapper.writeValueAsString(ResponseHandler.generateResponse(
                        authException.getMessage(),
                        HttpStatus.UNAUTHORIZED.toString(),
                        HttpStatus.UNAUTHORIZED,
                        null))
        );
        responseCacheWrapperObject.getContentAsByteArray();
    }
}
