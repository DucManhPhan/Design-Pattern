#pragma once
#include "ThemeType.h"
#include "IToolbar.h"
#include "IDialog.h"


class ITheme
{
public:

	virtual IToolbar* createToolbar(ThemeType type) = 0;

	virtual IDialog* createDialog(ThemeType type) = 0;

};