package com.example.egudanna.controller;

import com.example.egudanna.domain.Group;
import com.example.egudanna.dto.Group.GroupResponse;
import com.example.egudanna.repository.GroupRepository;
import com.example.egudanna.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public Group createGroup(@RequestBody GroupResponse groupResponse) {
        return groupService.createGroup(groupResponse);
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{group_id}")
    public ResponseEntity<Group> getCategoryGenreByGroupId(@PathVariable("group_id") long group_id) {
        Group group=groupService.getCategoryGenreByGroupId(group_id);
        return ResponseEntity.ok(group);
    }

    @DeleteMapping("/{group_id}")
    public void deleteGroup(@PathVariable("group_id") long group_id) {
        groupService.delete(group_id);
    }

}
