#pragma once
#include "ITheme.h"
#include "ToolbarFactory.h"
#include "DialogFactory.h"



class LightTheme : public ITheme
{
public:

	IToolbar* createToolbar(ThemeType type)
	{
		return ToolbarFactory::createToolbar(type);
	}

	IDialog* createDialog(ThemeType type)
	{
		return DialogFactory::createDialog(type);
	}

};