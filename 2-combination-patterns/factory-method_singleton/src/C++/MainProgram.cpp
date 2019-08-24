#include "stdafx.h"
#include "EmployeeService.h"
#include "DatabaseConnectionFactory.h"
#include "Configuration.h"

int main()
{
	Configuration* config = Configuration::getConfig();

	IDatabaseConnection* dbconnection = DatabaseConnectionFactory::getConnection(config->getDatabaseType());
	EmployeeService* service = new EmployeeService(dbconnection);

	Employee obama(1, "Barack", "Obama", "10/02/1956", "President");
	Employee clinton(2, "Bin", "Clinton", "06/05/1950", "President");

	service->create(obama);
	service->create(clinton);

	service->remove(1);

	system("pause");
	return 0;
}