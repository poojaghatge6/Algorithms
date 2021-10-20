Idempotency

If your system thinks an online purchase failed but the payment processor got your request and you retry, it shouldn’t charge the customer twice. The solution to this is to ensure each request is idempotent.

Explanation:

https://stripe.com/blog/idempotency

User makes a checkout request

Your system calls Stripe API, Stripe returns error or network timeout

Your system calls Stripe API again with same payload including the idempotency key

The request is processed

Your system accidentally replays traffic or intentionally does it for testing and backwards compatibility

Stripe API returns 202, successfully did nothing.
