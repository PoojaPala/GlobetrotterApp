
# GlobetrotterApp 

GlobetrotterApp is a travel booking application that provides users with a seamless experience for booking flights, selecting seats, managing boarding passes. The app features a user-friendly interface to enter passenger details, select travel locations, and choose cabin class. 



## Table of Contents

- Features
- Project Structure
- Screenshots
- Technologies Used
- Setup and Installation
- Contributors


## Features

#### SplashScreenActivity :- 
- Description : The SplashScreenActivity is the initial activity that shows a splash screen when the app is launched. It provides a visually appealing introduction while loading necessary resources.
- Key Features : Displays the app logo and name. Transition to SignUpActivity after a short delay or once initialization is complete.
<img width="198" alt="" src="https://github.com/user-attachments/assets/efcf5746-ff1e-4c22-bffa-9726dc59ba48">

#### SignUpActivity :- 
- Description : The SignUpActivity facilitates the registration of new users. It collects necessary information to create a user account.
- Key Features : Input fields for email, password, and other required details. Redirect to SignInActivity upon successful registration.
<img width="198" alt="" src="https://github.com/user-attachments/assets/6136bd0c-52ba-4a35-9db7-e46485ba6c61">

#### SignInActivity :- 
- Description : The SignInActivity allows users to sign in to their accounts using their credentials. It ensures secure access to the app’s features.
- Key Features : Input fields for email and password. Redirect to MainActivity for new users.
<img width="198" alt="" src="https://github.com/user-attachments/assets/7627a512-f163-4c74-8ceb-ab4e6a7bb80f">

#### MainActivity :- 
- Description : The MainActivity serves as the entry point of the app, offering navigation to various other activities such as flight booking, seat selection, and country information. It provides a dashboard overview of the app’s features.
- Key Features : Display an overview of popular cities and recommended packages. Quick links to book flights, view boarding passes, and access country information.
<img width="198" alt="" src="https://github.com/user-attachments/assets/915b263e-10c3-4fa2-877f-9615da7f0927">

#### TravelActivity :- 
- Description : The TravelActivity provides detailed information about user and various countries for travel. 
- Key Features : Display a list of countries with airport code information. 
<img width="198" alt="" src="https://github.com/user-attachments/assets/4317ee10-dd4d-4ace-944e-f3ca3a57e653">
<img width="198" alt="" src="https://github.com/user-attachments/assets/bbbd655b-86e7-45d1-bbb5-5ec9b9c995ae">
<img width="198" alt="" src="https://github.com/user-attachments/assets/50884d7a-1f69-4478-9bcf-f8d5867239f1">


#### FlightBookActivity :- 
- Description : The FlightBookActivity allows users to search for available flights based on specified criteria such as origin, destination, and travel dates. It facilitates the flight booking process and confirms reservations.
- Key Features : Input fields for selecting origin, destination, and travel dates. Display a list of available flights matching the search criteria. Allow users to select a flight and proceed to booking. Confirm booking and provide a summary of the reservation.
<img width="198" alt="" src="https://github.com/user-attachments/assets/90da153d-4e30-4c38-b8b1-1491c280bd19">

#### FlightDetailsActivity :- 
- Description : The FlightDetailsActivity provides detailed information about a selected flight. It displays all relevant flight details, including departure and arrival times, duration, airline.
- Key Features : Show comprehensive flight information. Displays amenities provided in the flight.
<img width="198" alt="" src="https://github.com/user-attachments/assets/67da7319-4377-4088-84c2-e5740b375d79">

#### SeatSelectionActivity :- 
- Description : The SeatSelectionActivity enables users to select their preferred seats for booked flights. 
- Key Features : Visual seat map with available and occupied seats. Allow users to select or change seats. Confirm seat selection and update the booking details.
<img width="198" alt="" src="https://github.com/user-attachments/assets/6a85d384-a4bb-4aba-ac70-ff1d3ea38e81">
<img width="198" alt="" src="https://github.com/user-attachments/assets/e2f6a3df-656c-45f9-a58b-ff260bf8cbc3">


#### BoardingPassActivity :- 
- Description : The BoardingPassActivity manages the generation and display of digital boarding passes. It allows users to view their boarding passes for booked flights.
- Key Features : Display a list of boarding passes for the user’s upcoming flights. Show detailed information on each boarding pass, including flight details, seat number, and QR code. 
<img width="198" alt="" src="https://github.com/user-attachments/assets/ed9f35c9-268e-4762-8289-17f473696f29">


## Technologies Used

- **Programming Language :** Kotlin
- **Development Environment :** Android Studio
- **UI Components: :** ConstraintLayout, CardView, RecyclerView

## Setup and Installation
- Clone the repository : git clone https://github.com/PoojaPala/GlobetrotterApp.git
- Open the project in Android Studio.
- Sync the project with Gradle files.
- Build and run the app on an emulator or physical device.


## Collaborators
- Priyamvada Murudkar :- https://github.com/PriyamM19
- Gowthami Sai Sree Pooja Pala :- https://github.com/PoojaPala
- Jumaina Rahman Neen :- https://github.com/neen95
- Debnath Saummya Protyay :- https://github.com/DebnathSaummyaProtyay
- Foram Patel :- https://github.com/Foram2248
