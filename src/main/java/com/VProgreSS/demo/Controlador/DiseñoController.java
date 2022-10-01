package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.UsersApplication;
import com.VProgreSS.demo.Servicios.ServiceInterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiseñoController {

    @Autowired
    private ServiceInterfaceUser UserBDX;


    @GetMapping("/")
    public String getIndex(){
        return "index";
    }


    @GetMapping("/loginUser")
    public String getLogin(Model model){
        model.addAttribute("formUsersLogin",new UsersApplication());
        return "loginUser";
    }


    @GetMapping("/forgotPassword")
    public String getforgotPassword(Model model){
        return "forgotPassword";
    }

    @GetMapping("/WelcomeUser")
    public String getWelcomeUser(Model model){
        return "WelcomeUser";
    }


    @GetMapping("/WelcomeEnterprise")
    public String getWelcomeEnterprise(Model model){
        return "WelcomeEnterprise";
    }

    @GetMapping("/errorLogin")
    public String getErrorLogin(Model model){
        return "ErrorLogin";
    }


}
