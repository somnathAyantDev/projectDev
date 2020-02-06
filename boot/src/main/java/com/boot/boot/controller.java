package com.boot.boot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class controller {
	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping(value="/students",method=RequestMethod.GET)
	public ResponseEntity<?> students(){

		HttpStatus httpStatus = null;
		Student st1=new Student();
		try {
			st1.setName("Somnath Biswas");
			st1.setRoll(22);
			httpStatus=HttpStatus.OK;
		}
		catch(Exception ex) {
			httpStatus=HttpStatus.EXPECTATION_FAILED;
			return new ResponseEntity<>(httpStatus);

		}
		return new ResponseEntity<Student>(st1,httpStatus);
	}
	@RequestMapping(value="/studentsFallBack",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="studentsFallBackRescue")
	public ResponseEntity<?> studentsFallBack(){
		/*HttpStatus httpStatus = null;
		String res="ok"; 
		System.out.println("=====");
		try {
			httpStatus=HttpStatus.OK;
			throw new RuntimeException("error");

		}
		catch(Exception ex) {
			httpStatus=HttpStatus.EXPECTATION_FAILED;
			res= "error";

		}
		return new ResponseEntity<String>(res,httpStatus);
		//return res;
*/	
				throw new RuntimeException("error");
	}
	
	public ResponseEntity<?> studentsFallBackRescue(){
		HttpStatus httpStatus = null;
		Student st1=new Student();
		try {

			st1.setName("Somnath Biswas");
			st1.setRoll(25);
			httpStatus=HttpStatus.OK;
		}
		catch(Exception ex) {
			httpStatus=HttpStatus.EXPECTATION_FAILED;
			return new ResponseEntity<>(httpStatus);

		}
		return new ResponseEntity<Student>(st1,httpStatus);
	}


}
