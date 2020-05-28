# Asymmetrical-Android
Repository for an Android App for Computer Science 449 at UMKC

## About
Asymmetrical Android is an Android app that I have designed because I did not like the stock Android note taking experience. When I embarked upon the creation of this app, there aren't many well suited apps that I liked. Thus, I will create my own. Here, is where I decided that I will be continuing the app development outside of the course that is taught at the University of Missouri - Kansas City. As a part of my summer goals found [here](https://christopherswayne.com/post/summer_plans), I am continuing to develop the app for Android, until I have a stable v-1.0 release that I can comfortably export as a full app. I don't currently have any plans to upload the final project to the Google Play Store, but I intend to build it into an APK file that can be sideloaded for anyone to use. The source code is here, and auditable, as to allow others to expand upon my work, and for there to be evidence of no data collection or privacy invasive portions of code. 

## Current Status as of 28 May 2020
Currently, the application is still in its infancy, and doesn't have the following:
* UI
* Business Logic
* Persistent Storage

What is completed: 
* SQLite database design/preliminary implementation

The project doesn't have the full UI designed, only some views and portions of the Interface. The SQLite database has had its framework laid out, and can now have the business logic tied into the app. However, the SQLite database has some minor issues to the design that need to be resolved:
* All the _Chapters_ are stored in a single table, _Book_, without any reference as to which "Book" they belong to - due to no current link between the _Bookshelf_ and _Book_ tables.
* _Book-Catalogue_ doesn't have any present methods to enter or alter records in the table. 

## Goals for 31 May 2020
- [ ] Fix _Book-Catalogue_ and add the foreign keys/references from _Book_ and _Bookshelf_ tables 

## Goals for 7 June 2020
- [ ] Build UI for all User-Inteface interactions within the app

## Goals for 14 June 2020
- [ ] Build Business logic for all UI interactions to function within the app - a controller of sorts to interact between the UI and the database.