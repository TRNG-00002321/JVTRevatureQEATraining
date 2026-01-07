# This is a basic Python Dockerfile

# Start creating an image based on the official Python 3.9 slim image
# From is the instruction that sets the base image for subsequent instructions in the Dockerfile
# FROM is the first instruction in a Dockerfile
FROM python:3.9-slim

# Set the working directory in the container to /app
WORKDIR /app

# Copy the requirements.txt file from the host machine to the working directory in the container
COPY requirements.txt .

# Install the dependencies listed in requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

# Copy the rest of the application code from the host machine to the working directory in the container
COPY . .

# Expose port 5000 for the application (we use this port b/c Flask, by default, typically runs on this port)
EXPOSE 5000

# Run the application using the command below when the container starts
CMD ["python", "src/app.py"]