# How to start
Use *src/test/resources/suite.xml* to start all cases.  
Also, it's possible to start each test separately.
# DownloadInstallSteam test
* **Step 1** Open *Steam* website.
* **Step 2** Go to *Install Steam* page.
* **Step 3** Click *install Steam* button.
* **Step 4** Check *SteamSetup.exe* file is downloaded.
***
# GameWithMaxDiscount test
* **Step 1** Open *Steam* website.
* **Step 2** Select *Action* genre in *Games* dropdown.
* **Step 3** Go to *Top Sellers* tab.
* **Step 4** Find a game with the highest discount.
* **Step 5** Remember the game *Name*, *Price* and *Discount*.
* **Step 6** Go to the game page.
  * **Step 6.1** Fill *Age Check* fields if it appear.
* **Step 7** Check *Name*, *Price* and *Discount* from the game page the same as in *Step 5*.
***
# JSON configs
## config.json
### startURL
Start page for the tests. Used in *BaseTest*->*@BeforeMethod*.
### browser
*Chrome* or *Firefox*.
### timeout
Default value for the *Implicitly Wait* parameter.
### pollingTime
Period in *milliseconds*.The system checks every *%pollingTime%* for the downloaded file.
### downloadTimeout
Time in *seconds*. If file is not downloaded in *%downloadTimeout%* the case will Fail.
### fileName
Name of the downloaded file.
### fileSize
Size of the downloaded file in *bytes*.
***
## browser.json
Configs for *Chrome* and *Firefox* browsers.
***
# Logs
Location -> */logs/*.  
XML config -> *src/main/resources/log4j2.xml*.
