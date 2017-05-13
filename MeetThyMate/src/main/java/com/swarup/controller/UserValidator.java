package com.swarup.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.swarup.pojo.User;

public class UserValidator implements Validator {

	private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) obj;
		Pattern pattern = Pattern.compile(IMAGE_PATTERN);
		MultipartFile photo;
		Matcher matcher;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.invalid.gender", "Gender Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "error.invalid.userPassword",
				"Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.invalid.phone", "phone Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "email Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "profilePic", "error.invalid.profilePic",
				"profilePic Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.street", "error.invalid.address.street",
				"street Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.aptNo", "error.invalid.address.aptNo",
				"aptNo Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.zip", "error.invalid.address.zip", "zip Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "error.invalid.address.city",
				"city Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.state", "error.invalid.address.state",
				"state Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.country", "error.invalid.address.country",
				"country Required");
		photo = user.getProfilePic();
		matcher = pattern.matcher(photo.getOriginalFilename());
		String filename = photo.getOriginalFilename();
		if (0 == photo.getSize()) {
			errors.rejectValue("profilePic", "error.invalid.profilePic", "File is empty");
		}
		
//		if(!filename.isEmpty()){
//			String substring = filename.substring(filename.length() - 4);
//			
//			if ((substring.equals(".jpg")) || (substring.equals(".png")) || (substring.equals(".gif"))
//					|| (substring.equals(".bmp"))) {
//			}
//			else{
//				errors.rejectValue("profilePic", "error.invalid.profilePic", "Invalid Image Format");
//			}
//		}
		

		if (5000000 < photo.getSize()) {
			errors.rejectValue("profilePic", "error.invalid.profilePic", "File size is over 5mb !");
		}
	}

}
