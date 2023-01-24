package school.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import school.admin.dao.UserRepository;
import school.admin.entities.SystemUser;
import school.admin.filters.AuthFilter;
import school.admin.services.UserService;
import school.admin.servicesImpl.UserServiceImpl;
import school.admin.utils.JwtUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AdminController.class)
@TestPropertySource("classpath:application.yaml")
public class AdminControllerTest {

    Logger logger = LoggerFactory.getLogger(AdminControllerTest.class);

    @MockBean
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private static UserRepository repository;

    @MockBean
    private JwtUtils jwtUtils;

    @MockBean
    private AuthFilter authFilter;

    @MockBean
    private UserService userService;

    @BeforeAll
    public static void init(){
        UserService userService = new UserServiceImpl(repository, null, null);
        new AdminController(userService);
    }

    @BeforeEach
    void setUp(){
        SystemUser user = SystemUser
                .getSystemUserBuilder()
                .setId(12)
                .setUsername("radhejadhav")
                .setFirstName("Radhe")
                .setLastName("Jadhav")
                .setPassword("Radhe@123")
                .setRoles(new String[]{"user","admin"})
                .build();
        Mockito.when(userService.getAllUser()).thenReturn(Stream.of(user).collect(Collectors.toList())
        );
    }

    @Test
    @DisplayName("Get All User API Test")
    void testGetAllUserApi(){
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/users/find-all")
                .accept(MediaType.APPLICATION_JSON);
        try {
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();
            ObjectMapper mapper = new ObjectMapper();

            logger.info("Success");
            logger.info(mapper.writeValueAsString(result));

            assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
