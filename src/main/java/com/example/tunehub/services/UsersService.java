package com.example.tunehub.services;

import com.example.tunehub.entities.Users;

public interface UsersService {

	public String addUsers(Users user);

	public boolean emailExists(String email);

	public boolean validateUser(String email, String password);

	public String role(String email);

	public Users getUser(String email);

	public void updateUser(Users user);

	public boolean UpdatePassword(String email, String address, String password);
}
