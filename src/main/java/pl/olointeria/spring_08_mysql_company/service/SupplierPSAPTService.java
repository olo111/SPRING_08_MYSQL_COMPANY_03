package pl.olointeria.spring_08_mysql_company.service;



import org.springframework.stereotype.Service;
import pl.olointeria.spring_08_mysql_company.dto.SupplierDto;
import pl.olointeria.spring_08_mysql_company.dto.SupplierPSAPTDto;
import pl.olointeria.spring_08_mysql_company.dto.SupplierPSCPSDto;
import pl.olointeria.spring_08_mysql_company.prima.Supplier;
import pl.olointeria.spring_08_mysql_company.prima.SupplierPSAPTRepository;
import pl.olointeria.spring_08_mysql_company.prima.SupplierPSCPSRepository;
import pl.olointeria.spring_08_mysql_company.prima.SupplierRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SupplierPSAPTService {

    private final SupplierPSAPTRepository supplierPSAPTRepository;
    private final SupplierPSAPTDtoMapper supplierPSAPTDtoMapper;

    public SupplierPSAPTService(SupplierPSAPTRepository supplierPSAPTRepository, SupplierPSAPTDtoMapper supplierPSAPTDtoMapper) {
        this.supplierPSAPTRepository = supplierPSAPTRepository;
        this.supplierPSAPTDtoMapper = supplierPSAPTDtoMapper;
    }


    public Optional<SupplierPSAPTDto> getSupplierById(Integer id) {
        return supplierPSAPTRepository.findById(id)
                .map(supplierPSAPTDtoMapper::map);
    }


}



