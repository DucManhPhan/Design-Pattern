# https://www.codespeedy.com/how-to-install-mysql-connector-in-python/

import sys
import os
from dto import UserDto as user_dto
from model.UserModel import UserModel


if __name__ == "__main__":
    dto = user_dto.UserDto("Tony Buzan 1", "Dan", "Brown", "Tiger1234565", "hugo@gmail.com", 2)
    usermodel = UserModel()
    usermodel.insert(dto)