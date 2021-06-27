import requests
import json

parameters = {
    "marka": "ferrari",
    "kolor": "zielony",
    "rocznik": "1999",
    "powypadkowy":True

}


parameters2 = {
    "marka": "ferrari",
    "kolor": "fioletowy",
    "rocznik": "2000",
    "powypadkowy":False

}




response = requests.post("http://172.30.224.1:8098/buckets/s23688/keys/ferrari", parameters)



response = requests.get("http://172.30.224.1:8098/buckets/s23688/keys/ferrari")

print(response.text)


response = requests.put("http://172.30.224.1:8098/buckets/s23688/keys/ferrari",parameters2)


response = requests.get("http://172.30.224.1:8098/buckets/s23688/keys/ferrari")

print(response.text)



response = requests.delete("http://172.30.224.1:8098/buckets/s23688/keys/ferrari")





response = requests.get("http://172.30.224.1:8098/buckets/s23688/keys/ferrari")

print(response.text)




