Narrative:
In order to understand what I am reading about
As a reader
I want to be able to look up definitions of words

Scenario: Looking up the definition of a word
Given the user does not know the meaning of the word 'banana'
When the user looks up the definition of the word 'banana'
Then they should obtain a definition containing the words 'An elongated curved fruit'

Scenario: Looking up the definition of a word
Given the user does not know the meaning of the word '<word>'
When the user looks up the definition of the word '<word>'
Then they should obtain a definition containing the words '<definition>'

Examples:
| word              | definition                                |
| apple             | A common, round fruit                     |
| banana            | An elongated curved fruit                 |
| pear              | An edible fruit produced by the pear tree |