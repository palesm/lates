package de.jonashackt.springbootvuejs.repository;


import de.jonashackt.springbootvuejs.domain.Late;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface LateRepository extends JpaRepository<Late, Long> {

    List<Late> findAllByOrderByDateAsc();

    @Query("select new Late(l.name, sum(l.minutes), l.date) from Late l group by l.name order by sum(l.minutes) desc")
    List<Late> getStatList();

}
