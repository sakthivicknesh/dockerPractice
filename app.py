from flask import Flask

app = Flask(__name__)

@app.route("/")
def hello():
    return "Hello from your Dockerized Python Application!"

if __name__ == "__main__":
    # Setting host='0.0.0.0' is crucial for Docker so the app listens on all network interfaces
    app.run(host='0.0.0.0', port=5000)
