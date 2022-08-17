package com.vti.todo.controller;

import com.vti.todo.dto.request.WorkSpaceRequest;
import com.vti.todo.dto.response.WorkSpaceResponse;
import com.vti.todo.entity.WorkSpaceEntity;
import com.vti.todo.service.WorkSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/workspaces")
public class WorkSpaceController {

    @Autowired
    private WorkSpaceService workSpaceService;

    @PostMapping
    public WorkSpaceResponse createWorkSpace(@RequestBody @Valid WorkSpaceRequest request) {
        return workSpaceService.createWorkSpace(request);
    }
}
