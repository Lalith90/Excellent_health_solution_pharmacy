package com.excellenthealthSolution.pharmacy.asset.prescriber.service;

import com.excellenthealthSolution.pharmacy.util.interfaces.AbstractService;
import com.excellenthealthSolution.pharmacy.asset.prescriber.dao.DoctorDao;
import com.excellenthealthSolution.pharmacy.asset.prescriber.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorService implements AbstractService<Doctor, Long> {
    private final DoctorDao doctorDao;


    @Autowired
    public DoctorService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }



    public List<Doctor> findAll() {
        return doctorDao.findAll();
    }


    public Doctor findById(Long id) {
        return doctorDao.getOne(id);
    }


    public Doctor persist(Doctor doctor) {
        return doctorDao.save(doctor);
    }


    public boolean delete(Long id) {
        doctorDao.deleteById(id);
        return false;
    }


    public List<Doctor> search(Doctor doctor) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Doctor> doctorExample = Example.of(doctor, matcher);
        return doctorDao.findAll(doctorExample);
    }
}
