Details
Load Balancers

Analogous Terminology

Hardware that runs your code: server == machine == node == computer == instance == box

Collection of servers: fleet == pool == cluster

A quantity of user requests: traffic == requests == call volume == calls

Microservice: load balancer + fleet of nodes hosting the same code

Purpose

Systems need to increase their hardware capacity as they receive more requests. This can be achieved by vertical scaling (upgrading the hardware of a single computer similar to upgrading parts of your gaming computer) or horizontal scaling (increasing the number of servers running the same code and handling a subset of the total traffic).

Vertical scaling tends to be very cost-inefficient because it’s expensive to purchase the latest and greatest technology and it quickly becomes out-dated so the more cost-effective approach is use horizontal scaling to distribute work among multiple medium/low-tier servers. As a result, horizontal scaling is what every cloud provider, AWS, Azure, GCP, and OCI, offers as their most affordable hardware scaling solution because companies planning for ever-increasing magnitudes of traffic can utilize all of these concepts at the click of a few buttons and configurations.

If there are multiple servers hosting the same service, a load balancer (LB) is needed to delegate work equally so that no individual node is overburdened. LBs act as the interface to a cluster of nodes. An LB is often its own server whose sole purpose is to delegate the answering of requests to other servers and return the response so you would not deploy application code on them. As long as your service is agnostic about which server is selected to service a request, you can use this model. It's typically frowned upon to tightly couple the need for a user to always be directed to a particular server because this probably means you're storing state and have to build a configuration to keep track of that relationship mapping.

Explanation:

https://github.com/RickSayd/navigating-system-design/blob/master/basics/load-balancing.md

:::info
Load balancers aren't explicitly present in most diagrams and generally not mentioned in interviews because it's implied that you are familiar with the concept if you’re creating microservices. The same can be said for knowing the load balancer algorithms; good to know as trivia.
(Very Optional) Load balancing algorithms:

https://youtu.be/iqOTT7_7qXY
:::

:::info
Technically LBs are a single point of failure so a microservice often has multiple load balancers under 1 IP address. When a request goes through DNS lookup, it can evaluate to different load balancers.

Very Optional:

https://serverfault.com/questions/608471/is-awss-elastic-load-balancer-a-single-point-of-failure
