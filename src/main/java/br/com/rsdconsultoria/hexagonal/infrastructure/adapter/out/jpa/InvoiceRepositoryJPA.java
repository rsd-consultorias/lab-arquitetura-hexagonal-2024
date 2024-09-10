package br.com.rsdconsultoria.hexagonal.infrastructure.adapter.out.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepositoryJPA extends JpaRepository<InvoiceEntity, UUID> {

}
