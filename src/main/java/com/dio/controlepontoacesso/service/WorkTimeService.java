package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.WorkTime;
import com.dio.controlepontoacesso.repository.WorkTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class WorkTimeService {

    WorkTimeRepository workTimeRepository;

    @Autowired
    public WorkTimeService(WorkTimeRepository workTimeRepository) {
        this.workTimeRepository = workTimeRepository;
    }

    public WorkTime get(Long id) {
        Optional<WorkTime> workTimeOptional = workTimeRepository.findById(id);

        if(workTimeOptional.isEmpty()) {
            return null;
        }

        return workTimeOptional.get();
    }

    public List<WorkTime> getAll() {
        return workTimeRepository.findAll();
    }

    public WorkTime save(WorkTime workTime) {
        return workTimeRepository.save(workTime);
    }

    public WorkTime delete(Long id) {
        Optional<WorkTime> workTimeOptional = workTimeRepository.findById(id);

        if(workTimeOptional.isEmpty()) {
            return null;
        }
        WorkTime workTime = workTimeOptional.get();

        workTimeRepository.delete(workTime);

        return workTime;
    }

}
