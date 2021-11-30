Broad Software Engineering Concepts

This section covers concepts that are valuable to know the existence of for software development and in general but will be unlikely for them to be a central part of a system design solution.

Skip any section that you already know.

1. Sleight of Hand

It’s all an illusion to make you think the system is low latency:

Rendering: Amazon's front page prioritizes loading the search bar first because most users want to be able to start looking for a product, then they load only the content viewable on your screen, and finally the remaining page that is beyond the height of your browser window

Culling in video games (Read enough to understand the GIFs):

https://www.gamesradar.com/the-secret-technical-tricks-going-on-behind-your-favourite-games/

2. Pareto Principle (80/20 Rule)

Supposedly prevalent in all parts of life and can be used to justify design decisions such as what contents to cache or things to consider for partitioning. 80% of X comes from 20% of Y.

https://en.wikipedia.org/wiki/Pareto_principle

Examples:

80% of traffic goes to the top 20% of resources

80% of users follow the top 20% of influencers

80% of reads are on the most recent 20% of records

80% of timelines are on the most recent 20% of posts

80% of searches are on the 20% most popular products

80% of trading volume are on the 20% largest stock tickers

3. MapReduce

This is the system design version of divide & conquer.

It's useful whenever you can break a problem into smaller versions of itself and parallelize the work. As the name implies, there is a mapping phase where you split up the work and a reduction phase where you merge the results together.

Problems in this space are typically long-running tasks on enormous sets of data that can be post-processed such as with a nightly job to aggregate an entire day's dataset at midnight for analytics, trend discovery, and historical data tracking.

Examples:

Word count (ignore the code): https://dzone.com/articles/word-count-hello-word-program-in-mapreduce

You want to see how much revenue your e-commerce website made in a day from 1 million orders, you could do it on a single computer and it could take hours or you could:

Split up the orders into 10000 for 100 computers (10,000 * 100 = 1,000,000)

On each of the 100 computers, sum those 10000 orders into 1 value (MAP)

Coalesce those 100 results together into 1 final answer (REDUCE)

4. Webhooks

Sometimes your system needs to communicate with an external system that you have no control over and they don't plan on changing their code to start calling one of your APIs.

This could be for a variety of reasons:

that external service is very stable and doesn't want to make any changes

that external service has countless other systems that it would need to integrate with

that external service doesn't have anyone staffed to make updates to their code

that external service doesn't want 2-way communication with other systems, it will send data to you but doesn't accept data from you

(top) that external service wants a generic, future-proof way of communicating to external systems

Instead, an external system can support casting out webhooks with any output you define (like a fishing rod), while your system can catch the webhook on an endpoint to receive input formatted in a predefined manner.

In this example, GitHub is the external system that lets you define webhooks and your Discord server is the system accepting incoming input at a webhook endpoint. GitHub sends data to the Discord webhook when code gets pushed and Discord parses the information and displays it:

https://youtu.be/rUaDIH5ZXB8

(Optional) This one has ThriveCart being the webhook invoker and Zapier's webhook tester is the catcher:

https://youtu.be/Rz_DSt-nSO8

5. Workflows

Workflows are like a pipeline of queues with conditionals that send your request down different paths depending on the result of each step. Instead of building the boilerplate code to do this routing logic and all of the basic functionalities like retries, auditing, and versioning, a framework already exists so you can focus on implementing the business logic. Workflows are a decision tree where each node is a queue with their own consumers that asynchronously process work in distributed, isolated steps. Similar to an assembly line, workflows break their processing into multiple segments of self-contained logic that processes the input and delivers the results to another step to do the same thing. The extra layer that workflows offer over a pipeline of queues in series is branching logic:

Definitions

Step: A workflow module with arbitrary code to execute.

Work/Task: an input for a step to process.

Worker/Actor: A server that has the step’s or steps’ code installed and can process work intended for that step. There can be multiple workers per step or multiple steps per worker (many-to-many).

A series of queues (consumers/producers not shown):

Input → QueueA → QueueB → QueueC → QueueD → QueueE → Complete

Workflow

………………………………if (X) → StepC →→→→→

Work → StepA → StepB --|……………………………StepF → Complete

………………………………else → StepD → StepE →

There tends to be long delays in-between steps and helps you see the "progress bar" of your long running action.

Examples:

Ordering & Fulfillment - orders can transition to many different statuses (canceled, fulfilled, shipped, delivered) but spends most of the time waiting for external, physical actions in the warehouse (picking, packing, labeling) to trigger the next step.

Returns & Refunds - same thing as above, don't start refunding until the package is scanned by a shipping company, don't consider the item as restocked until is scanned at the warehouse.

Real Estate Transactions - involves approvals from multiple parties, emailing papers out, waiting for buyers to sign papers, and the next step depend greatly on the outcome of the current step (loan approval/proof of assets/auditing decisions).

E-Book Publishing - involves multiple critiques by the publisher and multiple revision edits by an author (repeating steps)

Tax filing software - so. many. conditionals. TurboTax has to decide whether you need to fill out a form or not depending on your response to their questions and/or if you meet a certain criteria or threshold.

When to use workflows (only the first answer):

https://softwareengineering.stackexchange.com/questions/103972/when-to-use-workflow-engines/103983

