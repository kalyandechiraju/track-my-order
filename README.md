# Track My Order

An app for tracking the order on map in real time. The key benefits include:

- Provide an easy way for the delivery boys to `update status` of orders easily with just a few clicks.
- Provide a convenient and frustration free way to `track orders on map ` in Real Time and also showing ETA.
- **Avoid Phone Calls** by sending `Notifications` automatically to the user
	- when the status of order changes
	- when the delivery boy approaches the destination
- Also provide an easy way to reach destination for the `New Delivery boys` by providing the `Customer's location` .

## Technology

- Android App
	- We are Android developers, so we chose Android platform. Same can be implemented in other platform by using existing backend.
- `Firebase` database
	- Used as backend of the application and for real time data syncing.
- Google Maps API
	- Used to show Maps from within the app in a convenient way.

## Where it fits

This module can be implemented in other existing apps of delivery vendors.

## Flow

![applicaition-flow](https://raw.githubusercontent.com/kalyandechiraju/track-my-order/master/ScreenShot2016-05-15.png)

## Further plan

- We can extend this further by **auto allocating orders** to delivery boys (who is on the move) based on their current location and the order pickup location. Thus `optimising` the delivery process.


## Where are we

The implementation of the app is completed except for the part of Notifications. Little bit tweaking is needed to update the location of delivery boy and send the Notification based on the distance between the Customer's location and the Delivery Boy's.
