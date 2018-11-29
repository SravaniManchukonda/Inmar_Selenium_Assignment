#*args in function definitions in python is used to pass a variable number of arguments to a function.
# It is used to pass a non-keyworded, variable-length argument list.
def argvdemo1(*argv):  
    for arg in argv:  
        print (arg)


#*args function to show with extra parameter
def argvdemo2(arg1, *argv): 
    print ("First argument :", arg1) 
    for arg in argv: 
        print("Next argument through *argv :", arg)
    print(arg1)

    
#**kwargs in function definitions in python is used to pass a keyworded, variable-length argument list
#A keyword argument is where you provide a name to the variable as you pass it into the function.
#One can think of the kwargs as being a dictionary that maps each keyword to the value that we pass alongside it
#functionfor kwargs
def kwargsdemo(**kwargs):  
    for key, value in kwargs.items(): 
        print ("%s == %s" %(key, value))



argvdemo1('argv function demo\n','*argv is used to pass a variable number of argumentsto a function', ' It is used to pass a non-keyworded, variable-length argument list', 'For example : we want to make a multiply function that takes any number of arguments and able to multiply them all together. It can be done using *args.')

argvdemo2('\nargv function with extra demo demo\n','This is toshow *args with first extra argument','arg1','arg2')

kwargsdemo(first ='*args', mid ='**kwargs', last='Demo')
