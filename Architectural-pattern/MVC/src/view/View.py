import tkinter as tk
from tkinter import ttk
import tkinter.messagebox as tkMessageBox
from dto import UserDto as user_dto


MALE = 1
FEMALE = 2

class View:
    def __init__(self, controller):
        # Main window
        self.window = tk.Tk()
        self.window.geometry("500x500")
        self.window.title("Registration Form")

        self.window.configure(bg = "#f4f1f1")

        self.message_box = tk.Frame(self.window)
        self.message_box.grid(row = 0, sticky = tk.W, padx = 10, pady = (5, 5))
        self.label_message = tk.Label(self.message_box, text = "You have registered successully!", bg = "#CAE0C4")
        self.label_message.pack(anchor = tk.SW)
        self.message_box.grid_remove()

        self.content = tk.Frame(self.window)
        self.content.grid(row = 1, padx = 30, pady = 30)

        # User name
        tk.Label(self.content, text = "User Name").grid(row = 1, column = 0, sticky = tk.W)

        self.value_txt_username = tk.StringVar()
        self.txt_username = tk.Entry(self.content, textvariable = self.value_txt_username)
        self.txt_username.grid(row = 1, column = 1, columnspan = 2)
        self.txt_username.focus()

        # First name
        tk.Label(self.content, text = "First name").grid(row = 2, column = 0, sticky = tk.W)

        self.value_txt_firstname = tk.StringVar()
        self.txt_firstname = tk.Entry(self.content, textvariable = self.value_txt_firstname)
        self.txt_firstname.grid(row = 2, column = 1, columnspan = 2)

        # Last name
        tk.Label(self.content, text = "Last name").grid(row = 3, column = 0, sticky = tk.W)

        self.value_txt_lastname = tk.StringVar()
        self.txt_lastname = tk.Entry(self.content, textvariable = self.value_txt_lastname)
        self.txt_lastname.grid(row = 3, column = 1, columnspan = 2)

        # Password
        tk.Label(self.content, text = "Password").grid(row = 4, column = 0, sticky = tk.W)

        self.value_txt_password = tk.StringVar()
        self.txt_password = tk.Entry(self.content, textvariable = self.value_txt_password)
        self.txt_password.grid(row = 4, column = 1, columnspan = 2)

        # Confirm password
        tk.Label(self.content, text = "Confirm password").grid(row = 5, column = 0, sticky = tk.W)

        self.value_txt_confirmpassword = tk.StringVar()
        self.txt_confirmpassword = tk.Entry(self.content, textvariable = self.value_txt_confirmpassword)
        self.txt_confirmpassword.grid(row = 5, column = 1, columnspan = 2)

        # Email 
        tk.Label(self.content, text = "Email").grid(row = 6, column = 0, sticky = tk.W)

        self.value_txt_email = tk.StringVar()
        self.txt_email = tk.Entry(self.content, textvariable = self.value_txt_email)
        self.txt_email.grid(row = 6, column = 1, columnspan = 2)

        # Gender
        tk.Label(self.content, text = "Gender").grid(row = 7, column = 0, sticky = tk.W)

        frame_radiobuttons = tk.Frame(self.content)
        frame_radiobuttons.grid(row = 7, column = 1, sticky = tk.W + tk.N + tk.S)
        
        self.isMale = tk.IntVar()
        radio_button_male = tk.Radiobutton(frame_radiobuttons, text = "Male", variable = self.isMale)
        radio_button_male.config(width = 2, value = MALE)
        radio_button_male.grid(row = 0, column = 1, padx = (20, 0), sticky = tk.W)

        radio_button_female = tk.Radiobutton(frame_radiobuttons,  text = "Female", variable = self.isMale)
        radio_button_female.config(width = 10, value = FEMALE)
        radio_button_female.grid(row = 0, column = 2, padx = (0, 0))

        # accept license
        self.isAccepted = tk.BooleanVar()
        check_btn_accept = tk.Checkbutton(self.content, text = "I accept Terms and Conditions")
        check_btn_accept.config(onvalue = True, offvalue = False, variable = self.isAccepted)
        check_btn_accept.grid(row = 8, column = 0, columnspan = 3, sticky = tk.W)

        # Register
        self.register_button = tk.Button(self.content, text = "Register", command = lambda: controller.register())
        self.register_button.grid(row = 9, column = 0, columnspan = 3, pady = 10)