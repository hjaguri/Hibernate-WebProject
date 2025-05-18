package com.Hans.Project.dao;

import com.Hans.program.bean.StudentBO;

public interface IStudentRepo {
	public String insertRecord(StudentBO stdBo);
	public StudentBO readRecord(Integer sid);
	public String deleteRecord(Integer sid);
	public String updateRecord(StudentBO stdBo);

}
