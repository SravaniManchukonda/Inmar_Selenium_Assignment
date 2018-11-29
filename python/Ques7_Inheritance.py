class InputValues:
    def __init__(self, no_of_inputs):
        self.n = no_of_inputs
        self.inputs = [float(input("Enter parameter "+str(i+1)+" : ")) for i in range(self.n)]

    def enteredValues(self):
        for i in range(self.n):
            print("Parameter",i+1,"is",self.inputs[i])

class Math(InputValues):
    def __init__(self):
        InputValues.__init__(self,2)

    def add(self):
        a, b = self.inputs
        # calculate the semi-perimeter
        s = a + b
        
        print('The sum of the numbers %0.2f' %s)

    def sub(self):
        a, b = self.inputs
        # calculate the semi-perimeter
        s = a - b
        
        print('The difference of the numbers %0.2f' %s)

    def mult(self):
        a, b = self.inputs
        # calculate the semi-perimeter
        s = a * b
        
        print('The multiplication of the numbers %0.2f' %s)


    def div(self):
        a, b = self.inputs
        # calculate the semi-perimeter
        s = a / b
        
        print('The multiplication of the numbers %0.2f' %s)


m = Math()
m.enteredValues()
m.add()
m.sub()
m.mult()
m.div()
