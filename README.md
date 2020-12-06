# Serwis do obsługi nieruchomości :house_with_garden: [![Build status](https://github.com/pbarcicki/real-estate-manager/workflows/Build/badge.svg)](https://github.com/pbarcicki/real-estate-manager/actions)

W ramach projektu należy utworzyć system umożliwiający zarządzanie bazą dostępnych nieruchomości we Wrocławiu. System ma pozwalać na wyszukiwanie mieszkań wg kryteriów i rezerwację. 

## Główne funkcje systemu :muscle:

* Wyszukiwanie mieszkań wg kryteriów
* Zarządzanie listą dostępnych nieruchomości
  * Dodanie, usunięcie i edycję nieruchomości 
  * Zmiana statusu (dostępne/rezerwacja/sprzedane)
  * Dodanie zdjęć/planów mieszkania/budynku 
  * Możliwość wstępnej rezerwacji mieszkania
* Zarządzanie bazą deweloperów, klientów i sprzedawców
  * Dodanie, usunięcie i edycja
  * Przydzielenie ról
* Generator ofert i możliwości wysyłki na maila lub generowanie pdf

## Podstawowe byty _(encje)_
### BUDYNEK
* __Lokalizacja__
  * adres _(województwo, miasto, dzielnica, ulica i nr budynku)_
  * pozostałe informacje (#hashtagi)
* __Udogodnienia w pobliżu__ _(i odległość do nich)_
  * przedszkola i szkoły
  * centra handlowe
  * parki, rzeki/jeziora
  * dojazd do centrum miasta (rodzaj komunikacji)
  * odległość do przystanków (min)
* __Szczegóły budynku__
  * deweloper
  * konstrukcja
  * parking / garaż
  * inne szczegóły
  * Winda?
  * Rynek 
  * Sekcja (kolej)
  * Do oddania
  * Czy już oddany
  * Czy media doprowadzone
  * ZDJĘCIA
### Mieszkanie
* __Szczegóły__
  * piętro
  * wielkość mieszkania
  * ilość pokoi
  * rodzaj kuchni
  * cena/m2
  * orientacja
* __Dodatkowe informacje__
  * zdjęcia
  * komentarze
  * status _(rezerwacja)_
  * planowanie mieszkań
  * komórka lokatorska
  
### Deweloper
 * nazwa
 * osoba kontaktowe (imię, nazwisko, telefon i e-mail)
### Klient
 * imię i nazwisko
 * data zarejestrowania klienta
 * dane kontaktowe (telefon i e-mail)
 * wymagania co do mieszkania
### Użytkownik 
 * nazwa
 * rola (stanowisko)
 * e-mail
 * hasło
 
 ##Funkcjonalność
 
 to be continued...