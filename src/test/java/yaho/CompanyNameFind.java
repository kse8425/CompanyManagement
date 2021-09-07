package yaho;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import yaho.repository.CompanyRepository;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
class CompanyNameFind {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired EntityManager em;

    @Test
    void findMatch() {
        List<String> list = em.createQuery("select name from Company c", String.class)
                .getResultList();
        list.stream().forEach(s -> System.out.println(s));

        list = em.createQuery("select name from Company c where c.name like :name", String.class)
                .setParameter("name","s%")
                .getResultList();
        list.stream().forEach(s -> System.out.println(s));
    }
}