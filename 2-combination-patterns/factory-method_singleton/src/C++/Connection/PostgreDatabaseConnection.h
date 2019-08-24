#pragma once
#include "stdafx.h"
#include "IDatabaseConnection.h"


class PostgreDatabaseConnection : public IDatabaseConnection
{
public:
	void executeQuery(const std::string& query)
	{
		std::cout << "Execute PostgreSQL's query " << query << "\n";
	}
};