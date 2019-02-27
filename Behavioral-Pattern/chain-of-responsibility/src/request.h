#pragma once
#include "pch.h"

class Request
{
public:
	Request(int num)
	{
		m_nNum = num;
	}

	int getNum()
	{
		return m_nNum;
	}


private:
	int m_nNum;
};
