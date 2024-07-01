package com.example.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.Users;
import com.example.tunehub.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository repo;

	@Override
	public String addUsers(Users user) {

		repo.save(user);
		return "User created Successfully";
	}

	@Override
	public boolean emailExists(String email) {
		if (repo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {

		Users user = repo.findByEmail(email);
		String db_password = user.getPassword();

		if (db_password.equals(password)) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	public String role(String email) {

		return (repo.findByEmail(email).getRole());
	}

	@Override
	public Users getUser(String email) {

		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {

		repo.save(user);
	}

	@Override
	public boolean UpdatePassword(String email, String address, String password) {
		try {
			Users user = repo.findByEmail(email);
			String db_address = user.getAddress();

			if (repo.findByEmail(email) != null && db_address.equals(address)) {

				user.setPassword(password);
				repo.save(user);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

}
