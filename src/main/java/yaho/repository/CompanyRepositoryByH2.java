package yaho.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yaho.domain.Company;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryByH2 implements CompanyRepository{

    private final EntityManager em;

    @Override
    public Long save(Company company) {
        em.persist(company);
        return company.getId();
    }

    @Override
    public Company findByID(Long id) {
        return em.find(Company.class,id);
    }

    @Override
    public Company findByName(String name) {
        return em.createQuery("select c from Company c where c.name = :name", Company.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Company> findAll() {
        return em.createQuery("select c from Company c", Company.class)
                .getResultList();
    }
}
