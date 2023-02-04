package pl.olointeria.spring_08_mysql_company.service;

import org.springframework.stereotype.Service;
import pl.olointeria.spring_08_mysql_company.dto.SupplierPSCPSDto;
import pl.olointeria.spring_08_mysql_company.dto.SupplierQ32022PSCPSDto;
import pl.olointeria.spring_08_mysql_company.prima.SupplierPSCPS;
import pl.olointeria.spring_08_mysql_company.prima.SupplierPSCPSRepository;
import pl.olointeria.spring_08_mysql_company.prima.SupplierQ32022PSCPS;
import pl.olointeria.spring_08_mysql_company.prima.SupplierQ32022PSCPSRepository;

@Service
public class SupplierQ32022PSCPSDtoMapper {
    private final SupplierQ32022PSCPSRepository supplierQ32022PSCPSRepo ;

    public SupplierQ32022PSCPSDtoMapper(SupplierQ32022PSCPSRepository supplierQ32022PSCPSRepo) {
        this.supplierQ32022PSCPSRepo = supplierQ32022PSCPSRepo;
    }

    //to pozwala na przekształci obiekt encji na obiekt DTO
    // Jeżeli kontroler oznaczymy adnotacją @RestController, to zadziała to tak,
    // jakbyśmy klasę oznaczyli adnotacjami @Controller i @ResponseBody, czyli adnotacja @ResponseBody zostanie dodana do wszystkich metod automatycznie.
    SupplierQ32022PSCPSDto map(SupplierQ32022PSCPS supplier){
        SupplierQ32022PSCPSDto dto = new SupplierQ32022PSCPSDto();
        dto.setId(supplier.getId());
        dto.setId_Sap(supplier.getId_Sap());
        dto.setName(supplier.getName());
        dto.setClassification(supplier.getClassification());
        dto.setTotalScore(supplier.getTotalScore());

        return dto;
    }


}

