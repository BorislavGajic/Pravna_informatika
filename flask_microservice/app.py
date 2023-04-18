from flask import Flask
from flask_cors import CORS

from simpletransformers.ner import NERModel, NERArgs

model_args = NERArgs()
model_args.labels_list = ['B-LOC','B-MISC','B-ORG','B-PER','I-LOC','I-MISC','I-ORG','I-PER','O']
model = NERModel('electra', 'classla/bcms-bertic-ner', args=model_args, use_cuda=False)


app = Flask(__name__)
CORS(app)

@app.route('/get', methods=['GET'])
def get():
    with open('151_test.txt', 'r', encoding="utf8") as f:
        text = f.read()

    predictions, raw_outputs = model.predict([text])

    resultIORG = " ".join([list(i.keys())[0] for i in predictions[0] if list(i.values())[0] == "I-ORG"])
    # print(resultIORG)

    first_names = " ".join([list(i.keys())[0] for i in predictions[0] if list(i.values())[0] == "B-PER"])
    # print(first_names)

    last_names = " ".join([list(i.keys())[0] for i in predictions[0] if list(i.values())[0] == "I-PER"])
    # print(last_names)

    resultO = " ".join([list(i.keys())[0] for i in predictions[0] if list(i.values())[0] == "O"])

    first_names = first_names.split(" ")
    last_names = last_names.split(" ")
    # print(first_names)
    # print(last_names)


    full_names = [first_name + " " + last_name for first_name, last_name in zip(first_names, last_names)]

    print(full_names)

    return full_names

if __name__ == '__main__':
    app.run()