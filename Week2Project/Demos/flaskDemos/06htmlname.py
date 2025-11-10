from flask import Flask, render_template

app = Flask(__name__)

@app.route('/hello/<name>')
def hello_world(name):
    return render_template('helloname.html', name=name)

@app.route('/hello/<int:score>')
def hello_marks(score):
    return render_template("helloscore.html", marks=score)

# Create marks on physics, chemistry, and maths. Assign the marks according to your choice.
# Display them in a tabular form with a table heading. Do this using a Python Dictionary.
@app.route('/index')
def marks_table():
    marks = [
        {"name": "Alice", "physics": 45, "chemistry": 75, "maths": 80},
        {"name": "John", "physics": 85, "chemistry": 95, "maths": 90},
        {"name": "Smith", "physics": 75, "chemistry": 65, "maths": 83},
        {"name": "Barry", "physics": 55, "chemistry": 72, "maths": 85},
        {"name": "Mary", "physics": 100, "chemistry": 39, "maths": 70}
    ]
    return render_template("markstable.html", scores=marks)

if __name__ == '__main__':
    app.run(debug=True)