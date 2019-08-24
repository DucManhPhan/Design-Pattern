#pragma once
#include "stdafx.h"
#include "DatabaseType.h"
#include <mutex>
#include <atomic>


class Configuration
{
	
public:
	// 1st-way: use pre-initialized method
	static Configuration* getConfig()
	{
		static Configuration instance;
		return &instance;
	}

	// 2nd-way: use once function
	/*Configuration* getConfig()
	{
		std::call_once(configurationFlag, initConfiguration);
		return configuration;
	}*/

	DatabaseType getDatabaseType()
	{
		return this->type;
	}

	void setDatabaseType(DatabaseType type)
	{
		this->type = type;
	}

	std::string getHost()
	{
		return this->host;
	}

	void setHost(const std::string& host)
	{
		this->host = host;
	}

	std::string getPort()
	{
		return this->port;
	}

	void setPort(const std::string& port)
	{
		this->port = port;
	}

private:
	static Configuration* configuration;

	const std::string pathConfigFile = "config.properties";

	DatabaseType type;

	std::string host;

	std::string port;

	Configuration()
	{
		this->readConfigFile();
	}

	Configuration(const Configuration& config)
	{
		// nothing to do
	}

	void operator=(const Configuration& config)
	{
		// nothing to do
	}

	void readConfigFile()
	{
		this->host = "127.0.0.1";
		this->type = DatabaseType::MYSQL;
		this->port = "4652";
	}

	// 2nd-way
	/*static std::once_flag configurationFlag;

	static void initConfiguration()
	{
		configuration = new Configuration();
	}*/
	
};