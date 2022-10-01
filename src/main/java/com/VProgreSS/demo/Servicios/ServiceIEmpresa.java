package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.Empresa;

import java.util.List;

public interface ServiceIEmpresa {

    //Metodo para ver lista de Enterprise
    public List<Empresa> getEnterprise();


    //Metodo que nos trae un Enterprise
    public Empresa getOnlyOneEnterprise(Long idEnterprise) throws Exception;


    //Metodo que nos cree una Enterprise
    public String setCreateEnterprise(Empresa empresaIn);


    //Metodo que nos permita actualizar una enterprise
    public Empresa getUpdateEnterprise(Empresa empresaIn) throws Exception;

    //Metodo que elimina una enterprise
    public String getDeleteEnterprise(Long idEnterprise) throws Exception;

}
