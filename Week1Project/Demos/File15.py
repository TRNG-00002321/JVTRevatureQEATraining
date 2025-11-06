# Writing Binary Files:
# Use "wb" mode to write binary data
# (e.g., images, encoded content)

data = bytes([120, 3, 255, 0, 100])

with open("binaryfile.dat", "wb") as f:
    f.write(data)