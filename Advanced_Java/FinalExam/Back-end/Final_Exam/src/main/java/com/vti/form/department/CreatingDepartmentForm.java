package com.vti.form.department;

import com.vti.entity.Department;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingDepartmentForm {

	private String name;

	private Department.Type type;

}
