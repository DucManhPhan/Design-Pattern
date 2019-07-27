from model import UserModel as user_model
from view import View as main_view
from dto import UserDto as user_dto

class Controller:

    def __init__(self):
        self.view = main_view.View(self)
        self.model = user_model.UserModel()

    def register(self):
        # validate data that has just filled in
        self.validate()

        # convert to dto
        username = self.view.value_txt_username.get()
        firstname = self.view.value_txt_firstname.get()
        lastname = self.view.value_txt_lastname.get()
        password = self.view.value_txt_password.get()
        email = self.view.value_txt_email.get()
        gender = self.view.isMale.get()

        user = user_dto.UserDto(username, firstname, lastname, password, email, gender)

        # call controller to save data into database
        self.insert(user)


    def validate(self):
        pass


    def insert(self, dto):
        self.model.insert(dto)


    def start(self):
        self.view.window.mainloop()