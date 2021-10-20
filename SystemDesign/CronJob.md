Schedulers

Schedulers help you plan execution to happen at fixed point(s) in time. For simplicity, we will look at Cron jobs as the standard for job schedulers and while it’s technically a Linux technology, it can be easily turned into a script running on a microservice.
Cron is a command line tool for running arbitrary scripts at periodic time interval(s):
https://youtu.be/CIVI-DIzCFk?t=5
A Cron expression is a structured regular expression of 5-6 parameters for defining times to execute. Whenever you use star(*) or a complex expression you’re indicating that it should be ran any time the current timestamp matches that regex. When you use a literal integer value, that indicates to only run when that timeunit is an exact match. If you provide literal values for every argument then you are scheduling something to happen exactly once.
Play around with your own cron expressions or hit the "random" button:
https://crontab.guru/


Use-Cases

Nightly backups

Hourly log compression

Daily analytics processing

Planning around holidays and large events

Anything that repeats on any timescale
