package com.turkcell.elearner.ws.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountTypeModel {
	private String accountName;
	private Double price;
	private String description;
}
