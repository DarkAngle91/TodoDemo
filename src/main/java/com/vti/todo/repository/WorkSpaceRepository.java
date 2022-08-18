package com.vti.todo.repository;

import com.vti.todo.dto.response.WorkSpaceResponse;
import com.vti.todo.entity.WorkSpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkSpaceRepository extends JpaRepository<WorkSpaceEntity,Integer> {
    List<WorkSpaceResponse> getWorkSpaceResponseByUserEmail();
}
