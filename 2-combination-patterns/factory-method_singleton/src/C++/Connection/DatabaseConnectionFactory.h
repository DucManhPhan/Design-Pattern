#pragma once
#include "stdafx.h"
#include "IDatabaseConnection.h"
#include "MySqlDatabaseConnection.h"
#include "PostgreDatabaseConnection.h"
#include "SqliteDatabaseConnection.h"
#include "DatabaseType.h"



class DatabaseConnectionFactory
{
public:
	static IDatabaseConnection* getConnection(DatabaseType type)
	{
		if (connections.find(type) != connections.end())
		{
			return connections[type];
		}

		// if no exist
		return createConnection(type);
	}

private:
	static IDatabaseConnection* createConnection(DatabaseType type)
	{
		switch (type)
		{
		case DatabaseType::MYSQL:
			connections[type] = new MySqlDatabaseConnection();
			break;

		case DatabaseType::POSTGRE:
			connections[type] = new PostgreDatabaseConnection();
			break;

		case DatabaseType::SQLITE:
			connections[type] = new SqliteDatabaseConnection();
			break;

		default:
			std::cout << "No support this database type.\n";
			return nullptr;
		}

		return connections[type];
	}

private:
	static std::unordered_map<DatabaseType, IDatabaseConnection*> connections;
	
};

std::unordered_map<DatabaseType, IDatabaseConnection*> DatabaseConnectionFactory::connections = {};