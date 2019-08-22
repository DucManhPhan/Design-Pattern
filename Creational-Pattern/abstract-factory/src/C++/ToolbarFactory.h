#pragma once
#include "stdafx.h"
#include "IToolbar.h"
#include "ThemeType.h"
#include "LightToolbar.h"
#include "DarkToolbar.h"


class ToolbarFactory
{
public:

	static IToolbar* createToolbar(ThemeType type)
	{
		switch (type)
		{
		case ThemeType::LIGHT:
			return new LightToolbar();

		case ThemeType::DARK:
			return new DarkToolbar();

		default:
			return nullptr;
		}
	}

};