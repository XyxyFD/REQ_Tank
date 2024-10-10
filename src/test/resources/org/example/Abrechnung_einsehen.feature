Feature: Abrechnung einsehen
  Als Kunde möchte ich meine Abrechnungen für die durchgeführten Ladevorgänge einsehen können, um die Kosten und Details der Ladevorgänge zu überprüfen.

  Background:
    Given der Kunde ist in der App eingeloggt
    And der Kunde hat mindestens einen abgeschlossenen Ladevorgang

  Scenario: Letzte Abrechnung anzeigen
    When der Kunde die Ansicht „Abrechnungen“ auswählt
    Then sollte die letzte Abrechnung für den letzten Ladevorgang angezeigt werden
    And die Abrechnung sollte Datum, Ladezeit, kWh, Preis pro kWh und Gesamtkosten enthalten

  Scenario: Abrechnungen über einen bestimmten Zeitraum einsehen
    When der Kunde den Zeitraum „letzte 30 Tage“ auswählt
    Then sollten alle Abrechnungen der letzten 30 Tage angezeigt werden
    And jede Abrechnung sollte mit Datum, Ladezeit, kWh, Preis pro kWh und Gesamtkosten aufgeführt sein

  Scenario: Abrechnung im Detail anzeigen
    Given der Kunde hat die Übersicht der Abrechnungen geöffnet
    When der Kunde eine spezifische Abrechnung auswählt
    Then sollten die detaillierten Informationen zu dieser Abrechnung angezeigt werden
    And die Details sollten den Ladevorgang, Standort, Ladezeit, kWh, Preis pro kWh, Gesamtkosten und etwaige Rabatte umfassen

