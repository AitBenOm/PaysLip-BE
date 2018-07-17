package com.payslip.WEB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class Dispatcher {


    public String greetingForm(Model model) {

        return "index";
    }
}
