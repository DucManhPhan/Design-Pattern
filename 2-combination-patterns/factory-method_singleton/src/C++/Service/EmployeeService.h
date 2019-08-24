#pragma once
#include "stdafx.h"
#include "IDatabaseConnection.h"
#include "Employee.h"



class EmployeeService
{
public:
	EmployeeService()
	{
		// nothing to do
	}

	EmployeeService(IDatabaseConnection* connection)
	{
		this->connection = connection;
	}

	void create(const Employee& e)
	{
		connection->executeQuery("create new employee to database.");
	}

	void remove(int id)
	{
		std::string query = "remove employee that has id = ";
		connection->executeQuery(query.append(std::to_string(id)));
	}

private:
	IDatabaseConnection* connection;

};

