## PostkodeAppen

This application is the result of a mini-project in the course IDATT2001 Programmering2 and is worth 60% of the grade.

Project opening: 10.05.2021 09:00

Project delivery: 14.05.2021 14:00

#### Assignment limitations and assumptions:
For this assignment i have chosen to write the GUI in Norwegian as an app with only Norwegian postal codes in English makes less sense. All code is still written in English.

This application does not have any file writing as it makes no sense to be able to change the file with postal address data, and the app does not contain any other data files.

The application has file reading, and the data file with postal codes can be downloaded from [Bring.no](https://www.bring.no/tjenester/adressetjenester/postnummer/postnummertabeller-veiledning).



#### About the application:

The application has a register of all postal addresses in Norway including Svalbard and Jan Mayen islands.

The application has a table with all postal addresses.

The user can search by either area or postal code and the table will display all matching or partially matching results. If there is no matching results the user will be told so by a placeholder label in the table.

On start up the application will automatically read the data file into the register and fill the table with all postal codes.

The application GUI is in Norwegian, and all code is in English.

The application GUI is made with JavaFX, and the code is written in Java.

The application code is tested with JUnit 5 to assure good behavior.

The postal address data is downloaded from [Bring.no](https://www.bring.no/tjenester/adressetjenester/postnummer/postnummertabeller-veiledning) section three (Tab- separated Ansi/Windows format).

#### Help:
To update the file with postal addresses follow these steps:
1. Download the data file from [Bring.no](https://www.bring.no/tjenester/adressetjenester/postnummer/postnummertabeller-veiledning) section three (Tab- separated Ansi/Windows format).
2. Rename the file to "Postnummerregister.txt". Nb! Remember capital P.
3. place the file in the src/main/resources/no/ntnu/eventu folder. Press yes to overwrite existing file if prompted.