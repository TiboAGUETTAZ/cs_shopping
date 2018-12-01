Feature: My Simple Shopping Basket
    As a customer of csFruits.ch
    I want to be able to add a selection of fruits to my basket, and have the total cost of my basket available at all time
    So that I can get my daily vitamins while enjoying great offers from csFruits.ch

    Background: Given csFruits.ch has been released and is available to the public
        And "Apple"-s are priced 35 pence each
        And "Banana"-s are priced 20 pence each
        And "Melon"-s are priced 50 pence each
        And "Limes"-s are priced 15 pence each

    Scenario: Adding a first fruit into the basket
        Given My basket is empty
        And the initial cost of my basket is 0 p
        When I add a <fruit> in my basket
        Then <resulting total cost> of my basket should be the <resulting cost> (in pence)

        Examples:
            |   fruit  | resulting cost |
            |  "Apple" |       35       |
            | "Banana" |       20       |
            |  "Melon" |       50       |
            |  "Lime"  |       15       |

    Scenario: Adding an other fruit into the basket and having relevant offers applied
        Given a <initial list of fruits> in my basket
        And the considering the <initial cost> of my basket
        And there is a "buy one get one free" offer on "Melon"-s
        And there is a "Three for the price of Two" offer on "Lime"-s
        When I add a <fruit> to my basket
        Then the basket should have a price of <resulting cost> (in pence)

        Examples:
            |          initial list of fruits          | initial cost |  fruit  | resulting cost |
            |             "Apple", "Apple"             |      70      | "Apple" |       05       |
            |             "Apple", "Banana"            |      55      |"Banana" |       75       |
            |                 "Apple"                  |      35      | "Melon" |       85       |
            |             "Apple", "Melon"             |      85      | "Melon" |       85       |
            |     "Lime", "Lime", "Melon", "Melon"     |      80      | "Lime"  |       80       |
            | "Lime", "Lime", "Lime", "Melon", "Melon" |      80      | "Lime"  |       95       |