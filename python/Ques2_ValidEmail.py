import re

#Taking input for user for email id
email = input("Enter email id")

#checking with Regex
regex = r"^[A-Za-z0-9\.\+_-]+@[A-Za-z0-9\._-]+\.[a-zA-Z]*$"
if re.match(regex,email):
    print(email+" is valid email id")
else:
    print(email+" is invalid email id")
