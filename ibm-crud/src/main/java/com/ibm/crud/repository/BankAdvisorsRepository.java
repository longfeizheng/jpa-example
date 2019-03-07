package com.ibm.crud.repository;

import com.ibm.crud.domain.BankAdvisors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAdvisorsRepository extends JpaRepository<BankAdvisors, Integer> {
}
