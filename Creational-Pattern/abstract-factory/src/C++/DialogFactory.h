#pragma once
#include "stdafx.h"
#include "IToolbar.h"
#include "ThemeType.h"
#include "LightDialog.h"
#include "DarkDialog.h"


class DialogFactory
{
public:

	static IDialog* createDialog(ThemeType type)
	{
		switch (type)
		{
		case ThemeType::LIGHT:
			return new LightDialog();

		case ThemeType::DARK:
			return new DarkDialog();

		default:
			return nullptr;
		}
	}
};