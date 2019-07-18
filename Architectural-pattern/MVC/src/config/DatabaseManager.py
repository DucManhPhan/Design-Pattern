# https://www.guru99.com/python-mysql-example.html
import mysql.connector


class DatabaseManager:

    def get_connection(self):
        self.db_connection = mysql.connector.connect(
            host = "localhost",
            user = "root",
            passwd = "12345",
            database = "mvc_users"
        )

        return self.db_connection

    def get_db_manager(self):
        self.database = self.get_connection().cursor()
        return self.database