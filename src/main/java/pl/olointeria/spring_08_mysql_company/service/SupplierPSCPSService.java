package pl.olointeria.spring_08_mysql_company.service;



import org.springframework.stereotype.Service;
import pl.olointeria.spring_08_mysql_company.dto.SupplierDto;
import pl.olointeria.spring_08_mysql_company.dto.SupplierPSCPSDto;
import pl.olointeria.spring_08_mysql_company.prima.Supplier;
import pl.olointeria.spring_08_mysql_company.prima.SupplierPSCPSRepository;
import pl.olointeria.spring_08_mysql_company.prima.SupplierRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SupplierPSCPSService {

    private final SupplierPSCPSRepository supplierPSCPSRepository;
    private final SupplierPSCPSDtoMapper supplierPSCPSDtoMapper;

    public SupplierPSCPSService(SupplierPSCPSRepository supplierPSCPSRepository, SupplierPSCPSDtoMapper supplierPSCPSDtoMapper) {
        this.supplierPSCPSRepository = supplierPSCPSRepository;
        this.supplierPSCPSDtoMapper = supplierPSCPSDtoMapper;
    }


    public Optional<SupplierPSCPSDto> getSupplierById(Integer id) {
        return supplierPSCPSRepository.findById(id)
                .map(supplierPSCPSDtoMapper::map);
    }



}


