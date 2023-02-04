package pl.olointeria.spring_08_mysql_company.service;



import org.springframework.stereotype.Service;
import pl.olointeria.spring_08_mysql_company.dto.SupplierQ32022PSCPSDto;
import pl.olointeria.spring_08_mysql_company.prima.SupplierQ32022PSCPSRepository;
import pl.olointeria.spring_08_mysql_company.prima.SupplierQ32022PSCPSRepository;

import java.util.Optional;

@Service
public class SupplierQ32022PSCPSService {

    private final SupplierQ32022PSCPSRepository supplierQ32022PSCPSRepository;
    private final SupplierQ32022PSCPSDtoMapper supplierQ32022PSCPSDtoMapper;

    public SupplierQ32022PSCPSService(SupplierQ32022PSCPSRepository supplierQ32022PSCPSRepository, SupplierQ32022PSCPSDtoMapper supplierQ32022PSCPSDtoMapper) {
        this.supplierQ32022PSCPSRepository = supplierQ32022PSCPSRepository;
        this.supplierQ32022PSCPSDtoMapper = supplierQ32022PSCPSDtoMapper;
    }


    public Optional<SupplierQ32022PSCPSDto> getSupplierById(Integer id) {
        return supplierQ32022PSCPSRepository.findById(id)
                .map(supplierQ32022PSCPSDtoMapper::map);
    }



}


