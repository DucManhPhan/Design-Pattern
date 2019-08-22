#pragma once
#include "stdafx.h"
#include "IDialog.h"


class DarkDialog : public IDialog
{
public:
	void display()
	{
		std::cout << "Dark dialog.\n";
	}

};