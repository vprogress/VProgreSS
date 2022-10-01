package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.Empresa;
import com.VProgreSS.demo.Repositorio.IEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements ServiceIEmpresa {

    //Atribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad enterprise
    @Autowired
    com.VProgreSS.demo.Repositorio.IEmpresa IEmpresa;

    @Override
    public List<Empresa> getEnterprise() {
        return IEmpresa.findAll();
    }

    @Override
    public Empresa getOnlyOneEnterprise(Long idEnterprise) throws Exception {
        Optional<Empresa> EnterpriseBD = IEmpresa.findById(idEnterprise);
        if(EnterpriseBD.isPresent()){
            return EnterpriseBD.get();
        }
        throw new Exception("IdEnterprise no asignado a ninguna enterprise de nuestra base de datos");
    }

    @Override
    public String setCreateEnterprise(Empresa empresaIn) {
        //Preguntamos si ya hay alguna enterprise ya registrada con ese Id.
        Optional<Empresa> EnterpriseBD = IEmpresa.findById(empresaIn.getIdEnterprise());
        if(!EnterpriseBD.isPresent()){
            IEmpresa.save(empresaIn);
            return "Enterprise Creada con exito";

        }
        return ("Ese Id ya esta regitrado a una Enterprise Existente");
    }

    @Override
    public Empresa getUpdateEnterprise(Empresa empresaIn) throws Exception {
        //LLamamos a la enterprise a actualizar de la BD
        Empresa empresaBD = getOnlyOneEnterprise(empresaIn.getIdEnterprise());

        //Actualizamos atributos
        if(empresaIn.getNameEnterprise()!=null && !empresaIn.getNameEnterprise().equals("")){
            empresaBD.setNameEnterprise(empresaIn.getNameEnterprise());
        }

        if(empresaIn.getNITEnterprise()!=null && !empresaIn.getNITEnterprise().equals("")){
            empresaBD.setNITEnterprise(empresaIn.getNITEnterprise());
        }

        if(empresaIn.getAddressEnterprise()!=null && !empresaIn.getAddressEnterprise().equals("")){
            empresaBD.setAddressEnterprise(empresaIn.getAddressEnterprise());
        }

        if(empresaIn.getPhoneEnterprise()!=null && !empresaIn.getPhoneEnterprise().equals("")){
            empresaBD.setPhoneEnterprise(empresaIn.getPhoneEnterprise());
        }

        if(empresaIn.getCreatedAtEnterprise()!=null && !empresaIn.getCreatedAtEnterprise().equals("")){
            empresaBD.setCreatedAtEnterprise(empresaIn.getCreatedAtEnterprise());
        }

        empresaBD.setUpdatedAtEnterprise(Today);

        return IEmpresa.save(empresaBD);
    }

    @Override
    public String getDeleteEnterprise(Long idEnterprise) throws Exception {
        Optional<Empresa> enterpriseBD = IEmpresa.findById(idEnterprise);
        if(enterpriseBD.isPresent()){
            IEmpresa.deleteById(idEnterprise);
            return "Enterprise Eliminada con exito";
        }
        throw new Exception("Enterprise NOOOOO encontarda");
    }


}
