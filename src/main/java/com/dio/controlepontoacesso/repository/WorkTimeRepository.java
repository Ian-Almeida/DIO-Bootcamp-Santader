package com.dio.controlepontoacesso.repository;

import com.dio.controlepontoacesso.model.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {

}
