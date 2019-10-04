#pragma once
#include "pch.h"


class PositiveHandler : public Handler
{
public:
	void handleRequest(Request request)
	{
		int val = request.getNum();

		if (val > 0)
		{
			std::cout << "Handler with positive number is called: " << val << "\n";
		}
		else
		{
			getNextHandler()->handleRequest(request);
		}
	}
};