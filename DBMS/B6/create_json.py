# Python program showing 
# use of json package 

import json 

# {key:value mapping} 
a ={"name":"Aditya", 
	   "age":20, 
	   "Salary":95000} 

# conversion to JSON done by dumps() function 
b = json.dumps(a) 

# printing the output 
print(b) 

