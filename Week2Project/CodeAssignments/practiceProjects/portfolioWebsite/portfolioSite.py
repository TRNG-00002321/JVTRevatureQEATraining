# Originally created: 11/11/2025
# Version: 1.0.0

from flask import Flask, render_template
import projectManager

# To create the initial json file for project data, refer to projectData.py
app = Flask(__name__)

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/projects/')
def projects():
    project_data_file = 'projects.json'
    data = projectManager.load_projects(project_data_file)
    return render_template('projects.html', headers=data[0].keys(), result=data)

@app.route('/contact/')
def contact():
    return render_template('contact.html')

if __name__ == "__main__":
    app.run(debug=True)