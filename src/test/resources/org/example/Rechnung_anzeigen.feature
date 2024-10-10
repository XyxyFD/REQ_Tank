Feature: Rechnung anzeigen
  Als Kunde möchte ich meine Rechnungen einsehen können, um die Details meiner Ausgaben und Zahlungen nachvollziehen zu können.

  Background:
    Given ein registrierter Kunde ist eingeloggt
    And der Kunde befindet sich auf der Seite „Rechnungen“

  Scenario: Liste der Rechnungen anzeigen
    When der Kunde die Seite „Rechnungen“ öffnet
    Then sollte der Kunde eine Liste seiner bisherigen Rechnungen sehen
    And jede Rechnung sollte das Rechnungsdatum, den Betrag und den Status (bezahlt/offen) anzeigen

  Scenario: Details einer Rechnung anzeigen
    Given die Liste der Rechnungen ist sichtbar
    When der Kunde eine spezifische Rechnung aus der Liste auswählt
    Then sollten die Details der Rechnung angezeigt werden
    And die Details sollten die Rechnungsnummer, das Rechnungsdatum, den Standortname und Ladepunkt, den Lademodus, Dauer der Nutzung und geladene Leistung und den Gesamtbetrag umfassen
