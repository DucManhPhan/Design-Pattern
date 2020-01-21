#pragma once
class Method_Request
{
public:
	// Evaluate the synchronization constraint
	virtual bool guard() const = 0;

	// Execute the method
	virtual void call() = 0;
};

