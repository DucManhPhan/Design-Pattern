#pragma once
#include "ITheme.h"
#include "IDialog.h"
#include "IToolbar.h"
#include "ToolbarFactory.h"
#include "DialogFactory.h"


class DarkTheme : public ITheme
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