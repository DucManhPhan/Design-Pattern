#pragma once
#include "stdafx.h"
#include "IToolbar.h"


class DarkToolbar : public IToolbar
{
public:
	void display()
	{
		std::cout << "Dark toolbar.\n";
	}
};