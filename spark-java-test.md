## HTTPie
$ http GET http://localhost:4567/hello

$ http --verbose  GET http://localhost:4567/hello

$ http -v :4567/hello

GET /hello HTTP/1.1
Accept: */*
Accept-Encoding: gzip, deflate
Connection: keep-alive
Host: localhost:4567
User-Agent: HTTPie/0.9.2



HTTP/1.1 200 OK
Content-Type: text/html;charset=utf-8
Date: Fri, 20 Jan 2017 12:44:58 GMT
Server: Jetty(9.3.6.v20151106)
Transfer-Encoding: chunked

Hello World


---
http -v :4567/hello/max

GET /hello/max HTTP/1.1
Accept: */*
Accept-Encoding: gzip, deflate
Connection: keep-alive
Host: localhost:4567
User-Agent: HTTPie/0.9.2



HTTP/1.1 200 OK
Content-Type: text/html;charset=utf-8
Date: Fri, 20 Jan 2017 12:49:47 GMT
Server: Jetty(9.3.6.v20151106)
Transfer-Encoding: chunked

Hello: max

---

http -v :4567/hello/max job=sqli