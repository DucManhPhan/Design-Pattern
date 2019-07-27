from model import BaseModel as base_model
from config import DatabaseManager as db_manager
from dto import UserDto as user_dto
import mysql.connector

class UserModel(base_model.BaseModel):

    def insert(self, dto):
        db_connection = mysql.connector.connect(
            host = "localhost",
            user = "root",
            passwd = "12345",
            database = "mvc_users"
        )
        db = db_connection.cursor()

        sql = """INSERT INTO USER (USER_NAME, FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, GENDER) 
                 VALUES (%s, %s, %s, %s, %s, %s);"""
        params = (dto.username, dto.firstname, dto.lastname, dto.password, dto.email, dto.gender)

        db.execute(sql, params)
        db_connection.commit()

        # self.manager = db_manager.DatabaseManager()
        # database = self.manager.get_db_manager()
        # con = self.manager.get_connection()
        # result = database.execute(sql, params)
        # print(result)
        # con.commit()

        # closing database connection
        # if database.get_connection().is_connected():
        #     database.get_db_manager().close()
        #     database.get_connection().close()
        #     print("MYSQL connection is closed.")
