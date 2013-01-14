Narrative:
In order to understand what I am reading about
As a reader
I want to be able to look up definitions of words

Scenario: Looking up the definition of a simple word
Given the user does not know the meaning of the word 'banana'
When the user looks up the definition of the word 'banana'
Then they should obtain a definition containing the words 'An elongated curved fruit'


Scenario: Looking up the definition of various words
Given the user does not know the meaning of the word '<word>'
When the user looks up the definition of the word '<word>'
Then they should obtain a definition containing the words '<definition>'

Examples:
| word              | definition                                |
| apple             | A common, round fruit                     |
| banana            | An elongated curved fruit                 |
| pear              | An edible fruit produced by the pear tree |
| pears             | Plural form of pear                       |


Scenario: Looking up the definition of a word containing a spelling mistake
Given the user does not know the meaning of the word 'banana'
And the user does not know how to spell
When the user looks up the definition of the word 'bananna'
Then the application should say "did you mean 'banana'?"

