from flask import Flask

# Create an instance of the Flask class
app = Flask(__name__)

# Use the route() decorator to tell Flask what URL should trigger the function
@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"

@app.route("/hello")
def hello_again():
    return "<p>Hello, World!</p>"

@app.route("/hello/<name>")
def hello_name(name):
    return "<p>Hello, %s!</p>" % name

def hithere():
    return "<p>Hi there!</p>"

app.add_url_rule("/hi", "hi_there", hithere)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
