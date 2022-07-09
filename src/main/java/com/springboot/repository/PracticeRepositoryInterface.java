package com.springboot.repository;

import java.util.List;

public interface PracticeRepositoryInterface<T> {
	
	public List<T> fetchAllStudents();
	
	public List<T> fetchStudentById(String id);
	
	public void createStudentEntry(T t);
	
	public void updateEntryById(String id);
	
	public void deleteEntryById(String id);
	
	public List<T> fetchAllPassOuts();
	
	public List<T> fetchPassoutById(String id);

	
}
