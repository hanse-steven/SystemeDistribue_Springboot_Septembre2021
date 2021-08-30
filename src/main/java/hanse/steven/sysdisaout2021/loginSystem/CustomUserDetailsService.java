package hanse.steven.sysdisaout2021.loginSystem;

import hanse.steven.sysdisaout2021.repository.ClientRepository;
import hanse.steven.sysdisaout2021.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository clientDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientDao.findByNom(username);
        if (client == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(client);
    }
}
