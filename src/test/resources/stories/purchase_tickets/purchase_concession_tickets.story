Narrative:
In order to increase ticket sales
As a rail service
I want travellers to be able to save time by booking online

Scenario: Purchasing a discounted ticket
Given a traveller wants to take a train from Dubbo to Sydney
And the traveller benefites from a <concession_type> reduction
When he books a ticket online
Then he should be charged <expected_price> instead <trip_base_cost>

Examples:
| trip_base_cost | concession_type | expected_price
| 25.00          | Pensioner	   | 20.00
| 25.00	         | Military	       | 20.00
| 25.00	         | Student	       | 17.50
| 25.00	         | Under 12	       | 12.50
| 25.00	         | Under 3	       | 0.00


