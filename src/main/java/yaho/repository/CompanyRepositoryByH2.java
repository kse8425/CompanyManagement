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
    public Company findByID(Long companyId) {
        return em.find(Company.class,companyId);
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

    @Override
    public List<String> findByMatch(String name) {
        return em.createQuery("select name from Company c where c.name like :name", String.class)
                .setParameter("name","%" + name + "%")
                .getResultList();
    }

    @Override
    public void deleteByID(Long id) {
        Company company = findByID(id);
        em.remove(company);
    }
}
