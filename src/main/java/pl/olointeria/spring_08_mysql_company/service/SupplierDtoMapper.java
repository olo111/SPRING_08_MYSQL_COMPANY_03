package pl.olointeria.spring_08_mysql_company.service;

import org.springframework.stereotype.Service;
import pl.olointeria.spring_08_mysql_company.dto.SupplierDto;
import pl.olointeria.spring_08_mysql_company.prima.Supplier;
import pl.olointeria.spring_08_mysql_company.prima.SupplierRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class SupplierDtoMapper {
    private final SupplierRepository supplierRepo;

    public SupplierDtoMapper(SupplierRepository supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    //to pozwala na przekształci obiekt encji na obiekt DTO
    // Jeżeli kontroler oznaczymy adnotacją @RestController, to zadziała to tak,
    // jakbyśmy klasę oznaczyli adnotacjami @Controller i @ResponseBody, czyli adnotacja @ResponseBody zostanie dodana do wszystkich metod automatycznie.
    SupplierDto map(Supplier supplier){
        SupplierDto dto =new SupplierDto();
        dto.setId(supplier.getId());
        dto.setId_Sap(supplier.getId_Sap());
        dto.setName(supplier.getName());
        dto.setClassification(supplier.getClassification());
        dto.setTotalScore(supplier.getTotalScore());

        return dto;
    }
//    List<SupplierDto> mapAll(List<Supplier>  supplierList){
//        List<SupplierDto> listSuppliersDto=new LinkedList<>();
//        List<Supplier>  supplierList =supplierRepo.
//    }
//
//
//
//    void add(SupplierDto listSuppliersDto) {
//        listSuppliersDto.add(0, listSuppliersDto);
//    }

}
