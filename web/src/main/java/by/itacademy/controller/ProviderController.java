package by.itacademy.controller;

import by.itacademy.ProviderService;
import by.itacademy.entity.account.provider.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProviderController {
    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @ModelAttribute
    public Provider provider() {
        return new Provider();
    }
    @RequestMapping("providerPage")
    public String providerAbout() {

        return "auth/ProviderPage";
    }
}
