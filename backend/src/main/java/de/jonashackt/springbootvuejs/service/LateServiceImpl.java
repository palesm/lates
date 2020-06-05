package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.domain.Late;
import de.jonashackt.springbootvuejs.repository.LateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LateServiceImpl implements LateService {
    @Autowired
    private LateRepository lateRepository;

    @Override
    public List<Late> getLates() {
        return lateRepository.findAll();
    }

    public Late create(Late late) {
        Late s = new Late();
        s.setDate(late.getDate());
        s.setName(late.getName());
        s.setMinutes(late.getMinutes());
        return lateRepository.save(late);
    }
}
