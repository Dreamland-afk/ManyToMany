package com.dreamquest.manytomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamquest.manytomany.dao.EmployeeDAO;
import com.dreamquest.manytomany.entity.Employee;
import com.dreamquest.manytomany.entity.Reservation;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional
	public void save(Employee employee) {
		Employee employeereturn =  employeeDAO.save(employee);
		System.out.println(employeereturn.getReservations());
		
	}

	public Employee findById(Long id) {

		Optional<Employee> optional = employeeDAO.findById(id);

		if (optional.isEmpty()) {
			System.out.println("Not Found");
			return null;
		}
		return optional.get();

	}

	@Transactional
	public List<Reservation> findByIdWithReservations(Long id) {

		Optional<Employee> optional = employeeDAO.findById(id);

		if (optional.isEmpty()) {
			System.out.println("Not Found");
			return null;
		}
		return optional.get().getReservations();

	}
	
	@Transactional
	public String bookASpot(Long id, Reservation reservation) {

		Optional<Employee> optional = employeeDAO.findById(id);

		if (optional.isEmpty()) {
			System.out.println("Not Found");
			return null;
		}
//		List<Reservation> list =  optional.get().getReservations();
//		list.add(reservation);

		Employee employee =  optional.get();
		
		employee.getReservations();
		employee.bookSeat(reservation);
		
		save(employee);
		
		return "Reservation Successful.";

	}

}