Detailed explanation:

https://youtu.be/dFD7CEM1vbc

Queues vs Workflows:

https://medium.com/awesome-cloud/aws-difference-between-sqs-and-swf-7a0954999621

(Optional, skim) Check out some of the use-cases:

https://aws.amazon.com/swf/

6. Retries & Jitter

Similar to how your laptop can have network connectivity issues that need you to refresh the page or retry sending a message, servers regularly encounter networking problems when communicating with each other and need to have a way to automatically retry (unless you like waking up in the middle of the night to click buttons). Sometimes this can be due to another microservice being down or overwhelmed with requests and can’t take on more traffic. Often times retries solve a lot of problems without any human intervention and can be implemented using a do-while-not-successful loop.

There are problems with a piling up of too many attempts through set-interval retries like “while not successful; try calling every 5 seconds”, suddenly your depdendency has 100x the number of requests waiting to be answered the moment it becomes available and that can lead to your dependency being brought down by YOU! So here are 2 industry standard solutions:

Exponential Backoff (powers of 2): If at first you don’t succeed, be gradually more patient. We’re all a team here. Make the first retry after waiting 1 second, second retry after waiting 2 seconds, then 4s, then 8s, 16s, 32s, up to a maximum of 60s.

Random Jitter: If everyone retries at the same exact time, it doesn’t matter if there’s exponential retry, it’s like getting hit occasionally with a wall instead of a trickle. If N = the current exponential backoff timer, then the next retry should be in random(0,N) seconds so requests are as evenly distributed across time through probability.

(Optional, I’d only look at the graphs and code snippets) AWS :

https://aws.amazon.com/blogs/architecture/exponential-backoff-and-jitter/

7. Batching

This is chunking work to save on time waiting for network hops or per-request inefficiencies such as deserializing or getting a connection.

Read Modern systems, Batch window, Batch size, and Common batch processing usage:

https://en.wikipedia.org/wiki/Batch_processing#Modern_systems

In practice, batching can introduce some complexity for your application because you have to accumulate messages before sending them, or you have to wait longer for a response. However, batching can be still effective in the following cases:

Your application generates many messages in a short time, so the delay is never very long.

A message consumer fetches messages from a queue at its discretion, unlike typical message producers that need to send messages in response to events they don't control.

8. Rate Limiting / Throttling

When you know you or your dependencies the maximum amount of traffic you can handle gracefully, you can employ throttling. You definitely do not want to start a design discussion by considering how to reduce the throughput of your system so keep this far in the back of your mind.

How does this help? It can prevent Denial of Service (DDoS/DoS) attacks or stop a system from getting overwhelmed with more requests than it was meant to handle. Instead of letting everyone in and everyone has a bad experience, you let fewer people through the door but those that do get in will have a good experience. The trade-off is capping the quantity of requests for quality (low latency) for the requests that do get through.

This can be achieved by setting limitations on the maximum number of requests that can be handled at any given time. The limit could be based on any dimension; per user, per IP Address, per unit-of-time, based on hardware/custom metrics, or anything under the sun.

Implementing throttling with a Token Bucket or Leaky Bucket Algorithm (FYI only): https://youtu.be/bL0I54Vac9Q

Another alternative is, instead of a request calling an API directly, having an intermediate request queue (same queues we learned about previously) that allows for a backlog of requests to build up while your service processes them as fast as possible. This can give your system some leeway to horizontally scale up to catch up with a sudden, unexpected influx of calls. Most load balancers internally implement a queue that they try to keep empty as much as possible but accounts for small build-ups of requests.

3. Containers

Microservices using entire physical machines or even virtual machines (VMs) are the way of the dinosaur. Physical machines take the longest to reboot and it’s expensive to buy multiple weak computers. Virtual machines have to have an operating system and take some time to reboot.

Containers are the new lightweight option for deploying only the dependencies needed to run your code in a closed environment (sandbox) and nothing extraneous. Docker is a popular containerizing framework coupled with Kubernetes for managing container fleets and is currently the smallest unit of computing power in the cloud.

Why? This is all in pursuit of reducing the blast radius of bad code or an overwhelming traffic flow from disrupting an entire service or piece of hardware.

What are containers:

https://youtu.be/_dfLOzuIg2o?t=18

On a single physical machine there can be as many services and containers as the hardware can handle. The most typical use of containers is to put 1 service per container with N containers per virtual machine with N virtual machines per physical machine.

Each layer can have multiple instances of the inner layer. There’s probably even more layers.

( DomainName ( DataCenter ( LoadBalancer ( PhysicalMachine ( VirtualMachine ( Container ( YourCode ) ) ) ) ) ) )

9. Telemetry - Business Metrics, Operational Metrics

Senior software engineers should understand these metric “dimensions” very well as they become ingrained in your operational skillset.

P90 latency

P99 latency

Success/Error rates

Traffic volume (Requests/sec)

Alarming

10. Miscellaneous

For general software developers, you aren’t expected to know these without on-the-job training. They’re useful concepts to know as an engineer but unlikely to be ever discussed in an interview:

Primitive SEO techniques

Machine Learning

Artificial Intelligence

Image Processing

Neural Networks

Facial Recognition

Computer Vision

Data Science
