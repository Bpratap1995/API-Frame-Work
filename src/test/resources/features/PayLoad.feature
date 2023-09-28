Feature: Validating place API's
  
  @AddPlace
  Scenario Outline: Verify if place is being successfully added using AddplaceAPI
   Given Add place payload with "<name>" "<language>" "<Address>"
   When user calls "AddPlaceApi" with "post" http request
   Then the api call got  success with status code 200
   And "status" in response body is "OK"
   And Verify placeId created maps to "<name>" using "getPlaceAPI"
   
  
  Examples:
  |name           |language   |Address                 |
  |bhanu          |hindi      | bihar                  |
  
 @DeletePlace
  Scenario: Verify if delete place functionality is working
  Given Delete PlacePayload
  When user calls "DeletePlaceAPI" with "post" http request
  Then the api call got  success with status code 200
   And "status" in response body is "OK"