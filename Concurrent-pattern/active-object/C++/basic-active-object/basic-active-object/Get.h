#pragma once
#include "MQ_Servant.h"


class Get : public MQ_Servant
{
public:
	Get(MQ_Servant *rep, const Message_Future &f) : servant_(rep), result_(f)
	{
		// nothing to do
	}

	bool guard() const
	{
		// Synchronization constraint: cannot call
		// a <get_i> method until the queue is not empty.
		return !servant_->empty_i();
	}

private:
	MQ_Servant *servant_;

	Message_Future result_;
};

