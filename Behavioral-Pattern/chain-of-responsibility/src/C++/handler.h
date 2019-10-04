#pragma once
#include "pch.h"
#include "request.h"

class Handler
{
public:
	Handler(Handler* handler = nullptr) : m_pNextHandler(handler)
	{
		// nothing to do
	}

	virtual void handleRequest(Request request)
	{
		// nothing to do
	}

	virtual void setNextHandler(Handler* handler)
	{
		m_pNextHandler = handler;
	}

	Handler* getNextHandler()
	{
		return m_pNextHandler;
	}

private:
	Handler* m_pNextHandler;
};