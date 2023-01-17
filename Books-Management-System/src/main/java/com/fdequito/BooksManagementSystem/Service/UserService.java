package com.fdequito.BooksManagementSystem.Service;

import com.fdequito.BooksManagementSystem.Entity.User;
import com.fdequito.BooksManagementSystem.Service.Web.DTO.UserRegistrationDTO;

public interface UserService  {

	User save(UserRegistrationDTO userRegistrationDTO);
}
