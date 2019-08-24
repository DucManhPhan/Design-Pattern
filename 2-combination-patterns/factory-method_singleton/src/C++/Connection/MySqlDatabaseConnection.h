#pragma once
#include "IDatabaseConnection.h"


class MySqlDatabaseConnection : public IDatabaseConnection
{
public:

	void executeQuery(const std::string& query)
	{
		std::cout << "Execute MySQL's query: " << query << "\n";
	}
};
