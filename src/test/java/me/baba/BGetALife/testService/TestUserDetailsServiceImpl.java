package me.baba.BGetALife.testService;

import com.flextrade.jfixture.JFixture;
import me.baba.BGetALife.model.User;
import me.baba.BGetALife.repository.UserRepository;
import me.baba.BGetALife.service.UserDetailsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class TestUserDetailsServiceImpl {

    @Mock
    private UserRepository userRepository;

    private JFixture fixture = new JFixture();

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoadByUsernameReturnsUserDetails() {
        String username = "tanveer";

        User user = fixture.create(User.class);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                true,
                true,
                true,
                true,
                AuthorityUtils.createAuthorityList(user.getRole())
        );
        Mockito.when(userRepository.findByUsername(username)).thenReturn(user);
        Assert.assertEquals(userDetails, userDetailsService.loadUserByUsername("tanveer"));

    }
}
