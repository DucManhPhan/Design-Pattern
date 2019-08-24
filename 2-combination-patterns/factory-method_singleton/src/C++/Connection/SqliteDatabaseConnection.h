#pragma once
#include "stdafx.h"
#include "IDatabaseConnection.h"


class SqliteDatabaseConnection : public IDatabaseConnection
{
public:
	void executeQuery(const std::string& query)
	{
		std::cout << "Execute SQLite's query " << query << "\n";
	}
};