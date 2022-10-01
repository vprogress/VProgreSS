package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.UsersApplication;
import com.VProgreSS.demo.Servicios.ServiceInterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    @Autowired
    private ServiceInterfaceUser UserBDX;

    //Metodos para crear un usuario

    @GetMapping("/userRegister")
    public String getUserRegister(Model model){
        model.addAttribute("formUserRegister",new UsersApplication());
        return "userRegister";
    }

    @PostMapping("/CreateUser")
    public String CreateUser (@ModelAttribute("redirect:/WelcomeUser") UsersApplication UserX){
        UserBDX.setCreateUsersApplication(UserX);
        return "redirect:/userList";
    }


    //Matodo para listar usuarios

    @GetMapping("/userList")
    public String getUserList(Model model){
        model.addAttribute("UsersApplication",UserBDX.getUsersApplication());
        return "userList";
    }


    //Metodo para borrar un usuario
    @PostMapping("/deleteUser/{userApplication}")
    public String deleteUser(@PathVariable String userApplication, Model model){
        try {
            UserBDX.getDeleteUsersApplication(userApplication);
            return "redirect:/userList";
        } catch (Exception e) {
            return "redirect:/errorLogin";
        }
    }

    //Metodo para actualizar un usuario

    @GetMapping("/updateUser/{userApplication}")
    public String updateUser(@PathVariable String userApplication, Model model){
        try {
            model.addAttribute("userUpdate",UserBDX.getOnlyOneUsersApplication(userApplication));
            return "updateUserNew";
        } catch (Exception e) {
            return "redirect:/errorLogin";
        }
    }

    @PostMapping("/updateUser")
    public String updateUser (@ModelAttribute("redirect:/WelcomeUser") UsersApplication UserX){
        try {
            UserBDX.getUpdateUsersApplication(UserX);
            return "redirect:/userList";
        } catch (Exception e) {
            return "redirect:/errorLogin";
        }

    }



}
