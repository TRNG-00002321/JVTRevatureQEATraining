import requests

def test_basics():
    response = requests.get('https://jsonplaceholder.typicode.com/users/1')
    print(response.status_code)
    print(response.json())
    print(response.text)

    assert response.status_code == 200

def test_parameters():
    # https://jsonplaceholder.typicode.com/comments?postId=1
    params = {
        "postId": 1
    }
    try:
        response = requests.get('https://jsonplaceholder.typicode.com/comments', params=params)
        response.raise_for_status()
        print(f' Success: {response.json()}')
        assert response.status_code == 200
    except requests.exceptions.HTTPError as e:
        print(f' HTTP Error: {e}')

def test_post_basic():
    post_data = {
        "userId": 1,
        "title": "Python API Testing Post Basic 01",
        "body": "Test Body and some text going here"
    }
    try:
        response = requests.post('https://jsonplaceholder.typicode.com/posts', json=post_data)
        response.raise_for_status()
        print(f' Success: {response.json()}')
        assert response.status_code == 201
    except requests.exceptions.HTTPError as e:
        print(f' HTTP Error: {e}')

def test_get_post_not_found():
    response = requests.get('https://jsonplaceholder.typicode.com/posts/999')
    assert response.status_code == 404