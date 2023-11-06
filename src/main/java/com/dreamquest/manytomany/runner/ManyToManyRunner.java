package com.dreamquest.manytomany.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dreamquest.manytomany.dao.ReservationDAO;
import com.dreamquest.manytomany.entity.Employee;
import com.dreamquest.manytomany.entity.Reservation;
import com.dreamquest.manytomany.service.EmployeeService;
import com.dreamquest.manytomany.service.ReservationService;

@Component
@SuppressWarnings("unused")
public class ManyToManyRunner implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ReservationService reservationService;

	@Override
	public void run(String... args) throws Exception {

//		createEmployee();

//		findEmployee(1);
		
//		findEmployeeReservations(1);

//		reservation();

//		addReservation();
		
		getEmployeesPerDate();

	}

	
	private void getEmployeesPerDate() {
		List<Employee> employees = reservationService.getEmployeesPerDate();
		
		for(Employee employee :  employees)
		{
			System.out.println(employee);
		}
	}


	private void addReservation() {
		
		Reservation reservation = new Reservation("Dubai");

		employeeService.bookASpot(1l, reservation);
		System.out.println("New reservation complteted.");

	}

	private void reservation() {
		System.out.println("Saving Reservation");

		Employee employee = new Employee("Sayan", "Das", "acdc@gmail");
		Reservation reservation = new Reservation("Ultadanga");

		reservation.setEmployees(Arrays.asList(employee));

		reservationService.save(reservation);

		System.out.println("Reservation saved");
	}

	private void findEmployee(long id) {

		Employee employee = employeeService.findById(id);

		System.out.println(employee.getReservations());
	}

	private void findEmployeeReservations(long id) {

		System.out.println( employeeService.findByIdWithReservations(id));
	}

	private void createEmployee() {
		System.out.println("Saving Employee");

		Employee employee = new Employee("Rohan", "mondal", "rohan@gmail");
		Reservation reservation = new Reservation("Singur");

		employee.setReservations(Arrays.asList(reservation));

		employeeService.save(employee);

		System.out.println("Employee saved");

	}

}
