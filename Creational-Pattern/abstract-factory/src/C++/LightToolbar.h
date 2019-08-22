#pragma once
#include "stdafx.h"
#include "IToolbar.h"

class LightToolbar : public IToolbar
{
public:
	void display()
	{
		std::cout << "Light toolbar.\n";
	}
	
};