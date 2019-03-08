#pragma once

#include "pch.h"


class Singleton
{
public:
	static Singleton& getInstance();
	
private:
	Singleton();
	Singleton(const Singleton&);

	~Singleton();

	const Singleton& operator=(const Singleton&);
};
