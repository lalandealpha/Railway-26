package com.vti.service;

import com.vti.entity.Group;

import java.util.List;

public interface IGroupService {
    public List<Group> getAllGroups();

    public Group getGroupByID(int id);

    public Group getGroupByName(String name);

    public void createGroup(Group group);

    public void updateGroup(int id, String newName);

    public void updateGroup(Group group);

    public void deleteGroup(int id);

    public boolean isGroupExistsByID(int id);

    public boolean isGroupExistsByName(String name);
}
