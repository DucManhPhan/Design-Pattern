#pragma once
class MQ_Proxy
{
public:
	// Bound the message queue size
	const int MQ_MAX_SIZE = 100;

	MQ_Proxy(size_t size = MQ_MAX_SIZE) : scheduler_ (new MQ_Scheduler(size)),
									      servant_ (new MQ_Servant(size))
	{
		// nothing to do
	}

	// Schedule <put> to execute on the Active Object
	void put(const Message &msg)
	{
		Method_Request *method_request = new Put(servant_, msg);
		scheduler_->enqueue(method_request);
	}

	// Return a Message_Future as the future
	// result of an asynchronous <get>
	// method on the Active Object
	Message_Future get()
	{
		Message_Future result;
		Method_Request *method = new Get(servant_, result);
		this->scheduler_->enqueue(method_request);

		return result;
	}

	bool empty()
	{
		return false;
	}

	bool full()
	{
		return false;
	}

protected:
	// The servant that implements the Active Object methods
	MQ_Servant *servant_;

	// A scheduler for the message queue
	MQ_Scheduler *scheduler_;
};

