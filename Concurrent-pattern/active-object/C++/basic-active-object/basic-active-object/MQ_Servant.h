#pragma once
class MQ_Servant
{
public:
	// Constructor
	MQ_Servant(size_t mq_size);

	// Message queue implementation operations
	void put_i(const Message &msg);

	Message get_i();

	// Predicates
	bool empty_i() const;

	bool full_i() const;

private:
	// Internal queue implementation, e.g,
	// a circular array for a linked list, etc
};

