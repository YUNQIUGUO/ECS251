import requests

def main():
        r=requests.post('http://ambiguity.typesofnote.com/finite', data={"samples":1000, "lower":0, "upper":10})
        print(r)


main()