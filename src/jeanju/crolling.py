import requests
from bs4 import BeautifulSoup
from tqdm import tqdm

def getname():
  URL = "http://openapi.seoul.go.kr:8088/526f63546c646f6433307779504158/xml/SearchSTNBySubwayLineService/"

  for i in range(0,10):
    if i == 2  or i == 4 :

      #fp = open(str(i)+".txt","w")
      r_n = requests.get(URL+"/1/5/"+str(i))
      b_n = BeautifulSoup(r_n.text)

      n = b_n.list_total_count.string
      #fp.write(str(n)+"\n")
      n = int(int(str(n))/5)
      n = n+1
      
      for j in range(0,n):
        r_n = requests.get(URL+str(j*5+1)+"/"+str((j+1)*5)+"/"+str(i))
        b_n = BeautifulSoup(r_n.text)
        for k in b_n.find_all("row") :
          #fp.write(k.station_nm.text+"\n")
          #fp.write(k.station_cd.text+"\n")
          #getinfo(str(k.station_nm.text),str(k.station_cd.text),str(i))
          gettime(str(k.station_nm.text),str(k.station_cd.text),1,str(i))
          gettime(str(k.station_nm.text),str(k.station_cd.text),2,str(i))


      #fp.close()

def getinfo(name,code,line):
  URL = "http://openapi.seoul.go.kr:8088/526f63546c646f6433307779504158/xml/SearchSTNInfoByIDService/1/5/"+code

  print(name+"info"+line+".txt")
  fp = open(name+"info"+line+".txt","w")
  r_info = requests.get(URL)
  b_info = BeautifulSoup(r_info.text)
  #line번호 추가

  fp.write(name+"\n")
  fp.write(code+"\n")
  fp.write(b_info.line_num.text+"\n")
  fp.write(b_info.tel.text+"\n")
  fp.write(b_info.address.text+"\n")

  fp.close()

##info텍스트 없이 한 text파일에 info까지 합침
##info파일이 필요하다면 주석풀면 됨.

def gettime(name,code,direc,line):
  URL = "http://openapi.seoul.go.kr:8088/526f63546c646f6433307779504158/xml/SearchSTNTimeTableByIDService/"

  if direc == 1:
    #fp1 = open(name+line+"up.txt","w")
    #fp2 = open(name+line+"up_w.txt","w")
    fp3 = open(name+line+"up_red.txt","w")
    weekdays = code+"/1/1"
    satur = code+"/2/1"
    holiday = code+"/3/1"
  else:
    #fp1 = open(name+line+"down.txt","w")
    #fp2 = open(name+line+"down_w.txt","w")
    fp3 = open(name+line+"down_red.txt","w")
    weekdays = code+"/1/2"
    satur = code+"/2/2"
    holiday = code+"/3/1"
  ##일단 평일만 해두었음!
  ##weekdays - 평일
  ##satur - 토요일
  ##holiday - 공휴일

  for i in range(2,3):
    if i == 0:
      additional = weekdays
      print(name+line+"up.txt")
      fp = fp1
    elif i == 1:
      additional = satur
      print(name+line+"up_w.txt")
      fp = fp2
    elif i == 2:
      additional = holiday
      print(name+line+"up_red.txt")
      fp = fp3

    r_time = requests.get(URL+"1/5/"+additional)
    b_time = BeautifulSoup(r_time.text)
    #print(b_time)
  
    n = b_time.list_total_count.string
    fp.write(n+"\n")
    n = int(int(str(n))/5)
    n = n+1

    for j in range(0,n):
      print(URL+str(j*5+1)+"/"+str((j+1)*5)+"/"+additional)
      r_time = requests.get(URL+str(j*5+1)+"/"+str((j+1)*5)+"/"+additional)

      b_time_time = BeautifulSoup(r_time.text)
      for k in b_time.find_all("row") :
        fp.write(k.train_no.text+"\n")
        fp.write(k.arrivetime.text+"\n")
        fp.write(k.lefttime.text+"\n")
  
  #fp1.close()
  #fp2.close()
  fp3.close()

getname()
