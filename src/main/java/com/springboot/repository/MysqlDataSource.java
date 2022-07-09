package com.springboot.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.dao.Student;

@Repository
public class MysqlDataSource implements PracticeRepositoryInterface<Student> {

	private final String fetchstudents = "SELECT * FROM student.dataentry;";
	private final String fetchPassOuts = "SELECT * FROM passouts.allpassouts;";
	private final String fetchStudentById = "SELECT * FROM student.dataentry WHERE ID = ?";
	private final String fetchPassoutbyId = "SELECT * FROM passouts.allpassouts WHERE ID = ?";

	@Autowired
	@Qualifier("studentsTemplate")
	private JdbcTemplate studentTemplate;

	@Autowired
	@Qualifier("passoutTemplate")
	private JdbcTemplate passOutTemplate;

	/*
	 * public MysqlDataSource(JdbcTemplate mysqlTemplate) { this.mysqlTemplate =
	 * mysqlTemplate; }
	 */
	@Override
	public List<Student> fetchAllStudents() {

		return studentTemplate.query(fetchstudents, rows);
	}

	@Override
	public List<Student> fetchStudentById(String id) {

		try {
			return List.of(studentTemplate.queryForObject(fetchStudentById, new Object[] { id }, rows));
		} catch (Exception e) {
			return new ArrayList<Student>();
		}
	}

	@Override
	public void createStudentEntry(Student t) {

	}

	@Override
	public void updateEntryById(String id) {

	}

	@Override
	public void deleteEntryById(String id) {

	}

	RowMapper<Student> rows = (rs, rw) -> {

		Student st = new Student();

		st.setId(rs.getString("ID"));
		st.setAge(rs.getString("AGE"));
		st.setName(rs.getString("NAME"));
		st.setEmail(rs.getString("EMAIL"));
		st.setDob(Optional.ofNullable(rs.getString("DOB")).orElse("Dob not found in records!!"));
		st.setYear(Optional.ofNullable(rs.getString("Year")).orElse("Current year not available in record"));

		return st;
	};

	RowMapper<Student> passRows = (rs, rw) -> {

		Student st = new Student();

		st.setId(rs.getString("ID"));
		st.setAge(rs.getString("AGE"));
		st.setName(rs.getString("NAME"));
		st.setEmail(rs.getString("EMAIL"));
		st.setCgpa("CGPA");
		return st;
	};

	@Override
	public List<Student> fetchAllPassOuts() {

		return passOutTemplate.query(fetchPassOuts, passRows);
	}

	@Override
	public List<Student> fetchPassoutById(String id) {
		try {
			return List.of(passOutTemplate.queryForObject(fetchPassoutbyId, new Object[] { id }, rows));
		} catch (Exception e) {
			return new ArrayList<Student>();
		}
	}

}
