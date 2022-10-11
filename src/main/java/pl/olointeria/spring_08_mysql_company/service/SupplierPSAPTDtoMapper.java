package pl.olointeria.spring_08_mysql_company.service;

import org.springframework.stereotype.Service;
import pl.olointeria.spring_08_mysql_company.dto.SupplierPSAPTDto;
import pl.olointeria.spring_08_mysql_company.dto.SupplierPSCPSDto;
import pl.olointeria.spring_08_mysql_company.prima.*;

import java.util.LinkedList;
import java.util.List;

@Service
public class SupplierPSAPTDtoMapper {
    private final SupplierPSAPTRepository supplierPSAPTRepo ;

    public SupplierPSAPTDtoMapper(SupplierPSAPTRepository supplierPSAPTRepo) {
        this.supplierPSAPTRepo = supplierPSAPTRepo;
    }

    //to pozwala na przekształci obiekt encji na obiekt DTO
    // Jeżeli kontroler oznaczymy adnotacją @RestController, to zadziała to tak,
    // jakbyśmy klasę oznaczyli adnotacjami @Controller i @ResponseBody, czyli adnotacja @ResponseBody zostanie dodana do wszystkich metod automatycznie.
    SupplierPSAPTDto map(SupplierPSAPT supplier){
        SupplierPSAPTDto dto =new SupplierPSAPTDto();
        dto.setId(supplier.getId());
        dto.setId_Sap(supplier.getId_Sap());
        dto.setName(supplier.getName());
        dto.setClassification(supplier.getClassification());
        dto.setTotalScore(supplier.getTotalScore());

        return dto;
    }


}


