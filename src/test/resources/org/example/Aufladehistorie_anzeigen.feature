Feature: Aufladehistorie anzeigen
  Als Kunde möchte ich meine Aufladehistorie einsehen können, um meine bisherigen Aufladungen und den Kontostand nachvollziehen zu können.

  Background:
    Given ein registrierter Kunde ist eingeloggt
    And der Kunde hat mindestens eine Aufladung durchgeführt
    And der Kunde befindet sich auf der Seite „Aufladehistorie“

  Scenario: Aufladehistorie anzeigen
    When der Kunde die Seite „Aufladehistorie“ öffnet
    Then sollte eine Liste aller bisherigen Aufladungen angezeigt werden
    And jede Aufladung sollte das Datum, den Betrag und die Zahlungsmethode (z. B. Kreditkarte, PayPal) anzeigen

  Scenario: Details einer spezifischen Aufladung anzeigen
    Given die Aufladehistorie ist sichtbar
    When der Kunde eine spezifische Aufladung aus der Liste auswählt
    Then sollten die Details der Aufladung angezeigt werden
    And die Details sollten das Aufladedatum, den Betrag, die Zahlungsmethode und die Transaktions-ID umfassen

  Scenario: Aufladehistorie nach Zeitraum filtern
    Given die Aufladehistorie ist sichtbar
    When der Kunde einen Zeitraum (z. B. „letzter Monat“) auswählt
    Then sollten nur die Aufladungen innerhalb des gewählten Zeitraums angezeigt werden
    And die Summe aller Aufladungen im Zeitraum sollte unten angezeigt werden
