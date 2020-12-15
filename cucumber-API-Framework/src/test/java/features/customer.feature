Feature: Testing the API's
/*Scenario: Get Subscribed customer details
Given I create a new request with http://apiops1-anypoint-bdd-sapi.us-e2.cloudhub.io/api/ service
And I add the users/registerUser/subscription endpoint to the service
And I send the GET request to the service
Then I get the 200 response code

Scenario: Register Customer
Given I create a new request with http://apiops1-anypoint-bdd-sapi.us-e2.cloudhub.io/api/ service
And I add the users/registerUser endpoint to the service
And  I pass application/json as content type
And I send the values of src/test/resources/cucumberResources/registerCustomerInput.json in the request body
And I send the POST request to the service
Then I get the 201 response code
Then I expect the values of src/test/resources/cucumberResources/registerCustomerOutput.json in the response body

Scenario: Test the scheduler part
Given I create a new request with http://apiops-anypoint-bdd-papi.us-e2.cloudhub.io/ service
And I add the synchronize endpoint to the service
And I send the GET request to the service
Then I get the 200 response code */

Scenario: Get Salesforce Accounts
Given I create a new request with http://acme-salesforce-accounts-api.us-e2.cloudhub.io/api/ service
And I add the accounts endpoint to the service
And with the following headers
| authorization | Bearer eyJraWQiOiItSldKZUhlZVFzWlhSLXRUZHVpeXZLNGRsS3BxWXRKMmR1WmlVdnVRdnd3IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULjVkR3VUY21MMkNYaGpJbklkZDU3UWJRaTdXZmtaN2U5dnJ5MnhveDF6TDQiLCJpc3MiOiJodHRwczovL2Rldi02MjMwODIub2t0YS5jb20vb2F1dGgyL2RlZmF1bHQiLCJhdWQiOiJhcGk6Ly9kZWZhdWx0IiwiaWF0IjoxNjA4MDE3NDU2LCJleHAiOjE2MDgxMDM4NTYsImNpZCI6IjBvYTFsM2VmdmY3VTBwQjUzNHg3Iiwic2NwIjpbIm11bGVzY29wZSJdLCJzdWIiOiIwb2ExbDNlZnZmN1UwcEI1MzR4NyJ9.KaIyEB2MsmYL5jH-McQYkuQYfkpEhUN9p2Owq6ktnAnwl--FpotMV0_k6u_9BV6TakZ1RRRPBs52B3hfpqiM74qi5I88pdAyPB0zaF_Laq9UIoJZ2u8fygv0ZM62hXJeYHxT2A8trryYr4yhdeNDDbVn3irt9WEtcuDMwrDMUZ3tdYB8y2zC1-Mm9slnz0jK8a1ZpYYccM_GgScHOTwEg4Frl5MwRq-0R5zr45WOAKfiK2k_7lpDtOL3uB4Qy5okaIZomv9hAV_TvI2oDhob6JArMaPtJkLr-c3k0M2bbOyHL7ZwCRs4LSY91CKqalC-CuA96jfFYad7s3gwFllieQ |
And I send the GET request to the service
Then I get the 200 response code

