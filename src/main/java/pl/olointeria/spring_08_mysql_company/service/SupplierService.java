package pl.olointeria.spring_08_mysql_company.service;

import org.springframework.stereotype.Service;
import pl.olointeria.spring_08_mysql_company.dto.SupplierDto;
import pl.olointeria.spring_08_mysql_company.prima.Supplier;
import pl.olointeria.spring_08_mysql_company.prima.SupplierRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SupplierService {

        private final SupplierRepository supplierRepository;
        private final SupplierDtoMapper supplierDtoMapper;

    public SupplierService(SupplierRepository supplierRepository, SupplierDtoMapper supplierDtoMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierDtoMapper = supplierDtoMapper;
    }


    public Optional<SupplierDto> getSupplierById(Integer id) {
            return supplierRepository.findById(id)
                    .map(supplierDtoMapper::map);
        }


    }

