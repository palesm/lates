package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.domain.Late;

import java.util.List;

public interface LateService {
    List<Late> getLates();

    Late create(Late late);

}
