package test.java.com.fivetwenty.patienttracker;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class UserAccountServiceTest {

    @Mock
    private UserAccountRepository userAccountRepository;

    @InjectMocks
    private UserAccountService userAccountService;

    @Test
    void testGetAllUsers() {
        List<UserAccount> userAccounts = Arrays.asList(
                new UserAccount(1, "User A"),
                new UserAccount(2, "User B")
        );
        when(userAccountRepository.findAll()).thenReturn(userAccounts);
        Iterable<UserAccount> allUsers = userAccountService.getAllUsers();
        assertEquals(userAccounts, allUsers);
    }

    @Test
    void testGetUserAccountById() {
        Integer userId = 1;
        UserAccount userAccount = new UserAccount(userId, "User A");
        when(userAccountRepository.findById(userId)).thenReturn(Optional.of(userAccount));
        UserAccount retrievedUserAccount = userAccountService.getUserAccountById(userId);
        assertEquals(userAccount, retrievedUserAccount);
    }

    @Test
    void testGetUserAccountByIdUserNotFound() {
        Integer userId = 1;
        when(userAccountRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> userAccountService.getUserAccountById(userId));
    }
}
