package pl.olointeria.spring_08_mysql_company.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.olointeria.spring_08_mysql_company.dto.SupplierDto;
import pl.olointeria.spring_08_mysql_company.dto.SupplierPSCPSDto;
import pl.olointeria.spring_08_mysql_company.prima.*;
import pl.olointeria.spring_08_mysql_company.service.SupplierPSCPSService;
import pl.olointeria.spring_08_mysql_company.service.SupplierService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SupplierPSCPSRestController {

    private final SupplierPSCPSService supplierPSCPSService;
    @Autowired
    private SupplierPSCPSRepository repoPSCPS;


    public SupplierPSCPSRestController(SupplierPSCPSService supplierPSCPSService) {
        this.supplierPSCPSService = supplierPSCPSService;
    }





    // @GetMapping( value="api/SupClassification", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @GetMapping( value="api/SupPSCPSClassification", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupPSCPSClassification> getPSCPSSupClassification() {
        List<SupPSCPSClassification> listSupClass= new ArrayList<>();
        List<SupplierPSCPS> listSuppliers = repoPSCPS.findAll();

        int NumberSuppliersA=0;
        int NumberSuppliersB=0;
        int NumberSuppliersC=0;
        for (SupplierPSCPS supplier:listSuppliers) {

            if( supplier.getClassification().equals("A")){
                NumberSuppliersA++;
            }


            if( supplier.getClassification().equals("B")){
                NumberSuppliersB++;
            }

            if( supplier.getClassification().equals("C")){
                NumberSuppliersC++;
            }

        }System.out.println(NumberSuppliersA);
        //  listSupClass.add(
        //    new SupClassification( "A", NumberSuppliersA));
        // listSupClass.add(
        //     new SupClassification( "B", NumberSuppliersB));
        // listSupClass.add(
        //     new SupClassification( "C", NumberSuppliersC));
        // model.addAttribute("listSubClass",listSupClass);
        return List.of(
                new SupPSCPSClassification( "A", NumberSuppliersA),
                new SupPSCPSClassification( "B", NumberSuppliersB),
                new SupPSCPSClassification( "C", NumberSuppliersC)

        );


//model.addAllAttribut("listSubClass",listSupClass);
    }

    @GetMapping("/supplierPSCPS/{id}")
    Optional<SupplierPSCPSDto> getSupplierById(@PathVariable Integer id) {


        return supplierPSCPSService.getSupplierById(id);
    }



}

