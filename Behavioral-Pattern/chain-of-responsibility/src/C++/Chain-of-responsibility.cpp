// Chain-of-responsibility.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include "zero-handler.h"
#include "negative-handler.h"
#include "positive-handler.h"



int main()
{    
	Handler* negHandler = new NegativeHandler();
	Handler* zeroHandler = new ZeroHandler();
	Handler* posHandler = new PositiveHandler();

	negHandler->setNextHandler(zeroHandler);
	zeroHandler->setNextHandler(posHandler);

	negHandler->handleRequest(Request(2));
	negHandler->handleRequest(Request(-1));
	negHandler->handleRequest(Request(0));

	system("pause");
	return 0;
}