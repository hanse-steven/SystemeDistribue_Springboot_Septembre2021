package hanse.steven.sysdisaout2021.controller;

import hanse.steven.sysdisaout2021.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class CheckoutController {

    CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping("/api/checkout/raw")
    public HashMap<String, Float> checkoutRaw(HttpSession session) {
        return checkoutService.doCheckout(session);
    }
}
