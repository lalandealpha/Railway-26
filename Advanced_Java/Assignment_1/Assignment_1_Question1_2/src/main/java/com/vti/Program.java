

package com.vti;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        GroupRepository groupRepository = new GroupRepository();

        // get list group
        List<Group> groups = groupRepository.getAllGroups();
        for (Group group : groups) {
            System.out.println(group);
        }

        // get group by id
        System.out.println(groupRepository.getGroupByID(1));

        // create group
        Group group1 = new Group();
        group1.setName("Group 1");
        group1.setCreateDate(new Date());

        // update group
        groupRepository.updateGroup(2, "new Name", new Date());

        // update group
        Group group2 = new Group();
        group2.setId(3);
        group2.setName("Testing...");
        group2.setCreateDate(new Date());

        groupRepository.updateGroup(group2);

        // delete group
        groupRepository.deleteGroup(1);

        // check group existing by id
        System.out.println(groupRepository.isGroupExistsByID(1));

        // check group existing by name
        System.out.println(groupRepository.isGroupExistsByName("Testing..."));
    }
}

