#pragma once
#include "ThemeType.h"
#include "DarkTheme.h"
#include "LightTheme.h"


class ThemeFactory
{
public:

	static ITheme* createTheme(ThemeType type)
	{
		switch (type)
		{
		case ThemeType::LIGHT:
			return new LightTheme();

		case ThemeType::DARK:
			return new DarkTheme();

		default:
			return nullptr;
		}
	}

};