package com.Hans.Project.Service;

import com.Hans.program.bean.StudentDto;

public interface IStudentService {
	public String insertRecord(StudentDto stdDto);
	public StudentDto readRecord(Integer sid);
	public String deleteRecord(Integer sid);
	public String updateRecord(StudentDto stdDto);

}
