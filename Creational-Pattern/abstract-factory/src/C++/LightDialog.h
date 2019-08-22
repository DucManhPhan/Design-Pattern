#pragma once
#include "stdafx.h"
#include "IDialog.h"


class LightDialog : public IDialog
{
public:
	void display()
	{
		std::cout << "Light dialog.\n";
	}

};