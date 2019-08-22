#include <iostream>
#include "ITheme.h"
#include "ThemeFactory.h"


// Client is not dependence to the other specific term 
// such as DarkTheme/DarkToolbar/DarkDialog, LightTheme/LightToolbar/LightDialog
int main()
{
	// user choose dark theme
	int nType = -1;
	do {
		std::cout << "Do you want to choose Dark theme or Light theme (0/1)?\n";
		std::cin >> nType;

		if (nType > 1 || nType < 0)
		{
			std::cout << "You should choose Dark theme (0) or Light theme (1).\n";
		}
	} while (nType > 1 || nType < 0);

	ThemeType type = nType == 0 ? ThemeType::DARK : ThemeType::LIGHT;

	ITheme* pTheme = ThemeFactory::createTheme(type);
	IToolbar* pToolbar = pTheme->createToolbar(type);
	IDialog* pDialog = pTheme->createDialog(type);

	pToolbar->display();
	pDialog->display();

	system("pause");
	return 0;
}