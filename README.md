# Serwis do obsługi nieruchomości :house_with_garden: [![Build status](https://github.com/pbarcicki/real-estate-manager/workflows/Build/badge.svg)](https://github.com/pbarcicki/real-estate-manager/actions)

W ramach projektu należy utworzyć system umożliwiający zarządzanie bazą dostępnych nieruchomości we Wrocławiu. System ma pozwalać na wyszukiwanie mieszkań wg kryteriów i rezerwację. 

## Główne funkcje systemu :muscle:
_funkcje opcjonalne_ :toolbox:
* Wyszukiwanie mieszkań wg kryteriów
* Zarządzanie listą dostępnych nieruchomości
  * Dodanie, usunięcie i edycję nieruchomości 
  * Zmiana statusu (dostępne/rezerwacja/sprzedane)
  * Dodanie zdjęć/planów mieszkania/budynku 
  * Możliwość wstępnej rezerwacji mieszkania
* Zarządzanie bazą deweloperów, klientów i sprzedawców
  * Dodanie, usunięcie i edycja
  * Przydzielenie ról
* _Generator ofert i możliwości wysyłki na maila lub generowanie pdf_ :toolbox:
* _Lista zadań dla sprzedawców_ :toolbox:

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
### Role
 * admin
 * sprzedawca
 * starszy sprzedawca _(+możliwość dodawania mieszkań)_
 ### _Notatki_ :toolbox:
 * data i czas dodania
 * data zakończenia
 * priorytet
 * treść
 * tytuł
 * umieszczona przez __admina__?
 
## Funkcjonalność
_funkcje opcjonalne_ :toolbox:

### Wyszukiwanie nieruchomości :mag:
 * wyświetlanie listy wyszukiwania wg podanych kryteriów
 * możliwość sortowanie listy
### Zarządzanie nieruchomościami :computer:
* funkcjonalność realizowana przez dedykowany panel
* dodawanie, usuwanie oraz edycja `Mieszkań` i `Budynków` możliwa tylko przez __starszego sprzedawcę__ i __admina__ 
* modyfikacja `Dewelopera` możliwa jedynie przez __admina__
* możliwość zmiany statusu `Mieszkania` na `dostępne`/`zarezerwowane`/`sprzedane`
* status `sprzedane` ustawić może tylko __admin__ 
### Zarządzania sprzedawcami
* funkcjonalność realizowana przez dedykowany panel
* rejestracja, usuwanie i przydzielanie ról __sprzedawców__ możliwa tylko przez __admina__
### Sprzedawca 
* po zarejestrowaniu przez __admina__ otrzymuje maila z potwierdzeniem założenia konta i hasłem jednorazowym 
* podczas pierwszego logowania __sprzedawca__ jest proszony o zmianę hasła 
* każdy __sprzedawca__ posiada własny panel, gdzie widzi:
  * swoich `Klientów`
  * _swoje `Zadania` z uwzględnieniem ich priorytetu_ :toolbox:
  * _ostatnio dodane `Mieszkania`_ :toolbox:
### Starsz sprzedawca
* ta sama funkcjonalność co zwykły sprzedawca
* dodatkowo może dodawać, usuwać oraz edytować `Mieszkania` i `Budynki`
### Zarządzanie klientami
* funkcjonalność realizowana przez dedykowany panel
* dodawanie, usuwanie i edycja `Klientów`
* usuwanie możliwe tylko przez __admina__ i __starszego sprzedawcę__
* przypisanie konkretnego sprzedawcy
### ToDo Lista dla sprzedawców
* funkcjonalność realizowana przez dedykowany panel
* dodawanie, usuwanie i modyfikacja notatek
### Admin (Dyrektor)
* posiada własny panel administratora
* ma możliwość przydzielenia nowych `Zadań` dla __sprzedawcy__
* może dodawać, edytować oraz usuwać:
  * `Mieszkania`, `Budynki`, `Deweloperów`
  * `Klientów`
  * sprzedawców (w tym zmiana roli)