from flask import Flask, render_template, request, redirect, url_for, jsonify
import toDoListManager

app = Flask(__name__)
to_do_list_file = "toDoList.json"

@app.route('/')
def home():
    task_list = toDoListManager.get_task_list(to_do_list_file)
    return render_template('home.html', tasks=task_list)

@app.route('/redirect_handler', methods=['POST'])
def redirect_handler():
    if 'Add task' in request.form:
        return redirect(url_for('create_task'))
    elif 'Delete task' in request.form:
        return redirect(url_for('delete_task'))
    elif 'Update task' in request.form:
        return redirect(url_for('update_task'))
    else:
        return "No button pressed or unknown action."

@app.route('/create', methods=['GET', 'POST'])
def create_task():
    if request.method == 'GET':
        return render_template('createTask.html')
    else:
        description = request.form['description'].capitalize()
        completed = True if request.form.get('isComplete') == "on" else False
        task_list = toDoListManager.get_task_list(to_do_list_file)
        toDoListManager.add_task(task_list, description, completed)
        toDoListManager.save_task_list(to_do_list_file, task_list)
        return redirect(url_for('home'))

@app.route('/delete', methods=['GET', 'POST'])
def delete_task():
    if request.method == 'GET':
        return render_template('deleteTask.html')
    else:
        description = request.form['description'].capitalize()
        task_list = toDoListManager.get_task_list(to_do_list_file)
        removed_count = toDoListManager.delete_task(task_list, description)
        toDoListManager.save_task_list(to_do_list_file, task_list)
        return redirect(url_for('home'))

@app.route('/update', methods=['GET', 'POST'])
def update_task():
    if request.method == 'GET':
        return render_template('updateTask.html')
    else:
        description = request.form['description'].capitalize()
        task_list = toDoListManager.get_task_list(to_do_list_file)
        toDoListManager.mark_task(task_list, description)
        toDoListManager.save_task_list(to_do_list_file, task_list)
        return redirect(url_for('home'))

if __name__ == "__main__":
    app.run(debug=True)