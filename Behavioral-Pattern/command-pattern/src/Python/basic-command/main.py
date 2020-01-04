from receiver import Receiver
from command import Command, ConcreteCommand
from invoker import Invoker


if __name__ == "__main__":
    recv = Receiver()
    cmd = ConcreteCommand(recv)
    invoker = Invoker()
    invoker.command(cmd)
    invoker.execute()
