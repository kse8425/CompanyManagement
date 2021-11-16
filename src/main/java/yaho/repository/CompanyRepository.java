package yaho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yaho.domain.Company;

import java.util.List;


public interface CompanyRepository extends JpaRepository<Company,Long> {

    Company findByName(String name);

    Company findByNameLike(String name);
}
