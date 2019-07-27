# https://www.codespeedy.com/how-to-install-mysql-connector-in-python/

import sys
import os
from dto import UserDto as user_dto
from model.UserModel import UserModel
from controller import Controller as controller


if __name__ == "__main__":
    controller = controller.Controller()
    controller.start()
