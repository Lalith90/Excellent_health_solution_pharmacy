package com.excellenthealthSolution.pharmacy.asset.prescriber.service;

import com.excellenthealthSolution.pharmacy.util.interfaces.AbstractService;
import com.excellenthealthSolution.pharmacy.asset.prescriber.dao.ConsultationDao;
import com.excellenthealthSolution.pharmacy.asset.prescriber.entity.Consultations;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsultationService implements AbstractService<Consultations, Long> {

    private ConsultationDao consultationDao;

    public ConsultationService(ConsultationDao consultationDao){
        this.consultationDao = consultationDao;
    }


    @Transactional
    public List<Consultations> findAll() {
        return consultationDao.findAll();
    }

    @Transactional
    public Consultations findById(Long id) {
        return consultationDao.getOne(id);
    }

    @Transactional
    public Consultations persist(Consultations consultations) {
        return consultationDao.save(consultations);
    }

    @Transactional
    public boolean delete(Long id) {
        consultationDao.deleteById(id);
        return false;
    }

    @Transactional
    public List<Consultations> search(Consultations consultations) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Consultations> consultationExample = Example.of(consultations, matcher);
        return consultationDao.findAll(consultationExample);
    }
}
