package com.example.egudanna.service;

import com.example.egudanna.domain.Category;
import com.example.egudanna.domain.Group;
import com.example.egudanna.dto.Group.GroupResponse;
import com.example.egudanna.repository.CategoryRepository;
import com.example.egudanna.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroupService {

    private final CategoryRepository categoryRepository;
    private final GroupRepository groupRepository;


    public Group createGroup(GroupResponse groupResponse) {
        Optional<Category> category = categoryRepository.findById(groupResponse.getGenre());
        if (category.isPresent()) {
            Group group = new Group();
            group.setName(groupResponse.getName());
            group.setCategory(category.get());
            return groupRepository.save(group);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    public List<Group> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groupRepository.findAll();
    }

    public Group getCategoryGenreByGroupId(Long groupId) {
        return groupRepository.findGroupById(groupId);
    }

    public void delete(Long groupid) {
        groupRepository.deleteById(groupid);
    }



}
