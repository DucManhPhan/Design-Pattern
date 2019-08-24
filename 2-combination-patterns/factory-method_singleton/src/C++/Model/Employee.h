#pragma once
#include "stdafx.h"

class Employee
{
public:
	Employee()
	{
		// nothing to do
	}

	Employee( int id
			, std::string firstName
			, std::string lastName
			, std::string dateOfBirth
			, std::string job )
	{
		this->id = id;
		this->firstName = firstName;
		this->lastName = lastName;
		this->dateOfBirth = dateOfBirth;
		this->job = job;
	}

	// some getter/setter properties

private:
	int id;
	std::string firstName;
	std::string lastName;
	std::string dateOfBirth;
	std::string job;
};