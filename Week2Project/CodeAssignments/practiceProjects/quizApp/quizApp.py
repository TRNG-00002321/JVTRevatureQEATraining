# Originally created: 11/11/2025
# Version: 1.0.0

import json

questions_file = 'questions.json'
answers_file = 'answers.json'

def set_quiz_data():
    print("Setting quiz data...")
    question_list = [
        {"id": 1, "description": "1 + 1 = ?"},
        {"id": 2, "description": "True/False?: Humans need food and water to live."},
        {"id": 3, "description": "What color is an orange?"},
        {"id": 4, "description": "Which language should you use for today's coding challenge?"},
        {"id": 5, "description": "What is the dress code on Mondays?"},
        {"id": 6, "description": "What is the dress code on Tuesdays through Fridays?"},
        {"id": 7, "description": "5.0 / 2.0 = ?"},
        {"id": 8, "description": "5 ** 2 = ?"},
        {"id": 9, "description": "5 ** 3 = ?"},
        {"id": 10, "description": "True/False?: If you get a phone call from your boss, you must do whatever they tell you to do."}
    ]
    answers_list = [
        {"id": 1, "answer": "2"},
        {"id": 2, "answer": "True"},
        {"id": 3, "answer": "Orange"},
        {"id": 4, "answer": "Python"},
        {"id": 5, "answer": "Business professional"},
        {"id": 6, "answer": "Business casual"},
        {"id": 7, "answer": "2.5"},
        {"id": 8, "answer": "25"},
        {"id": 9, "answer": "125"},
        {"id": 10, "answer": "False"},
    ]
    print("Writing questions and answers to files...")
    try:
        with open(questions_file, 'w') as f:
            json.dump(question_list, f, indent=4)
        with open(answers_file, 'w') as f:
            json.dump(answers_list, f, indent=4)
    except json.JSONDecodeError as e:
        print(f"JSON Decode Error for invalid string: {e}")

    print("Quiz data set!")
    return question_list, answers_list

def get_quiz_data():
    print("Getting quiz data...")
    try:
        with open(questions_file, 'r') as f:
            question_list = json.load(f)
        with open(answers_file, 'r') as f:
            answer_list = json.load(f)
    except FileNotFoundError:
        print("File(s) not found. Generating quiz from scratch...")
        question_list, answer_list = set_quiz_data()
    except json.JSONDecodeError as e:
        print(f"JSON Decode Error for invalid string: {e}")
        print("Generating quiz from scratch...")
        question_list, answer_list = set_quiz_data()

    print("Quiz data loaded!")
    return question_list, answer_list

if __name__ == '__main__':
    questions, answers = get_quiz_data()
    score = 100
    num_wrong = 0
    print()

    for question in questions:
        current_answer = answers[question['id'] - 1].get('answer')
        print(f"{question['id']}. {question['description']}")
        response = input("Enter answer: ").strip().capitalize()
        if response not in current_answer:
            score -= 100 / len(questions)
            num_wrong += 1

    print(f"\nFinal score: {score}% (missed {num_wrong} out of {len(questions)})")