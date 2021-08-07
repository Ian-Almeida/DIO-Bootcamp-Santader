package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.WorkTime;
import com.dio.controlepontoacesso.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/worktime")
public class WorkTimeController {

    WorkTimeService workTimeService;

    @Autowired
    public WorkTimeController(WorkTimeService workTimeService) {
        this.workTimeService = workTimeService;
    }

    @GetMapping("/{id}")
    public WorkTime getWorkTimeById(@PathVariable Long id) {
        WorkTime workTime = workTimeService.get(id);

        if(workTime == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Worktime not found");
        }
        return workTime;
    }

    @GetMapping("/")
    public List<WorkTime> getAllWorkTime() {
        return workTimeService.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<WorkTime> createWorkTime(@RequestBody WorkTime workTime) {
        return ResponseEntity.ok(workTimeService.save(workTime));
    }

    @PutMapping("/")
    public ResponseEntity<WorkTime> updateWorkTime(@RequestBody WorkTime workTime) {
        return ResponseEntity.ok(workTimeService.save(workTime));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkTime> deleteWorkTime(@PathVariable Long id) {

        WorkTime workTime = workTimeService.delete(id);

        if(workTime == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Worktime not found");
        }

        return ResponseEntity.ok(workTime);
    }
}
