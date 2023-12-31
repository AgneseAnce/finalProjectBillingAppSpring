package com.finalprojectbillingapp.invoice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface InvoiceProductRepository extends CrudRepository<InvoiceProductEntity, UUID> {
    List<InvoiceProductEntity> findAll();
    List<InvoiceProductEntity> findAllByInvoice_id(UUID invoiceId);


}
