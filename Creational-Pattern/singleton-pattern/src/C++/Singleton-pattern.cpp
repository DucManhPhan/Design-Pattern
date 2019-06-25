#include "pch.h"
#include "Singleton-pattern.h"


Singleton::Singleton()
{
	// nothing to do
}

Singleton::Singleton(const Singleton&)
{
	// nothing to do
}

Singleton::~Singleton()
{
	// nothing to do
}

const Singleton& Singleton::operator=(const Singleton&)
{
	// nothing to do
}

Singleton& Singleton::getInstance()
{
	static Singleton instance; 

	return instance;
}
