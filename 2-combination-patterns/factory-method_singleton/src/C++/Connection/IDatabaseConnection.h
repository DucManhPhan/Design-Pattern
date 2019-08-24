#pragma once
#include "stdafx.h"


class IDatabaseConnection
{
public:
	virtual void executeQuery(const std::string& query) = 0;
};