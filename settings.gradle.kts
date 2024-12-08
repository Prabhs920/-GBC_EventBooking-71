rootProject.name = "GBC_EventBooking-84"


include(":BookingService")
project(":BookingService").projectDir = file("BookingService")


include(":RoomService")
project(":RoomService").projectDir = file("RoomService")

