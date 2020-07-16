import urllib.request, urllib.parse, urllib.error, json

key = "2fe1436860563a2f485bb1a37b81f90d"
url = "http://api.openweathermap.org/data/2.5/weather?q=";
city = input("Enter the city name: ")
url = url + city + "&appid="+key;

content = urllib.request.urlopen(url).read().decode()

jsondata = json.loads(content)
print("Main: " , jsondata["weather"][0]["main"])
print("Description: " , jsondata["weather"][0]["description"])
