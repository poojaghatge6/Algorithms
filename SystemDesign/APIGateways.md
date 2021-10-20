Details

API Gateways

API gateways serve a similar role to Load Balancers in distributed systems by routing traffic. However instead of directing requests to different servers with the same code, it is routing requests to the correct service based on a regular expression match of the APIs. You can think of the API gateway as a hashmap where:
key=APIs or API regex

value=microservice HTTP endpoint

They also do authorization, authentication, and other boring validation stuff that allow you to omit having to make a separate microservice(s) for that in every system you propose.
Example Sequence

A user sends a request through a desktop/mobile/command-line client

Your system receives the request via a web server

The web server passes it to an API gateway

The API gateway parses the URL path or signature name and looks up who’s responsible for answering requests of this format

The API gateway delegates the request to the responsible load balancer(s) IP address / microservice endpoint

The response bubbles back out in the opposite direction

Explanation:

https://youtu.be/vHQqQBYJtLI
