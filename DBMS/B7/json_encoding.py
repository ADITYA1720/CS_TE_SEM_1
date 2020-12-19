import json 
from json import JSONEncoder 

class Student: 
	def __init__(self, name, roll_no, address): 
		self.name = name 
		self.roll_no = roll_no 
		self.address = address 


class Address: 
	def __init__(self, city, street, pin): 
		self.city = city 
		self.street = street 
		self.pin = pin 

class EncodeStudent(JSONEncoder): 
		def default(self, o): 
			return o.__dict__ 
			
address = Address("221B", "Baker Street", "203-001") 
student = Student("Sherlock Holmes", 53, address) 

# Encoding custom object to json 
# using cls(class) argument of 
# dumps method 
student_JSON = json.dumps(student, indent = 4, 
						cls = EncodeStudent) 
print(student_JSON) 
print(type(student_JSON)) 

# Decoding 
student = json.loads(student_JSON) 
print() 
print(student) 
print(type(student)) 

