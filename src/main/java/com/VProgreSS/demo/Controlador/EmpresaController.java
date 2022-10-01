package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.Empresa;
import com.VProgreSS.demo.Servicios.ServiceIEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpresaController {
    @Autowired
    private ServiceIEmpresa EnterpriseBDX;

    //Metodos para crear un Enterprise

    @GetMapping("/EnterpriseRegister")
    public String getEnterpriseRegister(Model model){
        model.addAttribute("formEnterpriseRegister",new Empresa());
        return "EnterpriseRegister";
    }

    @PostMapping("/CreateEnterpriseBD")
    public String CreateEnterprise (@ModelAttribute("redirect:/WelcomeEnterprise") Empresa empresaX){
        EnterpriseBDX.setCreateEnterprise(empresaX);
        return "redirect:/WelcomeEnterprise";
    }


    //Matodo para listar Enterprise

    @GetMapping("/enterpriseList")
    public String getUserList(Model model){
        model.addAttribute("Enterprise",EnterpriseBDX.getEnterprise());
        return "ListaDeEmpresa";
    }


    //Metodo para borrar un Enterprise
    @PostMapping("/deleteEnterpriseBD/{idEnterprise}")
    public String deleteEnterprise(@PathVariable Long idEnterprise, Model model){
        try {
            EnterpriseBDX.getDeleteEnterprise(idEnterprise);
            return "redirect:/WelcomeEnterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Metodo para actualizar un Enterprise

    @GetMapping("/updateEnterpriseBD/{idEnterprise}")
    public String updateEnterprise(@PathVariable Long idEnterprise, Model model){
        try {
            model.addAttribute("EnterpriseUpdate",EnterpriseBDX.getOnlyOneEnterprise(idEnterprise));
            return "updateEnterpriseNew";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/updateEnterpriseBD")
    public String updateEnterprise (@ModelAttribute("redirect:/WelcomeEnterprise") Empresa empresaX){
        try {
            EnterpriseBDX.getUpdateEnterprise(empresaX);
            return "redirect:/WelcomeEnterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

    //Metodo para presentar empleados de la empresa
    @GetMapping("/EmployeeOfEnterpriseBD/{idEnterprise}")
    public String EmployeeOfEnterprise(@PathVariable Long idEnterprise, Model model){
        try {
            Empresa empresaX = EnterpriseBDX.getOnlyOneEnterprise(idEnterprise);
            model.addAttribute("EmployeesEnterprise", empresaX.getEmployees());
            return "Empresa-Empleados";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }


}
