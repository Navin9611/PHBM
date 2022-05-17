Feature: Client Deposit Cash
 
  Background: Logged In
    Given I am logged into Mambu
    And Search for Client
    And click on Client
    And click on Branch Banking Member
    And Click on Deposit Tab

  Scenario Outline: Cash Deposit of Client
    When go to Cash page
    And Select CAD from Currency Type
    And enter client details
      | FiveBundled   | FiveLoose   | TenBundled   | TenLoose   | TwentyBundled   | TwentyLoose   | FiftyBundled   | FifyLoose   | Hundred Bundled   | HundredLoose   | FiveCoinRolls   | TenCoinRolls   | TwentyFiveCoinRolls   | OneCoinRolls   | TwoCoinRolls   | FiveCoinLoose   | TenCoinLoose   | TwentyFiveCoinLoose   | OneCoinLoose   | TwoCoinLoose    |
      | <FiveBundled> | <FiveLoose> | <TenBundled> | <TenLoose> | <TwentyBundled> | <TwentyLoose> | <FiftyBundled> | <FifyLoose> | <Hundred Bundled> | <HundredLoose> | <FiveCoinRolls> | <TenCoinRolls> | <TwentyFiveCoinRolls> | <OneCoinRolls> | <TwoCoinRolls> | <FiveCoinLoose> | <TenCoinLoose> | <TwentyFiveCoinLoose> | <OneCoinLoose> | <TwoCoinLoose > |
    And Select Avaliable Accounts
    Then click on Submit button

    Examples: 
      | FiveBundled | FiveLoose | TenBundled | TenLoose | TwentyBundled | TwentyLoose | FiftyBundled | FifyLoose | Hundred Bundled | HundredLoose | FiveCoinRolls | TenCoinRolls | TwentyFiveCoinRolls | OneCoinRolls | TwoCoinRolls | FiveCoinLoose | TenCoinLoose | TwentyFiveCoinLoose | OneCoinLoose | TwoCoinLoose |
      |           1 |         1 |          1 |        1 |             1 |           1 |            1 |         1 |               1 |            1 |             1 |            1 |                   1 |            1 |            1 |             1 |            1 |                   1 |            1 |            1 |
