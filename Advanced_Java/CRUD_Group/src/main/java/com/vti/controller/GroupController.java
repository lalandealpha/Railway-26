package com.vti.controller;

import com.vti.dto.GroupDTOForCreating;
import com.vti.dto.GroupDTOForUpdating;
import com.vti.entity.Group;
import com.vti.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/groups")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class GroupController {

    @Autowired
    private IGroupService service;

    @GetMapping()
    public ResponseEntity<?> getAllGroups() {
        List<Group> groups = service.getAllGroups();
        return new ResponseEntity<List<Group>> (groups, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getGroupByID(@PathVariable(name = "id") int id) {
        return new ResponseEntity<Group> (service.getGroupByID(id), HttpStatus.OK);
    }

    @GetMapping(value ="/name/{name}/exists")
    public boolean existsByName(@PathVariable(name = "name") String name) {
        return service.isGroupExistsByName(name);
    }

    @PostMapping()
    public ResponseEntity<?> createGroup(@RequestBody GroupDTOForCreating dto) {
        service.createGroup(dto.toEntity());
        return new ResponseEntity<String> ("Create success!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable(name = "id") int id, @RequestBody GroupDTOForUpdating dto) {
        Group group = service.getGroupByID(id);
        group.setName(dto.getName());
        service.updateGroup(group);
        return new ResponseEntity<String> ("Update success!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable(name = "id") int id) {
        service.deleteGroup(id);
        return new ResponseEntity<String> ("Delete success!", HttpStatus.OK);
    }

}
