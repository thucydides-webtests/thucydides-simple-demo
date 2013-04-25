Narrative:
In order to understand what I am reading about
As a reader
I want to be able to look up definitions of words

Meta:
@tags component:dictionary

Scenario: Looking up the definition of a simple word
Meta:
@tags iteration:sprint-1
Given the user does not know the meaning of the word 'apricot'
When the user looks up the definition of the word 'apricot'
Then they should obtain a definition containing the words 'A round sweet and juicy stone fruit'


Scenario: Looking up the definition of various words
Meta:
@tags iteration:sprint-1
Given the user does not know the meaning of the word '<word>'
When the user looks up the definition of the word '<word>'
Then they should obtain a definition containing the words '<definition>'

Examples:
| word              | definition                                |
| apple             | A common, round fruit                     |
| fig               | The fruit of the fig tree                 |
| pear              | An edible fruit produced by the pear tree |


Scenario: Looking up the definition of a word containing a spelling mistake
Given the user does not know the meaning of the word 'banana'
And the user does not know how to spell
When the user looks up the definition of the word 'bananna'
Then the application should say "did you mean 'banana'?"

Scenario: Lookup definitions in a file
Given the user wants to know the meaning of some words
Then he should be able to look them up