import pytest
import requests
from pygments.lexers import data


@pytest.fixture(scope='module')
def base_url():
    return 'https://jsonplaceholder.typicode.com/'

@pytest.fixture(scope='module')
def session():
    session = requests.Session()
    session.headers.update({
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    })
    yield session
    session.close()

@pytest.fixture(scope='module')
def sample_post():
    return {
        'title': 'Sample Post',
        'body': 'Lorem ipsum dolor sit amet',
        'userId': 1
    }

class TestBasicRequest:

    def test_get_single_post(self, base_url, session):
        response = session.get(f'{base_url}/posts/1')
        assert response.status_code == 200
        response_data = response.json()
        assert response_data['id'] == 1
        assert 'title' in response_data

    @pytest.mark.parametrize('post_id', [1, 2, 3, 4, 5])
    def test_get_multiple_posts(self, base_url, session, post_id):
        response = session.get(f'{base_url}/posts/{post_id}')
        assert response.status_code == 200
        response_data = response.json()
        assert response_data['id'] == post_id
        assert 'title' in response_data

    @pytest.mark.parametrize('post_id', [999, -20, 135])
    def test_get_fake_post(self, base_url, session, post_id):
        response = session.get(f'{base_url}/posts/{post_id}')
        assert response.status_code == 404

    def test_create_post(self, base_url, session, sample_post):
        response = session.post(f'{base_url}/posts', json=sample_post)
        assert response.status_code == 201
        response_data = response.json()
        assert 'id' in response_data
        assert response_data['title'] == sample_post['title']
        assert response_data['body'] == sample_post['body']
        assert response_data['userId'] == sample_post['userId']

    @pytest.mark.parametrize("endpoint,expected_count", [
        ("/posts", 100),
        ("/users", 10),
        ("/comments", 500),
        ("/albums", 100),
        ("/photos", 5000),
        ("/todos", 200)
    ])
    def test_resource_counts(self, base_url, session, endpoint, expected_count):
        """Test that each endpoint returns expected number of items"""
        response = session.get(f"{base_url}{endpoint}")

        assert response.status_code == 200
        assert len(response.json()) == expected_count

# ==========================================================
# RESPONSE VALIDATION
# ==========================================================

class TestResponseValidation:
    """
    Comprehensive response validation patterns.
    """

    def test_response_time(self, base_url, session):
        """Test response time is acceptable"""
        response = session.get(f"{base_url}/posts/1")

        assert response.status_code == 200
        # Response time in seconds
        assert response.elapsed.total_seconds() < 2.0

    def test_response_headers(self, base_url, session):
        """Test response headers"""
        response = session.get(f"{base_url}/posts/1")

        assert "Content-Type" in response.headers
        assert "application/json" in response.headers["Content-Type"]

    def test_json_structure(self, base_url, session):
        """Test JSON response structure"""
        response = session.get(f"{base_url}/users/1")
        data = response.json()

        # Required fields exist
        required_fields = ["id", "name", "username", "email", "address", "phone", "website", "company"]
        for field in required_fields:
            assert field in data, f"Missing required field: {field}"

        # Nested structure
        assert "street" in data["address"]
        assert "city" in data["address"]
        assert "geo" in data["address"]
        assert "lat" in data["address"]["geo"]
        assert "lng" in data["address"]["geo"]

    def test_email_format(self, base_url, session):
        """Test email format validation"""
        response = session.get(f"{base_url}/users/1")
        email = response.json()["email"]

        assert "@" in email
        assert "." in email.split("@")[1]

    def test_all_posts_have_required_fields(self, base_url, session):
        """Test all posts have required fields"""
        response = session.get(f"{base_url}/posts")
        posts = response.json()

        for post in posts:
            assert "id" in post
            assert "userId" in post
            assert "title" in post
            assert "body" in post
            assert isinstance(post["id"], int)
            assert isinstance(post["userId"], int)