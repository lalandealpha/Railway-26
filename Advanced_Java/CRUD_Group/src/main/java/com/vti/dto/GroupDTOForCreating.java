package com.vti.dto;

import com.vti.entity.Group;

import java.util.Date;

public class GroupDTOForCreating {
    private String name, creator;
    private int memberAmount;
    private Date createDate;


    public GroupDTOForCreating() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getMemberAmount() {
        return memberAmount;
    }

    public void setMemberAmount(int memberAmount) {
        this.memberAmount = memberAmount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Group toEntity() {
        return new Group(name, memberAmount, creator, createDate);
    }
}
