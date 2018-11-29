import os

def print_directory_contents(path):
    # create a list of file and sub directories 
    # names in the given directory 
    listOfFile = os.listdir(path)
    allFiles = list()
    # Iterate over all the entries
    for entry in listOfFile:
        # Create full path
        fullPath = os.path.join(path, entry)
        # If entry is a directory then get the list of files in this directory 
        if os.path.isdir(fullPath):
            allFiles = allFiles + print_directory_contents(fullPath)
        else:
            allFiles.append(fullPath)
                
    return allFiles
    

