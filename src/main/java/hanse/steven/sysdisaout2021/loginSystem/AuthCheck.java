package hanse.steven.sysdisaout2021.loginSystem;

import hanse.steven.sysdisaout2021.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthCheck extends SimpleUrlAuthenticationSuccessHandler {

    PanierService panierService;

    @Autowired
    public AuthCheck(PanierService panierService) {
        this.panierService = panierService;
    }

    public static boolean isLogged() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null != authentication && !("anonymousUser").equals(authentication.getName());
    }
}
