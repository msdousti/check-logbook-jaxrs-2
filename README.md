# check-logbook-jaxrs-2

Sample project to show that Logbook JAX-RS module supports JAX-RS 2.X and Java 8.

# How to run

This project was created to test the [Logbook PR #1674](https://github.com/zalando/logbook/pull/1674).
You need to check out that branch, and build and install it locally:

```bash 
git clone --branch support-jaxrs-2-via-shading git@github.com:zalando/logbook.git

cd logbook

mvn install -DskipTests -Ddependency-check.skip=true -Djacoco.skip=true
```

This will install Logbook `3.7.0-SNAPSHOT` in the `~/.m2` directory.

You can then execute this sample project:

```bash
mvn compile exec:java -Dexec.mainClass="io.msdousti.Main"
```

Logbook must log the request and response to the console - here's an example:

**Request:**

```
[io.msdousti.Main.main()] TRACE org.zalando.logbook.Logbook - Outgoing Request: bc45f8d7969a3f7f
Remote: localhost
GET http://httpbin.org/get HTTP/1.1
Accept: application/json
```

**Response:**
```
[io.msdousti.Main.main()] TRACE org.zalando.logbook.Logbook - Incoming Response: bc45f8d7969a3f7f
Duration: 323 ms
HTTP/1.1 200 OK
Access-Control-Allow-Credentials: true
Access-Control-Allow-Origin: *
Connection: keep-alive
Content-Length: 294
Content-Type: application/json
Date: Tue, 14 Nov 2023 00:13:15 GMT
Server: gunicorn/19.9.0

{
  "args": {},
  "headers": {
    "Accept": "application/json",
    "Host": "httpbin.org",
    "User-Agent": "Jersey/2.41 (HttpUrlConnection 17.0.7)",
    "X-Amzn-Trace-Id": "Root=1-6552bb9b-3681172f65719554436cee8b"
  },
  "origin": "AAA.BBB.CCC.DDD",
  "url": "http://httpbin.org/get"
}
```
