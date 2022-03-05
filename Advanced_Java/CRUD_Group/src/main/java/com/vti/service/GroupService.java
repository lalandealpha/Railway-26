package com.vti.service;

import com.vti.entity.Group;
import com.vti.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService{

    @Autowired
    private IGroupRepository repository;

    public List<Group> getAllGroups() {
        return repository.getAllGroups();
    }

    public Group getGroupByID(int id) {
        return repository.getGroupByID(id);
    }

    public Group getGroupByName(String name) {
        return repository.getGroupByName(name);
    }

    public void createGroup(Group group) {
        repository.createGroup(group);
    }

    public void updateGroup(int id, String newName) {
        repository.updateGroup(id, newName);
    }

    public void updateGroup(Group group) {
        repository.updateGroup(group);
    }

    public void deleteGroup(int id) {
        repository.deleteGroup(id);
    }

    public boolean isGroupExistsByID(int id) {
        return repository.isGroupExistsByID(id);
    }

    public boolean isGroupExistsByName(String name) {
        return repository.isGroupExistsByName(name);
    }
}
