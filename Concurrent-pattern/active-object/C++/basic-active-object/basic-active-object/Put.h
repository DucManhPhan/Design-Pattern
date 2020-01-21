#pragma once
#include "Method_Request.h"
#include "MQ_Servant.h"

class Put: public Method_Request
{
public:
	Put(MQ_Servant *rep, Message arg) : servant_(rep), arg_(arg)
	{
		// nothing to do
	}

	virtual bool guard() const
	{
		// Synchronization constraint: only allow
		// <put_i> calls when the queue is not full.
		return !this->servant_->full_i();
	}

	virtual void call() {
		// Insert message into servant
		this->servant_->put_i(arg_);
	}

private:
	MQ_Servant *servant_;
	Message arg_;
};

