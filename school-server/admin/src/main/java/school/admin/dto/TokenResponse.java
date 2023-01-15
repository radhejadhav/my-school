package school.admin.dto;

import java.util.List;

public class TokenResponse {

    private String token;
    private long id;
    private String username;
    private List<String> roles;

    public TokenResponse() {
    }

    public TokenResponse(String token, long id, String username, List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
