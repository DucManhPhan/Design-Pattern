#pragma once
#include "pch.h"



class ZeroHandler : public Handler
{
public:
	void handleRequest(Request request)
	{
		int val = request.getNum();

		if (val == 0)
		{
			std::cout << "Handler with 0 is called: " << val << "\n";
		}
		else
		{
			getNextHandler()->handleRequest(request);
		}
	}
};