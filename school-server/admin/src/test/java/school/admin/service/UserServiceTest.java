package school.admin.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.Mock;
import school.admin.dao.UserRepository;
import school.admin.entities.SystemUser;
import school.admin.services.UserService;
import school.admin.servicesImpl.UserServiceImpl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    private SystemUser user;

    @Mock
    private UserRepository repository;

    @BeforeEach
    void setUp(){
        logger.info("setting up...");

        user = SystemUser
                .getSystemUserBuilder()
                .setId(12)
                .setUsername("radhejadhav")
                .setFirstName("Radhe")
                .setLastName("Jadhav")
                .setPassword("Radhe@123")
                .setRoles(new String[]{"user","admin"})
                .build();
        this.userService = new UserServiceImpl(repository,null, null);
        Mockito.when(this.repository.findAll()).thenReturn(Stream.of(user).collect(Collectors.toList())
        );
    }

    @Test
    void testGetUsername(){
        assertEquals(1, userService.getAllUser().size());
        assertEquals("radhejadhav", userService.getAllUser().get(0).getUsername());
    }
}
