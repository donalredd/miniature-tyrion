package com.receipt.vault.webapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.receipt.vault.model.Test;
import com.receipt.vault.model.User;
import com.receipt.vault.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/users*")
	public String execute(ModelMap model) {
		model.addAttribute("userList", userService.findAll());
		return "userList";
	}

	@RequestMapping("/addUser*")
	public String add(ModelMap model) {

		User user = new User("email", "name", "password");
		userService.createUser(user);
		model.addAttribute("userList", userService.findAll());
		return "userList";
	}

	@RequestMapping(value = "jsonusers", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	List<State> fetchStatesJson() {
		return getStates();
	}

	@RequestMapping(value = "jsonfindall", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	Iterable<User> findAllDbUsers() {
		Iterable<User> findAll = userService.findAll();
		return findAll;
	}

	@RequestMapping(value = "test", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	List<Test> fetchUsers() {
		return Arrays.asList(new Test(Long.valueOf("1"), "dfas"),
				new Test(Long.valueOf("2"), "fda"));
	}

	private List<State> getStates() {
		ArrayList<State> states = new ArrayList<State>();
		states.add(new State("ALABAMA", "AL"));
		states.add(new State("ALASKA", "AK"));
		states.add(new State("ARIZONA", "AZ"));
		states.add(new State("ARKANSAS", "AR"));
		states.add(new State("CALIFORNIA", "CA"));
		states.add(new State("COLORADO", "CO"));
		states.add(new State("CONNECTICUT", "CT"));
		states.add(new State("DELAWARE", "DE"));
		states.add(new State("FLORIDA", "FL"));
		states.add(new State("GEORGIA", "GA"));
		states.add(new State("HAWAII", "HI"));
		states.add(new State("IDAHO", "ID"));
		states.add(new State("ILLINOIS", "IL"));
		states.add(new State("INDIANA", "IN"));
		states.add(new State("IOWA", "IA"));
		states.add(new State("KANSAS", "KS"));
		states.add(new State("KENTUCKY", "KY"));
		states.add(new State("LOUISIANA", "LA"));
		states.add(new State("MAINE", "ME"));
		states.add(new State("MARYLAND", "MD"));
		states.add(new State("MASSACHUSETTS", "MA"));
		states.add(new State("MICHIGAN", "MI"));
		states.add(new State("MINNESOTA", "MN"));
		states.add(new State("MISSISSIPPI", "MS"));
		states.add(new State("MISSOURI", "MO"));
		states.add(new State("MONTANA", "MT"));
		states.add(new State("NEBRASKA", "NE"));
		states.add(new State("NEVADA", "NV"));
		states.add(new State("NEW HAMPSHIRE", "NH"));
		states.add(new State("NEW JERSEY", "NJ"));
		states.add(new State("NEW MEXICO", "NM"));
		states.add(new State("NEW YORK", "NY"));
		states.add(new State("NORTH CAROLINA", "NC"));
		states.add(new State("NORTH DAKOTA", "ND"));
		states.add(new State("OHIO", "OH"));
		states.add(new State("OKLAHOMA", "OK"));
		states.add(new State("OREGON", "OR"));
		states.add(new State("PENNSYLVANIA", "PA"));
		states.add(new State("RHODE ISLAND", "RI"));
		states.add(new State("SOUTH CAROLINA", "SC"));
		states.add(new State("SOUTH DAKOTA", "SD"));
		states.add(new State("TENNESSEE", "TN"));
		states.add(new State("TEXAS", "TX"));
		states.add(new State("UTAH", "UT"));
		states.add(new State("VERMONT", "VT"));
		states.add(new State("VIRGINIA", "VA"));
		states.add(new State("WASHINGTON", "WA"));
		states.add(new State("WEST VIRGINIA", "WV"));
		states.add(new State("WISCONSIN", "WI"));
		states.add(new State("WYOMING", "WY"));
		return states;
	}
}
